package codecrusaders.business;

import codecrusaders.domain.core.Branch;

import java.util.List;

public interface IBranchService {
    Branch createBranch(Branch branch);
    Branch getBranchById(Long id);
    List<Branch> getBranches();
    List<Branch> getBranchesWithErrorId(Long errorID);


}
