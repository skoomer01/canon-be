package codecrusaders.controller;

import codecrusaders.business.BranchManager;
import codecrusaders.business.ManagerImpl.BranchManagerImp;
import codecrusaders.domain.Http.RegisterBranchRequest;
import codecrusaders.domain.Http.RegisterBranchResponse;
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
@RequestMapping("/branches")
@AllArgsConstructor

public class BranchController {
    private final BranchManager branchManager;

    @PostMapping()
    public ResponseEntity<RegisterBranchResponse> createBranch(@RequestBody @Valid RegisterBranchRequest request){
        RegisterBranchResponse response = branchManager.registerBranch(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
