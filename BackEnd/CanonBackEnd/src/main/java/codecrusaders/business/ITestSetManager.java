package codecrusaders.business;

import codecrusaders.domain.*;
import codecrusaders.repository.entity.TestSetEntity;

import java.util.Optional;

public interface ITestSetManager {
    CreateTestSetResponse createTestSet(CreateTestSetRequest request);
    GetTestSetResponse getAllTestSets();
}
