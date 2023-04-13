package codecrusaders.repository.entity;

import codecrusaders.domain.SubTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegressionTestEntity {
    private Long id;
    private boolean testResult;
    private int duration;
    private Long testSetId;
}
