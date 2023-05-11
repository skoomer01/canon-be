package codecrusaders.controller;

import codecrusaders.business.IBranchManager;
import codecrusaders.domain.Http.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Branches")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class BranchController {
    private final IBranchManager branchManager;

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
