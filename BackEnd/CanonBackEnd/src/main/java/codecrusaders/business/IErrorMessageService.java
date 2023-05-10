package codecrusaders.business;

import codecrusaders.domain.core.ErrorMessage;

import java.util.List;

public interface IErrorMessageService {
    ErrorMessage createErrorMessage(ErrorMessage errorMessage);
    ErrorMessage getErrorMessageByID(Long id);
    List<ErrorMessage> getErrorMessagesByMessage(String message);
    List<ErrorMessage> getErrorMessagesByTestStep(Long id);
    List<ErrorMessage> getErrorMessages();
}
