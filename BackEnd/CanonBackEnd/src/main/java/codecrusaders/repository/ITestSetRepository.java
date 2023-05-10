package codecrusaders.repository;

import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestSetRepository extends JpaRepository<TestSetEntity, Long> {
}
