package codecrusaders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTestStepRequest {
    @NotNull
    private boolean testResult;
    @NotNull
    private Long subTestId;
    private String description;
    private ErrorMessage message;
}
