import codecrusaders.CanonApp;
import codecrusaders.business.impl.BranchService;
import codecrusaders.domain.Enum.UserRole;
import codecrusaders.domain.Enum.Visibility;
import codecrusaders.domain.core.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Console {
    public static void main(String[] args) {
        try{
            ConfigurableApplicationContext context = SpringApplication.run(CanonApp.class, args);
            BranchService service = context.getBean(BranchService.class);

            ErrorMessage m = new ErrorMessage(12L, "Errormessage 1", 1L);

            List<TestStep> testSteps = new ArrayList<>();
            TestStep t = TestStep.builder()
                    .id(1L)
                    .subTestId(1L)
                    .description("Step 1")
                    .message(m)
                    .build();
            testSteps.add(t);
            TestStep t2 = TestStep.builder()
                    .id(2L)
                    .subTestId(1L)
                    .description("Step 2")
                    .build();
            testSteps.add(t2);

            List<SubTest> subTests = new ArrayList<>();
            SubTest s = SubTest.builder()
                    .id(1L)
                    .regressionTestID(1L)
                    .testSteps(testSteps)
                    .build();
            subTests.add(s);

            List<RegressionTest> regressionTests = new ArrayList<>();
            RegressionTest r = RegressionTest.builder()
                    .id(1L)
                    .heat(10)
                    .duration(30)
                    .testSetId(1L)
                    .subTests(subTests)
                    .build();
            regressionTests.add(r);

            List<TestSet> testSets = new ArrayList<>();
            TestSet testSet = TestSet.builder()
                    .id(1L)
                    .testBatchId(1L)
                    .regressionTests(regressionTests)
                    .build();
            testSets.add(testSet);

            List<TestBatch> testBatches = new ArrayList<>();
            TestBatch tb = TestBatch.builder()
                    .id(1L)
                    .buildTime("2023-05-10T12:00:00Z")
                    .version("1.0.0")
                    .commitShal("abcdef123456")
                    .branchID(1L)
                    .testSets(testSets).build();
            testBatches.add(tb);

            Account account = Account.builder()
                    .id(3L)
                    .username("username3")
                    .password("password")
                    .role(UserRole.DEVELOPER)
                    .build();
            Branch branch = Branch.builder()
                    .id(1L)
                    .branchName("main")
                    .visibility(Visibility.PUBLIC)
                    .createdUser(account)
                    .testBatches(testBatches).build();

            service.createBranch(branch);
            context.close();
        } catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }

}
