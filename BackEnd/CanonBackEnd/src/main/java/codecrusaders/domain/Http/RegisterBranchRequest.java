package codecrusaders.domain.Http;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class RegisterBranchRequest {
    private String branchName;
    private boolean isPublic;
}
