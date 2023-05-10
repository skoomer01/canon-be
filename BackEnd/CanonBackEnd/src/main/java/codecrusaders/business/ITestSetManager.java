package codecrusaders.business;

import codecrusaders.domain.*;
import codecrusaders.repository.entity.TestSetEntity;



public interface ITestSetManager {
    CreateTestSetResponse createTestSet(CreateTestSetRequest request);
    GetTestSetResponse getAllTestSets();
}
