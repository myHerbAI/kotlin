/*
 * Copyright 2010-2024 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.analysis.api.fir.test.cases.generated.cases.components.typeRelationChecker;

import com.intellij.testFramework.TestDataPath;
import org.jetbrains.kotlin.test.util.KtTestUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.analysis.api.fir.test.configurators.AnalysisApiFirTestConfiguratorFactory;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfiguratorFactoryData;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiTestConfigurator;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.TestModuleKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.FrontendKind;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisSessionMode;
import org.jetbrains.kotlin.analysis.test.framework.test.configurators.AnalysisApiMode;
import org.jetbrains.kotlin.analysis.api.impl.base.test.cases.components.typeRelationChecker.AbstractTypeEqualityTest;
import org.jetbrains.kotlin.test.TestMetadata;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.regex.Pattern;

/** This class is generated by {@link org.jetbrains.kotlin.generators.tests.analysis.api.GenerateAnalysisApiTestsKt}. DO NOT MODIFY MANUALLY */
@SuppressWarnings("all")
@TestMetadata("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality")
@TestDataPath("$PROJECT_ROOT")
public class FirIdeNormalAnalysisSourceModuleTypeEqualityTestGenerated extends AbstractTypeEqualityTest {
  @NotNull
  @Override
  public AnalysisApiTestConfigurator getConfigurator() {
    return AnalysisApiFirTestConfiguratorFactory.INSTANCE.createConfigurator(
      new AnalysisApiTestConfiguratorFactoryData(
        FrontendKind.Fir,
        TestModuleKind.Source,
        AnalysisSessionMode.Normal,
        AnalysisApiMode.Ide
      )
    );
  }

  @Test
  public void testAllFilesPresentInSubtypingAndEquality() {
    KtTestUtil.assertAllTestsPresentByMetadataWithExcluded(this.getClass(), new File("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality"), Pattern.compile("^(.+)\\.kt$"), null, true);
  }

  @Test
  @TestMetadata("AnimalHuman.kt")
  public void testAnimalHuman() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/AnimalHuman.kt");
  }

  @Test
  @TestMetadata("AnimalHumanError.kt")
  public void testAnimalHumanError() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/AnimalHumanError.kt");
  }

  @Test
  @TestMetadata("AnimalHumanList.kt")
  public void testAnimalHumanList() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/AnimalHumanList.kt");
  }

  @Test
  @TestMetadata("AnimalHumanListError.kt")
  public void testAnimalHumanListError() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/AnimalHumanListError.kt");
  }

  @Test
  @TestMetadata("FlexibleList_Iterable.kt")
  public void testFlexibleList_Iterable() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/FlexibleList_Iterable.kt");
  }

  @Test
  @TestMetadata("HumanAnimal.kt")
  public void testHumanAnimal() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanAnimal.kt");
  }

  @Test
  @TestMetadata("HumanAnimalError.kt")
  public void testHumanAnimalError() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanAnimalError.kt");
  }

  @Test
  @TestMetadata("HumanAnimalList.kt")
  public void testHumanAnimalList() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanAnimalList.kt");
  }

  @Test
  @TestMetadata("HumanAnimalListError.kt")
  public void testHumanAnimalListError() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanAnimalListError.kt");
  }

  @Test
  @TestMetadata("HumanHuman.kt")
  public void testHumanHuman() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanHuman.kt");
  }

  @Test
  @TestMetadata("HumanHumanError.kt")
  public void testHumanHumanError() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanHumanError.kt");
  }

  @Test
  @TestMetadata("HumanHumanList.kt")
  public void testHumanHumanList() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanHumanList.kt");
  }

  @Test
  @TestMetadata("HumanHumanListError.kt")
  public void testHumanHumanListError() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/HumanHumanListError.kt");
  }

  @Test
  @TestMetadata("IntInt.kt")
  public void testIntInt() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/IntInt.kt");
  }

  @Test
  @TestMetadata("IntString.kt")
  public void testIntString() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/IntString.kt");
  }

  @Test
  @TestMetadata("IntersectionType_AMarker.kt")
  public void testIntersectionType_AMarker() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/IntersectionType_AMarker.kt");
  }

  @Test
  @TestMetadata("IntersectionType_BMarker.kt")
  public void testIntersectionType_BMarker() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/IntersectionType_BMarker.kt");
  }

  @Test
  @TestMetadata("ListTypeParameterDefinitelyNotNull_Iterable.kt")
  public void testListTypeParameterDefinitelyNotNull_Iterable() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/ListTypeParameterDefinitelyNotNull_Iterable.kt");
  }

  @Test
  @TestMetadata("ListTypeParameter_Iterable.kt")
  public void testListTypeParameter_Iterable() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/ListTypeParameter_Iterable.kt");
  }

  @Test
  @TestMetadata("StringBuilderTypeAlias.kt")
  public void testStringBuilderTypeAlias() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/StringBuilderTypeAlias.kt");
  }

  @Test
  @TestMetadata("UnboundedTypeParameter_Iterable.kt")
  public void testUnboundedTypeParameter_Iterable() {
    runTest("analysis/analysis-api/testData/components/typeRelationChecker/subtypingAndEquality/UnboundedTypeParameter_Iterable.kt");
  }
}
