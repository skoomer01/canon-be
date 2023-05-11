package codecrusaders.repository;

import codecrusaders.repository.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBranchRepository extends JpaRepository<BranchEntity, Long> {
    @Query("SELECT DISTINCT b " +
            "FROM BranchEntity b " +
            "JOIN b.testBatches tb " +
            "JOIN tb.testSets ts " +
            "JOIN ts.regressionTests rt " +
            "JOIN rt.subTests st " +
            "JOIN st.testSteps tstep " +
            "JOIN tstep.message em " +
            "WHERE em.id = :errorID")
    List<BranchEntity> findBranchesByErrorID(@Param("errorID") Long errorID);

    @Query("SELECT DISTINCT b " +
            "FROM BranchEntity b " +
            "JOIN b.testBatches tb " +
            "WHERE tb.commitShal = :commitShal")
    List<BranchEntity> findBranchesByCommit(@Param("commitShal") String commitShal);

    @Query("SELECT DISTINCT b " +
            "FROM BranchEntity b " +
            "JOIN b.testBatches tb " +
            "WHERE tb.version = :version")
    List<BranchEntity> findBranchesByVersion(@Param("version") String version);
}
