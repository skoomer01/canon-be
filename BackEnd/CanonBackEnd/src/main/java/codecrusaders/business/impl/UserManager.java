package codecrusaders.business.impl;

import codecrusaders.domain.User;
import codecrusaders.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserManager implements codecrusaders.business.UserManager {

    private final UserRepository userRepository;
    @Override
    public User registerUser(String name) {
        return null;
    }

    public boolean saveUser(){
        return false;
    }
}
