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
public class RegressionTest extends INestedComponent implements ITestResultProvider, INestedStructure {
    private Long id;
    private String name;
    private int heat;
    private int duration ;
    private TestResult testResult;
    @JsonManagedReference
    private List<SubTest> subTests;
    @JsonBackReference
    private TestSet testSet;

    public void setTestResult(){
        for(int i =0; i < subTests.size(); i++){
            subTests.get(i).setTestResult();
            if(subTests.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                return;
            }
        }
        this.testResult = TestResult.PASSED;
    }

    public void add(INestedComponent component){
        if(component instanceof SubTest){
            if(subTests == null){
                subTests = new ArrayList<>();
            }
            ((SubTest) component).setRegressionTest(RegressionTest.builder().id(this.id).name(this.name).build());
            subTests.add((SubTest) component);
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of SubTest");

        }
    }
    public void remove(INestedComponent component){
        if(component instanceof SubTest){
            if(subTests != null){
                subTests.remove((SubTest) component);
            }
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of SubTest");

        }
    }
}
