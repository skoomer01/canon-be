package codecrusaders.controller;

import codecrusaders.business.IBranchService;
import codecrusaders.domain.core.Branch;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/branches")
public class BranchController {

    private final IBranchService branchService;
    @GetMapping("/filter/error/{errorID}")
    public ResponseEntity<List<Branch>> getBranchesWithErrorId(@PathVariable Long errorID) {
        try {
            List<Branch> branches = branchService.getBranchesWithErrorId(errorID);
            return ResponseEntity.ok(branches);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/filter/commit/{commit}")
    public ResponseEntity<List<Branch>> getBranchesByCommit(@PathVariable String commit) {
        try {
            List<Branch> branches = branchService.getBranchesByCommit(commit);
            return ResponseEntity.ok(branches);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/filter/version/{version}")
    public ResponseEntity<List<Branch>> getBranchesByVersion(@PathVariable String version) {
        try {
            List<Branch> branches = branchService.getBranchesByVersion(version);
            return ResponseEntity.ok(branches);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Branch> createBranch(@RequestBody Branch branch) {
        try {
            Branch createdBranch = branchService.createBranch(branch);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdBranch);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping()
    public ResponseEntity<List<Branch>> getBranchesWithErrorId() {
        try {
            List<Branch> branches = branchService.getBranches();
            return ResponseEntity.ok(branches);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}

