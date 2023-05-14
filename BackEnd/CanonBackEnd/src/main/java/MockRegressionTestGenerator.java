import codecrusaders.domain.nestedstructure.RegressionTest;
import codecrusaders.domain.nestedstructure.TestSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockRegressionTestGenerator {
    private static final int MIN_HEAT = 30;
    private static final int MAX_HEAT = 60;
    private static final int MIN_DURATION = 10;
    private static final int MAX_DURATION = 40;

    public static List<RegressionTest> generateMockData(List<TestSet> testSets) {
        List<RegressionTest> regressionTests = new ArrayList<>();

        Random random = new Random();

        for (TestSet t : testSets) {
            for (int i = 1; i <= 5; i++) {
                String regressionTestName = t.getName() + " - RegressionTest " + (char) ('A' + i - 1);
                int heat = random.nextInt(MAX_HEAT - MIN_HEAT + 1) + MIN_HEAT;
                int duration = random.nextInt(MAX_DURATION - MIN_DURATION + 1) + MIN_DURATION;

                RegressionTest regressionTest = RegressionTest.builder()
                        .name(regressionTestName)
                        .heat(heat)
                        .duration(duration)
                        .testSet(t)
                        .build();

                regressionTests.add(regressionTest);
            }
        }

        return regressionTests;
    }
}
