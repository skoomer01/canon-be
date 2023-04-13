package codecrusaders.repository.impl;

import codecrusaders.repository.ErrorMessageRepository;
import codecrusaders.repository.entity.ErrorEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class TemporaryErrorMessageRepo implements ErrorMessageRepository {
    private static long NEXT_ID = 1;

    private final List<ErrorEntity> savedErrors;

    public TemporaryErrorMessageRepo(){
        this.savedErrors = new ArrayList<>();
    }

    @Override
    public boolean existsById(long errorId)
    {
        return this.savedErrors
                .stream()
                .anyMatch(errorEntity -> errorEntity.getId() == errorId);
    }

    @Override
    public ErrorEntity save(ErrorEntity errorEntity) {
        errorEntity.setId(NEXT_ID);
        NEXT_ID++;
        this.savedErrors.add(errorEntity);
        return errorEntity;
    }

    @Override
    public List<ErrorEntity> findAll() {
        return Collections.unmodifiableList(this.savedErrors);
    }

    @Override
    public Optional<ErrorEntity> findById(long errorId)
    {
        return Optional.ofNullable(this.savedErrors.stream()
                .filter(errorEntity -> errorEntity.getId() == errorId)
                .findFirst()
                .orElse(null));
    }

}
