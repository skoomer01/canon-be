package codecrusaders.repository.entity;

import codecrusaders.domain.Enum.TestResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_step")
public class TestStepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long subTestId;
    private String description;

    @OneToOne(mappedBy = "testStep", cascade = CascadeType.ALL)
    private ErrorMessageEntity message;

    @ManyToOne
    @JoinColumn(name = "subTestId", insertable = false, updatable = false)
    private SubTestEntity subTest;
}

