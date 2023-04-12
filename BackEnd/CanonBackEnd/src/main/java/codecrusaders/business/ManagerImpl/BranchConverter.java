package codecrusaders.business.ManagerImpl;

import codecrusaders.domain.Branch;
import codecrusaders.domain.User;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BranchConverter {
    private final UserConverter userConverter;
    public Optional<Branch> Convert(BranchEntity branchEntity){
        Branch branchToBeConverted = Branch.builder()
                .branchName(branchEntity.getBranchName())
                .user(userConverter.Convert(branchEntity.getUser()).get())
                .build();

        Optional<Branch> returnedBranch = Optional.of(branchToBeConverted);
        return returnedBranch;
    }}
