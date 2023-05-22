package codecrusaders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestSet {
    private Long id;
    private String name;
    private TestBatch testBatch;
    private Date testSetTime;
    private List<RegressionTest> regressionTests;
}
