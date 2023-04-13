package codecrusaders.business;

import codecrusaders.domain.*;

public interface ITestStepManager {
    CreateTestStepResponse registerTestStep(CreateTestStepRequest request);
    GetTestStepsResponse getTestSteps();
}
