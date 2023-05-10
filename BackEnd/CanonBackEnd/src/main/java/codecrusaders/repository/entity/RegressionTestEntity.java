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
@Table(name = "regression_test")
public class RegressionTestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int heat;
    private int duration;
    private Long testSetId;

    @ManyToOne
    @JoinColumn(name = "testSetId", insertable = false, updatable = false)
    private TestSetEntity testSet;

    @OneToMany(mappedBy = "regressionTest", cascade = CascadeType.ALL)
    private List<SubTestEntity> subTests;
}

