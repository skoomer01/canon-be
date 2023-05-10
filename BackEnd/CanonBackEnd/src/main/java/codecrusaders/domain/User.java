package codecrusaders.domain;

import codecrusaders.domain.Enum.UserRole;
import codecrusaders.repository.entity.UserRoleEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String password;
    private Set<UserRoleEntity> userRoles;
}
