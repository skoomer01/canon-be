package codecrusaders.domain.core;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.Enum.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Branch {
    private Long id;
    private List<TestBatch> testBatches;
    private TestResult testResult;
    private String branchName;
    private Visibility visibility;
    private Account createdUser;
    public void setTestResult(){
        for(int i =0; i < testBatches.size(); i++){
            testBatches.get(i).setTestResult();
            if(testBatches.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                break;
            }
        }
        this.testResult = TestResult.PASSED;
    }
}
