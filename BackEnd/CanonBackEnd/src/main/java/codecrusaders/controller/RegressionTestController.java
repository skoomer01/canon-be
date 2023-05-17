package codecrusaders.controller;
import codecrusaders.business.impl.RegrTestManager;
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
@RequestMapping("/Tests")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000/", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class RegressionTestController {
    private RegrTestManager regrTestManager;
    @PostMapping()
    public ResponseEntity<CreateRegrTestResponse> createRegrTest(@RequestBody @Valid CreateRegrTestRequest request) {
        CreateRegrTestResponse response = regrTestManager.createRegressionTest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @CrossOrigin(origins = "http://localhost:8080/")
    @GetMapping
    public ResponseEntity<GetRegressionTestResponse> getRegrTests(){
        return ResponseEntity.ok(regrTestManager.getAllRegrTests());
    }
    @GetMapping("/latest")
    public ResponseEntity<GetLatestTestsResponse> getLatestRegrTests(){
        return ResponseEntity.ok(regrTestManager.getLatestTests());
    }
}
