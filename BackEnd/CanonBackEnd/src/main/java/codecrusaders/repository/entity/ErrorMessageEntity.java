package codecrusaders.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "error_message")
public class ErrorMessageEntity {
    @Id
    @Column(nullable = false)
    private Long id;
    @Column(name="message")
    private String message;
    @Column(name="testStepID")
    private Long testStepID;

    @OneToOne
    @JoinColumn(name = "testStepID", insertable = false, updatable = false)
    private TestStepEntity testStep;
}


