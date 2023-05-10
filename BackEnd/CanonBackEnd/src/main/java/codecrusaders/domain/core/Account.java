package codecrusaders.domain.core;

import codecrusaders.domain.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Account {
    private Long id;
    private String username;
    private String password;
    private UserRole role;
}
