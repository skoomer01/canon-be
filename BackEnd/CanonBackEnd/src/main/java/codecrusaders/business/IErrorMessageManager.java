package codecrusaders.business;

import codecrusaders.repository.entity.ErrorEntity;

public interface IErrorMessageManager {
    ErrorEntity getError(long errorId);
}
