import codecrusaders.CanonApp;
import codecrusaders.business.impl.AccountService;
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

            //Setting services:
            ConfigurableApplicationContext context = SpringApplication.run(CanonApp.class, args);
            BranchService service = context.getBean(BranchService.class);
            AccountService service1 = context.getBean(AccountService.class);

            //Adding mock users:
            service1.addAccount(Account.builder()
                    .username("username3")
                    .password("password")
                    .role(UserRole.DEVELOPER)
                    .build());

            service1.addAccount(Account.builder()
                    .username("username2")
                    .password("password")
                    .role(UserRole.DEVELOPER)
                    .build());

            service1.addAccount(Account.builder()
                    .username("username1")
                    .password("password")
                    .role(UserRole.DEVELOPER)
                    .build());

            //Creation of Branch 1:
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
                    .username("username1")
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

            //Creation of branch 2:
            ErrorMessage m1 = new ErrorMessage(13L, "Errormessage 2", 1L);

            List<TestStep> testSteps1 = new ArrayList<>();
            TestStep t1 = TestStep.builder()
                    .id(2L)
                    .subTestId(2L)
                    .description("Step 3")
                    .message(m1)
                    .build();
            testSteps.add(t1);
            TestStep t21 = TestStep.builder()
                    .id(2L)
                    .subTestId(2L)
                    .description("Step 4")
                    .build();
            testSteps.add(t21);

            List<SubTest> subTests1 = new ArrayList<>();
            SubTest s1 = SubTest.builder()
                    .id(2L)
                    .regressionTestID(2L)
                    .testSteps(testSteps1)
                    .build();
            subTests.add(s1);

            List<RegressionTest> regressionTests1 = new ArrayList<>();
            RegressionTest r1 = RegressionTest.builder()
                    .id(2L)
                    .heat(10)
                    .duration(30)
                    .testSetId(2L)
                    .subTests(subTests1)
                    .build();
            regressionTests.add(r1);

            List<TestSet> testSets1 = new ArrayList<>();
            TestSet testSet1 = TestSet.builder()
                    .id(2L)
                    .testBatchId(2L)
                    .regressionTests(regressionTests1)
                    .build();
            testSets.add(testSet1);

            List<TestBatch> testBatches1 = new ArrayList<>();
            TestBatch tb1 = TestBatch.builder()
                    .id(2L)
                    .buildTime("2023-05-10T12:00:00Z")
                    .version("1.0.0")
                    .commitShal("abcdef123456")
                    .branchID(2L)
                    .testSets(testSets1).build();
            testBatches.add(tb1);

            Account account1 = Account.builder()
                    .id(2L)
                    .username("username1")
                    .password("password")
                    .role(UserRole.DEVELOPER)
                    .build();
            Branch branch1 = Branch.builder()
                    .id(2L)
                    .branchName("main")
                    .visibility(Visibility.PUBLIC)
                    .createdUser(account1)
                    .testBatches(testBatches1).build();

            service.createBranch(branch1);
            context.close();
        } catch(Exception ex){
            System.out.print(ex.getMessage());
        }
    }

}
