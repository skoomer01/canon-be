package codecrusaders.business;

import codecrusaders.domain.*;

public interface ISubTestManager {
    CreateSubTestResponse registerSubTest(CreateSubTestRequest request);
    GetSubTestsResponse getSubTests();

    GetSubTestsResponse getSubTestsByTestID(Long id);

}
