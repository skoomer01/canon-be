package codecrusaders.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_batch")
public class TestBatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String buildTime;
    private String version;
    private String commitShal;
    private Long branchID;

    @ManyToOne
    @JoinColumn(name = "branchID", insertable = false, updatable = false)
    private BranchEntity branch;

    @OneToMany(mappedBy = "testBatch", cascade = CascadeType.ALL)
    private List<TestSetEntity> testSets;
}

