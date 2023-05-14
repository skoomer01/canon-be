package codecrusaders.repository;

import codecrusaders.repository.entity.RegressionTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegressionTestRepository extends JpaRepository<RegressionTestEntity, Long> {
}
