package codecrusaders.repository;

import codecrusaders.domain.TestSet;
import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TestSetRepository {
    boolean existsById(long id);

    TestSetEntity save(TestSetEntity testSet);

    void deleteById(long id);

    List<TestSetEntity> findAll();

    TestSetEntity findById(long id);
}
