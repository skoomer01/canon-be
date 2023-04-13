package codecrusaders.controller;

import codecrusaders.business.impl.SubTestManager;
import codecrusaders.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/SubTest")
@AllArgsConstructor
public class SubTestController {
    private final SubTestManager subTestManager;
    @GetMapping
    public ResponseEntity<GetSubTestsResponse> getSubTests() {
        return ResponseEntity.ok(subTestManager.getSubTests());
    }
    @PostMapping
    public ResponseEntity<CreateSubTestResponse> createSubTest(@RequestBody @Valid CreateSubTestRequest request){
        CreateSubTestResponse response = subTestManager.registerSubTest(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);

    }
}
