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
public class TestSet {
    private Long id;
    private TestResult testResult;
    private List<RegressionTest> regressionTests;
    private Long testBatchId;

    public void setTestResult() {
        for(int i = 0; i < regressionTests.size(); i++){
            regressionTests.get(i).setTestResult();
            if(regressionTests.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                break;
            }
        }
        this.testResult = TestResult.PASSED;
    }
}
