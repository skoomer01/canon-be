package codecrusaders.business;

import codecrusaders.domain.nestedstructure.TestStep;

import java.util.List;

public interface ITestStepService {
    TestStep createTestStep(TestStep testStep);
    TestStep getTestStepById(Long id);
    List<TestStep> getTestStepsBySubTestId(Long subTestId);
    List<TestStep> getTestSteps();
}
