package codecrusaders.business;

import codecrusaders.domain.ErrorMessage;
import codecrusaders.repository.entity.ErrorEntity;

import java.util.Optional;

public interface IErrorMessageManager {
    ErrorMessage getError(long errorId);

}
