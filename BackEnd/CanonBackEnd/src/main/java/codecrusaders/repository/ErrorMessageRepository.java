package codecrusaders.repository;

import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.ErrorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ErrorMessageRepository extends JpaRepository<ErrorEntity, Long> {
    boolean existsById(long errorId);
    ErrorEntity save(ErrorEntity errorEntity);
    List<ErrorEntity> findAll();
    Optional<ErrorEntity> findById(long errorId);
}
