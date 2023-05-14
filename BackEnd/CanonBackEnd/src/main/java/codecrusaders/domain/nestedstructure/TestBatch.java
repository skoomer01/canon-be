package codecrusaders.domain.nestedstructure;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.ITestResultProvider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TestBatch extends INestedComponent implements ITestResultProvider, INestedStructure {
    private Long id;
    private String version;
    private String buildTime;
    private String commitShal;
    private TestResult testResult;
    @JsonManagedReference
    private List<TestSet> testSets;
    @JsonBackReference
    private Branch branch;

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

    public void add(INestedComponent component){
        if(component instanceof TestSet){
            if(testSets == null){
                testSets = new ArrayList<>();
            }
            ((TestSet) component).setTestBatch(TestBatch.builder()
                    .id(this.id)
                    .commitShal(this.commitShal)
                    .version(this.version)
                    .build());
            testSets.add((TestSet) component);
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of TestSet");

        }
    }
    public void remove(INestedComponent component){
        if(component instanceof TestSet){
            if(testSets != null){
                testSets.remove((TestSet) component);
            }
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of TestSet");

        }
    }
}
