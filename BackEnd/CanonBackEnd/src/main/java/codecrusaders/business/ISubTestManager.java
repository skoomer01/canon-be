package codecrusaders.business;

import codecrusaders.domain.*;

public interface ISubTestManager {
    CreateSubTestResponse registerSubTest(CreateSubTestRequest request);
    GetSubTestsResponse getSubTests();
     GetSubTestsResponse findById(Long id);

    CountFailedTestStepResponse countFailedTestStep(CountFailedTestStepRequest request);
    CountFailedTestStepResponse countTotalTestStep(CountFailedTestStepRequest request);
    GetSubTestsResponse getSubTestsByTestID(Long id);

}
