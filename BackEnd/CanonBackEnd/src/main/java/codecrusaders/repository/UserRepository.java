package codecrusaders.repository;

import codecrusaders.domain.User;
import codecrusaders.repository.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    public boolean saveUser(UserEntity user);
    public boolean userExistByName(String userName);
    public List<UserEntity> findAll();
}
