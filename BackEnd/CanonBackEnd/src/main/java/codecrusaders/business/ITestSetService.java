package codecrusaders.business;

import codecrusaders.domain.core.TestSet;

import java.util.List;

public interface ITestSetService {
    TestSet createTestSet(TestSet testSet);
    TestSet getTestSetById(Long id);
    List<TestSet> getTestSetsByTestBatchId(Long testBatchId);
    List<TestSet> getTestSets();
}
