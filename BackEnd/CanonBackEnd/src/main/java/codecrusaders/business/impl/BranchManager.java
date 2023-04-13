package codecrusaders.business.impl;

import codecrusaders.business.IBranchManager;
import codecrusaders.business.exception.BranchAlreadyExistsException;
import codecrusaders.business.impl.converters.BranchConverter;
import codecrusaders.business.impl.converters.UserConverter;
import codecrusaders.domain.Branch;
import codecrusaders.domain.Http.*;
import codecrusaders.repository.BranchRepository;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchManager implements IBranchManager {
    private final BranchRepository branchRepository;


    @Override
    public RegisterBranchResponse registerBranch(RegisterBranchRequest request) {
        if(branchRepository.branchExistByName(request.getBranchName())){
            throw new BranchAlreadyExistsException();
        }
        UserConverter userConverter = new UserConverter();
        BranchEntity branchEntity = saveBranch(request);
        return RegisterBranchResponse.builder()
                .id(branchEntity.getId())
                .user(UserConverter.convert(branchEntity.getUser()))
                .build();
    }

    public BranchEntity saveBranch(RegisterBranchRequest branch){
        UserEntity user = UserEntity.builder().id(branch.getUserId()).build();
        return branchRepository.saveBranch(BranchEntity.builder()
                .branchName(branch.getBranchName())
                .user(user)
                .build());
    }

    public GetAllBranchesResponse getAllBranches(){
        List<BranchEntity> results = branchRepository.findAll();

        List<Branch> branches = results
                .stream()
                .map(BranchConverter::convert)
                .toList();

        return GetAllBranchesResponse.builder()
                .branchList(branches)
                .build();
    }
}
