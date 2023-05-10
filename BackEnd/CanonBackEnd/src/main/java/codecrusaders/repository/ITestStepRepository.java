package codecrusaders.repository;

import codecrusaders.repository.entity.TestStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITestStepRepository extends JpaRepository<TestStepEntity, Long> {
}
