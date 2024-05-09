/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.backend.common

import org.jetbrains.kotlin.config.IrVerificationMode
import org.jetbrains.kotlin.ir.IrBuiltIns
import org.jetbrains.kotlin.ir.IrElement
import org.jetbrains.kotlin.ir.declarations.IrDeclaration
import org.jetbrains.kotlin.ir.declarations.IrDeclarationParent
import org.jetbrains.kotlin.ir.declarations.IrFile
import org.jetbrains.kotlin.ir.declarations.name
import org.jetbrains.kotlin.ir.util.DeclarationParentsVisitor
import org.jetbrains.kotlin.ir.util.dump
import org.jetbrains.kotlin.ir.util.render
import org.jetbrains.kotlin.ir.visitors.IrElementVisitorVoid
import org.jetbrains.kotlin.ir.visitors.acceptChildrenVoid
import org.jetbrains.kotlin.ir.visitors.acceptVoid

data class IrValidatorConfig(
    val abortOnError: Boolean, // TODO: This property is unused, remove it
    val ensureAllNodesAreDifferent: Boolean,
    val checkTypes: Boolean = true,
    val checkDescriptors: Boolean = true,
    val checkProperties: Boolean = false,
    val checkScopes: Boolean = false,
)

class IrValidator(
    val irBuiltIns: IrBuiltIns,
    val config: IrValidatorConfig,
    val reportError: (IrFile?, IrElement, String) -> Unit
) : IrElementVisitorVoid {

    var currentFile: IrFile? = null

    override fun visitFile(declaration: IrFile) {
        currentFile = declaration
        super.visitFile(declaration)
        if (config.checkScopes) {
            ScopeValidator(this::error).check(declaration)
        }
    }

    private fun error(element: IrElement, message: String) {
        reportError(currentFile, element, message)
    }

    private val elementChecker = CheckIrElementVisitor(irBuiltIns, this::error, config)

    override fun visitElement(element: IrElement) {
        element.acceptVoid(elementChecker)
        element.acceptChildrenVoid(this)
    }
}

fun IrElement.checkDeclarationParents() {
    val checker = CheckDeclarationParentsVisitor()
    accept(checker, null)
    if (checker.errors.isNotEmpty()) {
        val expectedParents = LinkedHashSet<IrDeclarationParent>()
        throw AssertionError(
            buildString {
                append("Declarations with wrong parent: ")
                append(checker.errors.size)
                append("\n")
                checker.errors.forEach {
                    append("declaration: ")
                    append(it.declaration.render())
                    append("\n\t")
                    append(it.declaration)
                    append("\nexpectedParent: ")
                    append(it.expectedParent.render())
                    append("\nactualParent: ")
                    append(it.actualParent?.render())
                    append("\n")
                    expectedParents.add(it.expectedParent)
                }
                append("\nExpected parents:\n")
                expectedParents.forEach {
                    append(it.dump())
                }
            }
        )
    }
}

class CheckDeclarationParentsVisitor : DeclarationParentsVisitor() {
    class Error(val declaration: IrDeclaration, val expectedParent: IrDeclarationParent, val actualParent: IrDeclarationParent?)

    val errors = ArrayList<Error>()

    override fun handleParent(declaration: IrDeclaration, actualParent: IrDeclarationParent) {
        try {
            val assignedParent = declaration.parent
            if (assignedParent != actualParent) {
                errors.add(Error(declaration, assignedParent, actualParent))
            }
        } catch (e: Exception) {
            errors.add(Error(declaration, actualParent, null))
        }
    }
}

/**
 * Verifies common IR invariants that should hold in all the backends.
 */
fun performBasicIrValidation(
    context: CommonBackendContext,
    fragment: IrElement,
    mode: IrVerificationMode = IrVerificationMode.ERROR,
    checkProperties: Boolean = false,
    checkTypes: Boolean = false,
) {
    val validatorConfig = IrValidatorConfig(
        abortOnError = mode == IrVerificationMode.ERROR,
        ensureAllNodesAreDifferent = true,
        checkTypes = checkTypes,
        checkDescriptors = false,
        checkProperties = checkProperties,
    )
    val validator = IrValidator(context.irBuiltIns, validatorConfig) { file, element, message ->
        try {
            // TODO: render all element's parents.
            context.reportWarning(
                "[IR VALIDATION] ${"$message\n" + element.render()}", file,
                element
            )
        } catch (e: Throwable) {
            println("an error trying to print a warning message: $e")
            e.printStackTrace()
        }
        // TODO: throw an exception after fixing bugs leading to invalid IR.

        if (mode == IrVerificationMode.ERROR) {
            error("Validation failed in file ${file?.name ?: "???"} : ${message}\n${element.render()}")
        }
    }
    fragment.acceptVoid(validator)
    fragment.checkDeclarationParents()
}
