package codecrusaders.repository.entity;

import codecrusaders.domain.TestStep;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SubTestEntity {
    private Long id;
    private Long testId;
    private boolean testResult;
}
