package codecrusaders.repository.entity;

import codecrusaders.domain.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid")
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password")
    private String password;
    @Column(name = "userrole")
    private String userRole;
}
