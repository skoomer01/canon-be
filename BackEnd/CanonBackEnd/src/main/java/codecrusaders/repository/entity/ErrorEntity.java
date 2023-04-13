package codecrusaders.repository.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ErrorEntity {
    private Long id;
    private String message;
}
