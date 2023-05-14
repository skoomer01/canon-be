package codecrusaders.domain.nestedstructure;

import codecrusaders.domain.Account;
import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.Enum.Visibility;
import codecrusaders.domain.ITestResultProvider;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Branch extends INestedComponent implements ITestResultProvider, INestedStructure {
    private Long id;
    private String name;
    private Visibility visibility;
    @JsonManagedReference
    private List<TestBatch> testBatches;
    private TestResult testResult;
    private Account createdUser;
    public void setTestResult(){
        for(int i = 0; i < testBatches.size(); i++){
            testBatches.get(i).setTestResult();
            if(testBatches.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                return;
            }
        }
        this.testResult = TestResult.PASSED;
    }

    public void add(INestedComponent component){
        if(component instanceof TestBatch){
            ((TestBatch) component).setBranch(Branch.builder().id(this.id).name(this.name).build());
            if(testBatches == null){
                testBatches = new ArrayList<>();
            }
            testBatches.add((TestBatch) component);
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of TestBatch");
        }
    }
    public void remove (INestedComponent component){
        if(component instanceof TestBatch){
            if(testBatches != null){
                testBatches.remove((TestBatch) component);
            }
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of TestBatch");
        }
    }
}
