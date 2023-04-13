package codecrusaders.business.impl;

import codecrusaders.business.IErrorMessageManager;
import codecrusaders.business.impl.converters.ErrorMessageConverter;
import codecrusaders.domain.ErrorMessage;
import codecrusaders.repository.ErrorMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ErrorMessageManager implements IErrorMessageManager {
    private final ErrorMessageRepository errorMessageRepository;

    @Override
    public Optional<ErrorMessage> getError(long errorId)
    {
        return errorMessageRepository.findById(errorId).map(ErrorMessageConverter::convert);
    }
}
