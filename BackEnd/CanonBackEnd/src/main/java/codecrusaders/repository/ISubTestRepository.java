package codecrusaders.repository;

import codecrusaders.repository.entity.SubTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubTestRepository extends JpaRepository<SubTestEntity, Long> {
}
