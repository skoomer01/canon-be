package codecrusaders.controller;

import codecrusaders.business.impl.TestSetManager;
import codecrusaders.domain.*;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
@RestController
@RequestMapping("/TestSets")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class TestSetController {
    private TestSetManager testSetManager;
    @PostMapping()
    public ResponseEntity<CreateTestSetResponse> createTestSet(@RequestBody @Valid CreateTestSetRequest request) {
        CreateTestSetResponse response = testSetManager.createTestSet(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<GetTestSetResponse> getTestSets(){
        return ResponseEntity.ok(testSetManager.getAllTestSets());
    }
    @GetMapping("/latest")
    public ResponseEntity<GetLatestTestSetsResponse> getLatestRegrTests(){
        return ResponseEntity.ok(testSetManager.getLatestTestSets());
    }
}
