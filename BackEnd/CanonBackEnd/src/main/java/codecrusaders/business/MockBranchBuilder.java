package codecrusaders.business;

import codecrusaders.domain.Enum.Visibility;
import codecrusaders.domain.Account;
import codecrusaders.domain.nestedstructure.Branch;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MockBranchBuilder {

    private IBranchService branchService;
    private Long branchID;

    public void createBranch(String branchName, Visibility visibility, Account createdUser){
        Branch createBranchRequest = Branch.builder()
                .name(branchName)
                .visibility(visibility)
                .createdUser(createdUser)
                .build();
        Branch branch = branchService.createBranch(createBranchRequest);
        branchID = branch.getId();
    }
}
