package codecrusaders.domain.nestedstructure;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.ITestResultProvider;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TestStep extends INestedComponent implements ITestResultProvider, INestedStructure {
    private Long id;
    private String name;
    @JsonBackReference
    private SubTest subTest;
    private TestResult testResult;
    private String description;
    private ErrorMessage message;

    public void setTestResult() {
        if(message == null){
            this.testResult = TestResult.PASSED;
        } else{
            this.testResult = TestResult.FAILED;
        }
    }

    public void add(INestedComponent component){
        message = (ErrorMessage) component;
    }
    public void remove (INestedComponent component){
        if(component instanceof ErrorMessage){
            message = null;
        }
        else{
            throw new UnsupportedOperationException("INestedComponent should be an instance of ErrorMessage");
        }
    }
}
