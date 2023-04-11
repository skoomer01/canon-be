package codecrusaders.business;

import codecrusaders.domain.RegressionTest;
import codecrusaders.domain.SubTest;

public interface SubTestManager {
    public SubTest registerSubTest(RegressionTest test, String name);
}
