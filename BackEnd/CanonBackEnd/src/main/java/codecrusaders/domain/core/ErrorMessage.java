package codecrusaders.domain.core;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
    private Long id;
    private String message;
    private Long testStepID;
}
