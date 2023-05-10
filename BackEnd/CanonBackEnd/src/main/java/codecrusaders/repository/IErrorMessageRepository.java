package codecrusaders.repository;

import codecrusaders.repository.entity.ErrorMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IErrorMessageRepository extends JpaRepository<ErrorMessageEntity, Long> {
}
