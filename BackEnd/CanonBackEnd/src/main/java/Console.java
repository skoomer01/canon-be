import codecrusaders.CanonApp;
import codecrusaders.business.*;
import codecrusaders.business.impl.*;
import codecrusaders.domain.Account;
import codecrusaders.domain.Enum.UserRole;
import codecrusaders.domain.Enum.Visibility;
import codecrusaders.domain.nestedstructure.*;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Console {
    public static void main(String[] args) {
        try{

            //Setting services:
            ConfigurableApplicationContext context = SpringApplication.run(CanonApp.class, args);
            IBranchService service = context.getBean(BranchService.class);
            ITestBatchService testBatchService = context.getBean(TestBatchService.class);
            ITestSetService testSetService = context.getBean(TestSetService.class);
            IRegressionTestService regressionTestService = context.getBean(RegressionTestService.class);
            ISubTestService subtestService = context.getBean(SubtestService.class);
            ITestStepService testStepService = context.getBean(TestStepService.class);
            IErrorMessageService errorMessageService = context.getBean(ErrorMessageService.class);
            IAccountService accountService = context.getBean(AccountService.class);

            //Instantiate RegressionTests:

            List<ErrorMessage> errorMessages = errorMessageService.getErrorMessages();

            List<TestStep> testSteps = testStepService.getTestSteps();
            List<TestStep> testStepsWithErrors = MockErrorMessageGenerator.assignErrorMessages(testSteps, errorMessages);

            for(TestStep e: testStepsWithErrors){
                testStepService.createTestStep(e);
            }
        }
        catch(Exception ex)
        {
            System.out.print(ex.getMessage());
        }
    }

}
