package codecrusaders.domain.core;

import codecrusaders.domain.Enum.TestResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubTest {
    private Long id;
    private TestResult testResult;
    private List<TestStep> testSteps;
    private Long regressionTestID;

    public void setTestResult(){
        for(int i =0; i < testSteps.size(); i++){
            testSteps.get(i).setTestResult();
            if(testSteps.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                break;
            }
        }
        this.testResult = TestResult.PASSED;
    }

}
