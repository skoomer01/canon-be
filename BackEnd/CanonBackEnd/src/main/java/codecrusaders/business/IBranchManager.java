package codecrusaders.business;

import codecrusaders.domain.GetAllTestBatchesFromABranchRequest;
import codecrusaders.domain.GetAllTestBatchesFromABranchResponse;
import codecrusaders.domain.Http.GetAllBranchesResponse;
import codecrusaders.domain.Http.RegisterBranchRequest;
import codecrusaders.domain.Http.RegisterBranchResponse;

public interface IBranchManager {
    //...
    public RegisterBranchResponse registerBranch(RegisterBranchRequest request);
    public GetAllBranchesResponse getAllPublicBranches();
    public GetAllBranchesResponse getAllPrivateBranches();
    public GetAllTestBatchesFromABranchResponse getAllTestBatchesFromABranch(GetAllTestBatchesFromABranchRequest request);

    }
