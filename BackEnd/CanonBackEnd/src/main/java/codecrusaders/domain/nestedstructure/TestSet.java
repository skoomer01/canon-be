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
public class TestSet extends INestedComponent implements ITestResultProvider, INestedStructure {
    private Long id;
    private String name;
    private TestResult testResult;
    @JsonManagedReference
    private List<RegressionTest> regressionTests;
    @JsonBackReference
    private TestBatch testBatch;

    public void setTestResult() {
        for(int i = 0; i < regressionTests.size(); i++){
            regressionTests.get(i).setTestResult();
            if(regressionTests.get(i).getTestResult() == TestResult.FAILED){
                this.testResult = TestResult.FAILED;
                return;
            }
        }
        this.testResult = TestResult.PASSED;
    }
    public void add(INestedComponent component){
        if(component instanceof RegressionTest){
            if(regressionTests == null){
                regressionTests = new ArrayList<>();
            }
            ((RegressionTest) component).setTestSet(TestSet.builder().id(this.id).name(this.name).build());
            regressionTests.add((RegressionTest) component);
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of RegressionTest");
        }
    }
    public void remove(INestedComponent component){
        if(component instanceof RegressionTest){
            if(regressionTests != null){
                regressionTests.remove((RegressionTest) component);
            }
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of RegressionTest");

        }
    }
}
