package codecrusaders.business;

import codecrusaders.domain.nestedstructure.SubTest;

import java.util.List;

public interface ISubTestService {
    SubTest createSubTest(SubTest subTest);
    SubTest getSubtestById(Long id);
    List<SubTest> getSubtestsByRegressionTestId(Long regressionTestId);
    List<SubTest> getSubtests();
}
