package codecrusaders.repository;

import codecrusaders.repository.entity.TestBatchEntity;
import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TestBatchRepository extends JpaRepository<TestBatchEntity, Long> {
    @Query(value = "SELECT * FROM testbatches WHERE branchid = :branchId", nativeQuery = true)
    List<TestBatchEntity> getAllTestBatchesByBranchEntityId(@Param("branchId")Long branchId);
}
