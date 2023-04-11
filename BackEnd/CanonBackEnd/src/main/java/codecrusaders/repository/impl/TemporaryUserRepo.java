package codecrusaders.repository.impl;

import codecrusaders.domain.User;
import codecrusaders.repository.UserRepository;
import codecrusaders.repository.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TemporaryUserRepo implements UserRepository {
    private static long NEXT_ID = 1;
    private final List<UserEntity> savedUsers;
    public TemporaryUserRepo(){
        this.savedUsers = new ArrayList<>();
    }
    @Override
    public boolean saveUser(UserEntity user) {
        if(user.getId() == null){
            user.setId(NEXT_ID);
            NEXT_ID++;
            this.savedUsers.add(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean userExistByName(String userName) {
        return this.savedUsers
                .stream()
                .anyMatch(userEntity -> userEntity.getUserName().equals(userName));
    }

    @Override
    public List<UserEntity> findAll() {
        return Collections.unmodifiableList(this.savedUsers);
    }


}