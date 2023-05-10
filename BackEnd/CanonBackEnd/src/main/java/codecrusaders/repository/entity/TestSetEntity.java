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
@Table(name = "test_set")
public class TestSetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long testBatchId;

    @ManyToOne
    @JoinColumn(name = "testBatchId", insertable = false, updatable = false)
    private TestBatchEntity testBatch;

    @OneToMany(mappedBy = "testSet", cascade = CascadeType.ALL)
    private List<RegressionTestEntity> regressionTests;
}

