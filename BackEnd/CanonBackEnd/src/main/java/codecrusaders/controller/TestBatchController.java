package codecrusaders.controller;

import codecrusaders.business.IBranchManager;
import codecrusaders.business.ITestBatchManager;
import codecrusaders.domain.*;
import codecrusaders.domain.Http.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/TestBatches")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class TestBatchController {

    private final ITestBatchManager testBatchManager;
    @GetMapping("{id}")
    public ResponseEntity<GetAllTestSetFromABatchResponse> getAllTestSetsByBatchId(@PathVariable Long id){
        GetAllTestSetFromABatchResponse response = testBatchManager.getAllTestSetsWithBatchId(GetAllTestSetFromABatchRequest.builder().testBatchId(id).build());
        return ResponseEntity.ok(response);
    }


}
