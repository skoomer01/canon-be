package codecrusaders.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String password;
<<<<<<< Updated upstream
=======
    private String userRole;
>>>>>>> Stashed changes
}
