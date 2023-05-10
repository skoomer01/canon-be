package codecrusaders.repository;

import codecrusaders.repository.entity.TestBatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestbatchRepository extends JpaRepository<TestBatchEntity, Long> {
}
