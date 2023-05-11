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
@Table(name = "sub_test")
public class SubTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="regressionTestID")
    private Long regressionTestID;

    @ManyToOne
    @JoinColumn(name = "regressionTestID", insertable = false, updatable = false)
    private RegressionTestEntity regressionTest;

    @OneToMany(mappedBy = "subTest", cascade = CascadeType.ALL)
    private List<TestStepEntity> testSteps;
}

