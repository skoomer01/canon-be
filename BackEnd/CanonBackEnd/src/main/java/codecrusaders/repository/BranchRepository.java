package codecrusaders.repository;

import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends JpaRepository<BranchEntity, Long>{

    //UserEntity findByName (String branchName);

    List<BranchEntity> findAll();
}
