package codecrusaders.repository;

import codecrusaders.repository.entity.ErrorEntity;

import java.util.List;
import java.util.Optional;

public interface ErrorMessageRepository {
    boolean existsById(long errorId);
    ErrorEntity save(ErrorEntity errorEntity);
    public List<ErrorEntity> findAll();
    Optional<ErrorEntity> findById(long errorId);
}
