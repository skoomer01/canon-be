package codecrusaders.controller;

import codecrusaders.business.UserManager;
import codecrusaders.domain.Http.RegisterUserRequest;
import codecrusaders.domain.Http.RegisterUserResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
@RestController
@RequestMapping("/users")
@AllArgsConstructor

public class UserController {
    private final UserManager userManager;

    @PostMapping()
    public ResponseEntity<RegisterUserResponse> createAccount(@RequestBody @Valid RegisterUserRequest request){
        RegisterUserResponse response = userManager.registerUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
