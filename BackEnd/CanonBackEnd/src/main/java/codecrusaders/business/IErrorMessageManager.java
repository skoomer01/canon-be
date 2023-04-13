package codecrusaders.business;

import codecrusaders.domain.ErrorMessage;

import java.util.Optional;

public interface IErrorMessageManager {
    Optional<ErrorMessage> getError(long errorId);
}
