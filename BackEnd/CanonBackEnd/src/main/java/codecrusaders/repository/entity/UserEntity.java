package codecrusaders.repository.entity;

import codecrusaders.domain.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    private Long id;
    private String userName;
    private String password;
    private UserRole userRole;
}
