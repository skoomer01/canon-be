package codecrusaders.business;

import codecrusaders.domain.Branch;
import codecrusaders.domain.Http.GetAllBranchesResponse;
import codecrusaders.domain.Http.RegisterBranchRequest;
import codecrusaders.domain.Http.RegisterBranchResponse;
import codecrusaders.domain.Http.RegisterUserRequest;
import codecrusaders.domain.User;

public interface BranchManager {
    public RegisterBranchResponse registerBranch(RegisterBranchRequest request);
    public GetAllBranchesResponse getAllBranches();

    }
