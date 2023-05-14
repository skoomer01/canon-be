package codecrusaders.business;

import codecrusaders.domain.nestedstructure.RegressionTest;

import java.util.List;

public interface IRegressionTestService {

    RegressionTest createRegressionTest(RegressionTest regressionTest);
    RegressionTest getRegressionTestById(Long id);
    List<RegressionTest> getRegressionTestsByTestSetId(Long testSetId);
    List<RegressionTest> getRegressionTests();
}
