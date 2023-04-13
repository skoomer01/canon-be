package codecrusaders.business;

import codecrusaders.domain.Http.GetAllUsersResponse;
import codecrusaders.domain.Http.RegisterUserRequest;
import codecrusaders.domain.Http.RegisterUserResponse;
import codecrusaders.domain.User;

public interface UserManager {
    public RegisterUserResponse registerUser(RegisterUserRequest request);
    public GetAllUsersResponse getAllUsers();

    }
