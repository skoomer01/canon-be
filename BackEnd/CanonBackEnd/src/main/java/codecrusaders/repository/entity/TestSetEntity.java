package codecrusaders.repository.entity;

import codecrusaders.domain.RegressionTest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestSetEntity {
    private Long id;
    private Long testBatchId;



}
