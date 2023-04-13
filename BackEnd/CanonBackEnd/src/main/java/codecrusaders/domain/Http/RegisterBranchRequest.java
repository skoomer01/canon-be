package codecrusaders.domain.Http;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class RegisterBranchRequest {
    @NotNull
    @NotBlank
    private String branchName;

    @NotNull
    private Long userId;
}
