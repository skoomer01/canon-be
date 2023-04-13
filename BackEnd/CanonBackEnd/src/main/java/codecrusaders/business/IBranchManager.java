package codecrusaders.business;

import codecrusaders.domain.Http.GetAllBranchesResponse;
import codecrusaders.domain.Http.RegisterBranchRequest;
import codecrusaders.domain.Http.RegisterBranchResponse;

public interface IBranchManager {
    //.
    public RegisterBranchResponse registerBranch(RegisterBranchRequest request);
    public GetAllBranchesResponse getAllBranches();

    }
