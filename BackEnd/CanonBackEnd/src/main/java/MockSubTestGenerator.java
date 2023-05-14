import codecrusaders.domain.nestedstructure.RegressionTest;
import codecrusaders.domain.nestedstructure.SubTest;

import java.util.ArrayList;
import java.util.List;

public class MockSubTestGenerator {
    public static List<SubTest> generateMockData(List<RegressionTest> regressionTests) {
        List<SubTest> subTests = new ArrayList<>();

        for (RegressionTest r : regressionTests) {
            for (int i = 1; i <= 5; i++) {
                String subTestName = r.getName() + " - SubTest " + i;

                SubTest subTest = SubTest.builder()
                        .name(subTestName)
                        .regressionTest(r)
                        .build();

                subTests.add(subTest);
            }
        }

        return subTests;
    }
}
