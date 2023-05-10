package codecrusaders.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "errors")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ErrorID")
    private Long errorid;
    @Column(name = "ErrorMessage")
    private String errorMessage;
}
