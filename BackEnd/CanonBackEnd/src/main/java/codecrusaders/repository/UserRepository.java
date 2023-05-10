package codecrusaders.repository;

import codecrusaders.domain.User;
import codecrusaders.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository {
    public boolean saveUser(UserEntity user);
    public boolean userExistByName(String userName);
    public List<UserEntity> findAll();
    public UserEntity findByUsername(String userName);

    }
