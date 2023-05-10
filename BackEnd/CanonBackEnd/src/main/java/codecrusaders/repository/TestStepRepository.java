package codecrusaders.repository;

import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.TestStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TestStepRepository extends JpaRepository<TestStepEntity, Long> {
//    boolean existsById(long testStepId);
//    boolean stepExistByError(String errorMessage);
    List<TestStepEntity> findAll();
}
