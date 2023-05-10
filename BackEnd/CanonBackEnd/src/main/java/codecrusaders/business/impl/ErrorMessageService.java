package codecrusaders.business.impl;

import codecrusaders.business.IErrorMessageService;
import codecrusaders.domain.core.ErrorMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ErrorMessageService implements IErrorMessageService {

    public ErrorMessage createErrorMessage(ErrorMessage errorMessage){
        return null;
    }
    public ErrorMessage getErrorMessageByID(Long id){
        return null;
    }
    public List<ErrorMessage> getErrorMessagesByMessage(String message){
        return null;
    }
    public List<ErrorMessage> getErrorMessagesByTestStep(Long id){
        return null;
    }
    public List<ErrorMessage> getErrorMessages(){
        return null;
    }
}
