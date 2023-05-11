package codecrusaders.business;

import codecrusaders.domain.core.Branch;
import codecrusaders.repository.entity.BranchEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBranchService {
    Branch createBranch(Branch branch);
    Branch getBranchById(Long id);
    List<Branch> getBranches();
    List<Branch> getBranchesWithErrorId(Long errorID);
    List<Branch> getBranchesByCommit(String commitShal);

    List<Branch> getBranchesByVersion(String version);


}
