package codecrusaders.repository;

import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegrTestRepository extends JpaRepository<RegressionTestEntity, Long> {
    boolean existsById(long id);

    RegressionTestEntity save(RegressionTestEntity testSet);

    void deleteById(long id);

    List<RegressionTestEntity> findAll();

    RegressionTestEntity findById(long id);

    @Query(
            value = "SELECT TOP 6 * FROM tests ORDER BY testid DESC",
            nativeQuery = true
    )
    List<RegressionTestEntity> findLatestTests();
}
