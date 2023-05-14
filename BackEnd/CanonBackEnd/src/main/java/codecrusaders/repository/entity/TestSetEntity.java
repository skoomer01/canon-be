package codecrusaders.repository.entity;

import codecrusaders.repository.entity.TestBatchEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "testSet", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<RegressionTestEntity> regressionTests;

    @ManyToOne
    @JoinColumn(name = "testBatch_id")
    private TestBatchEntity testBatch;
}
