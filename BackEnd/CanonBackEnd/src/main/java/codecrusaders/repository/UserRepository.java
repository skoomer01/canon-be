package codecrusaders.repository;

import codecrusaders.domain.User;
import codecrusaders.repository.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public boolean saveUser(UserEntity user);
    public boolean userExistByName(String userName);
    public List<UserEntity> findAll();
    public UserEntity findByUsername(String userName);

    }
