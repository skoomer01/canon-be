package codecrusaders.domain.core;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.core.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestStep {
    private Long id;
    private Long subTestId;
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
}
