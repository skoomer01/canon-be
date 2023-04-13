package codecrusaders.repository;

import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface RegrTestRepository {
    boolean existsById(long id);

    RegressionTestEntity save(RegressionTestEntity testSet);

    void deleteById(long id);

    List<RegressionTestEntity> findAll();

    RegressionTestEntity findById(long id);
}
