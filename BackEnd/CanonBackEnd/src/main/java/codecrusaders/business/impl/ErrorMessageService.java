package codecrusaders.business.impl;

import codecrusaders.business.IErrorMessageService;
import codecrusaders.business.converters.ErrorMessageConverter;
import codecrusaders.business.converters.RegressionTestConverter;
import codecrusaders.domain.nestedstructure.ErrorMessage;
import codecrusaders.domain.nestedstructure.RegressionTest;
import codecrusaders.repository.IErrorMessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ErrorMessageService implements IErrorMessageService {

    @Autowired
    private IErrorMessageRepository repository;

    @Override
    public ErrorMessage createErrorMessage(ErrorMessage errorMessage){
        return ErrorMessageConverter.toDomain(repository.save(ErrorMessageConverter.toEntity(errorMessage)));
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
        List<ErrorMessage> result = repository.findAll().stream()
                .map(ErrorMessageConverter::toDomain)
                .collect(Collectors.toList());
        return result;
    }
}
