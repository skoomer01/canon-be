package codecrusaders.business.ManagerImpl;


import codecrusaders.domain.User;
import codecrusaders.repository.entity.UserEntity;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class UserConverter {
    public Optional<User> Convert(UserEntity userEntity){
        User UserToBeConverted = User.builder()
                .id(userEntity.getId())
                .userRole(userEntity.getUserRole())
                .userName(userEntity.getUserName())
                .password(userEntity.getPassword())
                .build();

        Optional<User> returnedUser = Optional.of(UserToBeConverted);
        return returnedUser;
    }
}
