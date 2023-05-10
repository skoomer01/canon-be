package codecrusaders.repository.entity;

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
@Table(name = "sub_test")
public class SubTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long regressionTestID;

    @ManyToOne
    @JoinColumn(name = "regressionTestID", insertable = false, updatable = false)
    private RegressionTestEntity regressionTest;

    @OneToMany(mappedBy = "subTest", cascade = CascadeType.ALL)
    private List<TestStepEntity> testSteps;
}

