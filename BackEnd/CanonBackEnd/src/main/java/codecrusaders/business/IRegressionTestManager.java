package codecrusaders.business;

import codecrusaders.domain.*;

public interface IRegressionTestManager {
    CreateRegrTestResponse createRegressionTest(CreateRegrTestRequest request);
    GetRegressionTestResponse getAllRegrTests();
}
