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
    public ErrorMessage getError(long errorId)
    {
        Optional<ErrorEntity> errorEntityOptional = errorMessageRepository.findById(errorId);
        ErrorEntity entity = errorEntityOptional.get();
        return ErrorMessageConverter.convert(entity);
    }
}
