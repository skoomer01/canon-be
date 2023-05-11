package codecrusaders.business;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.Enum.Visibility;
import codecrusaders.domain.core.Account;
import codecrusaders.domain.core.Branch;
import codecrusaders.domain.core.TestBatch;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MockBranchBuilder {

    private IBranchService branchService;
    private Long branchID;

    public void createBranch(String branchName, Visibility visibility, Account createdUser){
        Branch createBranchRequest = Branch.builder()
                .branchName(branchName)
                .visibility(visibility)
                .createdUser(createdUser)
                .build();
        Branch branch = branchService.createBranch(createBranchRequest);
        branchID = branch.getId();
    }
}
