package codecrusaders.controller;

import codecrusaders.business.BranchManager;
import codecrusaders.business.ManagerImpl.BranchManagerImp;
import codecrusaders.domain.Http.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping
    public ResponseEntity<GetAllBranchesResponse> getAllBranches(){
        GetAllBranchesResponse response = branchManager.getAllBranches();
        return ResponseEntity.ok(response);
    }
}
