package codecrusaders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegressionTest {
    private Long id;
    private boolean testResult;
    //private int heat;
    private int duration ;
    private Long testSetId;
}
