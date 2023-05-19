package codecrusaders.business.impl.converters;


import codecrusaders.domain.User;
import codecrusaders.repository.entity.UserEntity;
import lombok.NoArgsConstructor;

import java.util.Optional;

@NoArgsConstructor
public class UserConverter {
    public static User convert(UserEntity userEntity){
        User UserToBeConverted = User.builder()
                .id(userEntity.getId())
                .userRoles(userEntity.getUserRoles())
                .userName(userEntity.getUsername())
                .password(userEntity.getPassword())
                .build();

        User returnedUser = UserToBeConverted;
        return returnedUser;
    }
}
