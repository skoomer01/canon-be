package codecrusaders.repository;

import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.SubTestEntity;
import codecrusaders.repository.entity.TestStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SubTestRepository extends JpaRepository<SubTestEntity, Long> {
    boolean existsById(long subTestId);
    SubTestEntity save(SubTestEntity subTestEntity);
    List<SubTestEntity> findAll();

    List<SubTestEntity> findByTestID(Long testId);

}
