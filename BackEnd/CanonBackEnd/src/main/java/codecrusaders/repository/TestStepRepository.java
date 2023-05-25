package codecrusaders.repository;

import codecrusaders.controller.TestStepController;
import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.TestStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestStepRepository extends JpaRepository<TestStepEntity, Long> {
//    boolean existsById(long testStepId);
//    boolean stepExistByError(String errorMessage);
    List<TestStepEntity> findAll();
    List<TestStepEntity> findBySubTestID(Long subTestID);
    Optional<TestStepEntity> findById(Long id);
}
