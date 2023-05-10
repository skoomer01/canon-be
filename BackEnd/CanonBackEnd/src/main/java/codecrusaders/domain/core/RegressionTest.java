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
public class RegressionTest {
    private Long id;
    private int heat;
    private int duration ;
    private TestResult testResult;
    private List<SubTest> subTests;
    private Long testSetId;

    public void setTestResult(){
        for(int i =0; i < subTests.size(); i++){
            subTests.get(i).setTestResult();
            if(subTests.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                break;
            }
        }
        this.testResult = TestResult.PASSED;
    }
}
