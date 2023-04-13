package codecrusaders.business.ManagerImpl;

import codecrusaders.domain.Branch;
import codecrusaders.domain.User;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class BranchConverter {
    public static Branch convert(BranchEntity branchEntity){
        Branch branchToBeConverted = Branch.builder()
                .branchName(branchEntity.getBranchName())
                .user(UserConverter.convert(branchEntity.getUser()))
                .build();

        Branch returnedBranch = branchToBeConverted;
        return returnedBranch;
    }}
