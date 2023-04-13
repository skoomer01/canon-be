package codecrusaders.controller;

import codecrusaders.business.impl.TestSetManager;
import codecrusaders.domain.CreateTestSetRequest;
import codecrusaders.domain.CreateTestSetResponse;
import codecrusaders.domain.GetTestSetResponse;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
@RestController
@RequestMapping("/testsets")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TestSetController {
    private TestSetManager testSetManager;
    @PostMapping()
    public ResponseEntity<CreateTestSetResponse> createTestSet(@RequestBody @Valid CreateTestSetRequest request) {
        CreateTestSetResponse response = testSetManager.createTestSet(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping
    public ResponseEntity<GetTestSetResponse> getTestSets(){
        return ResponseEntity.ok(testSetManager.getAllTestSets());
    }
}
