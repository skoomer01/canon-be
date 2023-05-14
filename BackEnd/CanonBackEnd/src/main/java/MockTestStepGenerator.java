import codecrusaders.domain.nestedstructure.RegressionTest;
import codecrusaders.domain.nestedstructure.SubTest;
import codecrusaders.domain.nestedstructure.TestSet;
import codecrusaders.domain.nestedstructure.TestStep;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockTestStepGenerator {
    public static List<TestStep> generateMockData(List<SubTest> subTests) {
        List<TestStep> testSteps = new ArrayList<>();

        for (SubTest r : subTests) {
            for (int i = 1; i <= 5; i++) {
                String name = r.getName() + " - Test Step " + i;

                TestStep t = TestStep.builder()
                        .name(name)
                        .subTest(r)
                        .description(generateTestStepDescription())
                        .build();

                testSteps.add(t);
            }
        }

        return testSteps;
    }

    private static String generateTestStepDescription() {
        Random random = new Random();
        String[] keywords = {
                "Prepare the printer",
                "Load paper into the tray",
                "Configure printer settings",
                "Start the printing process",
                "Monitor print progress",
                "Check print quality",
                "Perform maintenance tasks",
                "Adjust print settings",
                "Test printer connectivity",
                "Verify printer firmware version"
        };

        int keywordIndex = random.nextInt(keywords.length);
        String description = keywords[keywordIndex];
        return description;
    }
}
