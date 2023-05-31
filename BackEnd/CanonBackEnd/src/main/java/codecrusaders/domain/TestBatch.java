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
public class TestBatch {
    private Long id;
    private List<TestSet> testSets;
    private String buildTime;
    private String version;
    private String commitShal;
}
