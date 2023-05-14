package codecrusaders.domain;

import codecrusaders.domain.Enum.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private Long id;
    private String username;
    private String password;
    private UserRole role;
}
