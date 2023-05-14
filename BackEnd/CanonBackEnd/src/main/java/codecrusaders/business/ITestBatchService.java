package codecrusaders.business;

import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.domain.nestedstructure.TestSet;

import java.util.List;

public interface ITestBatchService {
    TestBatch createTestBatch(TestBatch testBatcht);
    TestBatch getTestBatchesById(Long id);
    List<TestBatch> getTestBatchesByBranchId(Long BranchId);
    List<TestBatch> getTestBatches();
}
