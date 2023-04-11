package codecrusaders.business;

import codecrusaders.domain.Branch;
import codecrusaders.domain.TestBatch;

public interface TestBatchManager {
    public TestBatch registerTestBatch(Branch branch, String name, String commitShal);
}
