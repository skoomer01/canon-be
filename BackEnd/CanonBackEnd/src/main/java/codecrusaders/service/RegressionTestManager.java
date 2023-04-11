package codecrusaders.service;

import codecrusaders.domain.RegressionTest;
import codecrusaders.domain.TestSet;

public interface RegressionTestManager {
    public RegressionTest registerTest(TestSet testSet, String name);
}
