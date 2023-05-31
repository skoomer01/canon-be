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
public class Branch {
    private Long id;
    private List<TestBatch> testBatches;
    private String branchName;
    private User user;
}
