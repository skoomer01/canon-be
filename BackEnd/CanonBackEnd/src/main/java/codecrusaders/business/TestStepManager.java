package codecrusaders.business;

import codecrusaders.domain.SubTest;
import codecrusaders.domain.TestStep;

public interface TestStepManager {
    public TestStep registerTestStep(SubTest subTest, String name);
}
