package codecrusaders.business.impl;

import codecrusaders.business.IErrorMessageManager;
import codecrusaders.business.impl.converters.ErrorMessageConverter;
import codecrusaders.domain.ErrorMessage;
import codecrusaders.repository.ErrorMessageRepository;
import codecrusaders.repository.entity.ErrorEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ErrorMessageManager implements IErrorMessageManager {
    private final ErrorMessageRepository errorMessageRepository;

    @Override
    public ErrorEntity getError(long errorId)
    {
        return null; //errorMessageRepository.findById(errorId).map(ErrorMessageConverter::convert);

    }
    @Override
    public Optional<ErrorMessage> getErrorByTestStepId(long testStepId){
        Optional<ErrorEntity> testStepEntityOptional = errorMessageRepository.findByTestStepId(testStepId);
        return testStepEntityOptional.map(ErrorMessageConverter::convert);
    }
}
