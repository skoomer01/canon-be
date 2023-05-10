package codecrusaders.repository;

import codecrusaders.repository.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBranchRepository extends JpaRepository<BranchEntity, Long> {
    @Query(value = "SELECT DISTINCT b.* " +
            "FROM branch b " +
            "JOIN test_batch tb ON b.id = tb.branch_id " +
            "JOIN test_set ts ON tb.id = ts.test_batch_id " +
            "JOIN regression_test rt ON ts.id = rt.test_set_id " +
            "JOIN sub_test st ON rt.id = st.regression_test_id " +
            "JOIN test_step tstep ON st.id = tstep.sub_test_id " +
            "JOIN error_message em ON tstep.message_id = em.id " +
            "WHERE em.id = :errorID", nativeQuery = true)
    List<BranchEntity> findBranchesByErrorID(@Param("errorID") Long errorID);

}
