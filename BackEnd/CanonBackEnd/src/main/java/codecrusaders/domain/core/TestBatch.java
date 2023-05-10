package codecrusaders.domain.core;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.core.TestSet;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestBatch {
    private Long id;
    private String buildTime;
    private String version;
    private String commitShal;
    private TestResult testResult;
    private List<TestSet> testSets;
    private Long branchID;

    public void setTestResult(){
        for(int i =0; i < testSets.size(); i++){
            testSets.get(i).setTestResult();
            if(testSets.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                return;
            }
        }
        this.testResult = TestResult.PASSED;
    }
}
