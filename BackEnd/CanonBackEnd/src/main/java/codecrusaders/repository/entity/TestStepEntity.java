package codecrusaders.repository.entity;

import codecrusaders.domain.ErrorMessage;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TestStepEntity {
    private Long id;
    private Long subTestId;
    private boolean testResult;
    private String description;
    private ErrorEntity message;
}
