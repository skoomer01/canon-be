package codecrusaders.business.ManagerImpl;

import codecrusaders.business.exception.AccountAlreadyExistsException;
import codecrusaders.domain.Http.RegisterUserRequest;
import codecrusaders.domain.Http.RegisterUserResponse;
import codecrusaders.repository.UserRepository;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
}
