package codecrusaders.repository;

import codecrusaders.repository.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepository {
    public UserEntity saveUser(UserEntity user);
    public boolean userExistByName(String userName);
    public List<UserEntity> findAll();
}
