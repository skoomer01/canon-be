package codecrusaders.repository.entity;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRoleEntity {

    private Long id;

    private RoleEnum role;

    private UserEntity user;
}
