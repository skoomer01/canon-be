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
public class SubTest extends INestedComponent implements ITestResultProvider, INestedStructure {
    private Long id;
    private String name;
    private TestResult testResult;
    @JsonManagedReference
    private List<TestStep> testSteps;
    @JsonBackReference
    private RegressionTest regressionTest;

    public void setTestResult(){
        for(int i =0; i < testSteps.size(); i++){
            testSteps.get(i).setTestResult();
            if(testSteps.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                return;
            }
        }
        this.testResult = TestResult.PASSED;
    }

    public void add(INestedComponent component){
        if(component instanceof TestStep){
            if(testSteps == null){
                testSteps = new ArrayList<>();
            }
            ((TestStep) component).setSubTest(SubTest.builder().id(this.id).name(this.name).build());
            testSteps.add((TestStep) component);
        }else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of TestStep");

        }
    }
    public void remove(INestedComponent component){
        if(component instanceof TestStep){
            if(testSteps != null){
                testSteps.remove((TestStep) component);
            }
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of TestStep");

        }
    }
}
