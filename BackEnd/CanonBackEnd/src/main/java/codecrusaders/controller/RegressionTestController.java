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
@RequestMapping("/regrtests")
@AllArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
}
