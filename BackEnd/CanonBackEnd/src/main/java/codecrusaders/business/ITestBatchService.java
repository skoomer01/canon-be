package codecrusaders.business;

import codecrusaders.domain.core.TestBatch;
import codecrusaders.domain.core.TestSet;

import java.util.List;

public interface ITestBatchService {
    TestBatch createTestBatch(TestSet testSet);
    TestBatch getTestBatchesById(Long id);
    List<TestBatch> getTestBatchesByBranchId(Long BranchId);
    List<TestBatch> getTestBatches();
}
