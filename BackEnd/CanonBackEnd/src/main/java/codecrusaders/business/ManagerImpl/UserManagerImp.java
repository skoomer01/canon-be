package codecrusaders.business.ManagerImpl;

import codecrusaders.business.exception.AccountAlreadyExistsException;
import codecrusaders.domain.Http.GetAllUsersResponse;
import codecrusaders.domain.Http.RegisterBranchRequest;
import codecrusaders.domain.Http.RegisterUserRequest;
import codecrusaders.domain.Http.RegisterUserResponse;
import codecrusaders.domain.User;
import codecrusaders.repository.UserRepository;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserManagerImp implements codecrusaders.business.UserManager {

    private final UserRepository userRepository;
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        if(userRepository.userExistByName(request.getUserName())){
            throw new AccountAlreadyExistsException();
        }

        UserEntity userEntity = saveUser(request);

        return RegisterUserResponse.builder()
                .id(userEntity.getId())
                .build();
    }

    public UserEntity saveUser(RegisterUserRequest user){

        return userRepository.saveUser(UserEntity.builder()
                .userName(user.getUserName())
                .password(user.getPassword())
                .build());
    }

    public GetAllUsersResponse getAllUsers(){
        List<UserEntity> results = userRepository.findAll();

        List<User> users = results
                .stream()
                .map(UserConverter::convert)
                .toList();

        return GetAllUsersResponse.builder()
                .userList(users)
                .build();
    }
}
