package codecrusaders.business.ManagerImpl;

import codecrusaders.business.BranchManager;
import codecrusaders.business.exception.AccountAlreadyExistsException;
import codecrusaders.business.exception.BranchAlreadyExistsException;
import codecrusaders.domain.Http.RegisterBranchRequest;
import codecrusaders.domain.Http.RegisterBranchResponse;
import codecrusaders.domain.Http.RegisterUserRequest;
import codecrusaders.domain.Http.RegisterUserResponse;
import codecrusaders.domain.User;
import codecrusaders.repository.BranchRepository;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BranchManagerImp implements BranchManager {
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
                .user(userConverter.Convert(branchEntity.getUser()).get())
                .build();
    }

    public BranchEntity saveBranch(RegisterBranchRequest branch){
        UserEntity user = UserEntity.builder().id(branch.getUserId()).build();
        return branchRepository.saveBranch(BranchEntity.builder()
                .branchName(branch.getBranchName())
                .user(user)
                .build());
    }
}
