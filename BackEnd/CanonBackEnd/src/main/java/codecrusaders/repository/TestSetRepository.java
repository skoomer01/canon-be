package codecrusaders.repository;

import codecrusaders.domain.TestSet;
import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TestSetRepository extends JpaRepository<TestSetEntity, Long> {
    boolean existsById(long id);

    TestSetEntity save(TestSetEntity testSet);

    void deleteById(long id);

    List<TestSetEntity> findAll();

    TestSetEntity findById(long id);

    @Query(
            value = "SELECT TOP 6 * FROM testsets ORDER BY testsetid DESC",
            nativeQuery = true
    )
    List<TestSetEntity> findLatestTestSets();
}
