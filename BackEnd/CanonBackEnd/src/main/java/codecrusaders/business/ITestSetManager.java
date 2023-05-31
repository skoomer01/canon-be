package codecrusaders.business;

import codecrusaders.domain.*;


public interface ITestSetManager {
    CreateTestSetResponse createTestSet(CreateTestSetRequest request);
    GetTestSetResponse getAllTestSets();
    GetLatestTestSetsResponse getLatestTestSets();
}
