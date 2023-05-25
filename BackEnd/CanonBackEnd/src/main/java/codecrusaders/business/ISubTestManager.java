package codecrusaders.business;

import codecrusaders.domain.*;

public interface ISubTestManager {
    CreateSubTestResponse registerSubTest(CreateSubTestRequest request);
    GetSubTestsResponse getSubTests();
     GetSubTestsResponse findById(Long id);

    GetSubTestsResponse getSubTestsByTestID(Long id);

}
