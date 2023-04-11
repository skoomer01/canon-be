package codecrusaders.business;

import codecrusaders.domain.TestBatch;
import codecrusaders.domain.TestSet;

public interface TestSetManager {
    public TestSet RegisterTest(TestBatch testBatch, String name);
}
