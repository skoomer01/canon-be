package codecrusaders.domain.Http;

import codecrusaders.domain.Enum.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class RegisterUserRequest {

    @NotNull
    @NotBlank
    private String userName;
    @NotNull
    @NotBlank
    private String password;
}
