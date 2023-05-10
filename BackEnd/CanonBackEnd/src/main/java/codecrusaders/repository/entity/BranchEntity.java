package codecrusaders.repository.entity;

import codecrusaders.domain.TestBatch;
import codecrusaders.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchEntity {
    private Long id;
    private String branchName;
    private boolean access;
    private UserEntity user;
}
