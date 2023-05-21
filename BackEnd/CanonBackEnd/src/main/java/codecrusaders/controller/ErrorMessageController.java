package codecrusaders.controller;

import codecrusaders.business.IErrorMessageManager;
import codecrusaders.domain.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error-messages")
@AllArgsConstructor
public class ErrorMessageController {
    private final IErrorMessageManager errorMessageManager;

    @GetMapping("/{testStepId}")
    public ResponseEntity<ErrorMessage> getErrorMessageByTestStepId(@PathVariable long testStepId) {
        return errorMessageManager.getErrorByTestStepId(testStepId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
