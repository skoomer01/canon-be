package codecrusaders.repository;

import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RegrTestRepository extends JpaRepository<RegressionTestEntity, Long> {
    boolean existsById(long id);

    RegressionTestEntity save(RegressionTestEntity testSet);

    void deleteById(long id);

    List<RegressionTestEntity> findAll();


//    @Query("select rt from RegressionTestEntity rt order by rt.id DESC")
    @Query(
            value = "SELECT TOP 6 * FROM tests ORDER BY testid DESC",
            nativeQuery = true
    )
    List<RegressionTestEntity> findLatestTests();


    @Query(value = "SELECT * FROM tests WHERE testsetid = :testsetid", nativeQuery = true)
    List<RegressionTestEntity> getTestsByTestSetId(@Param("testsetid")Long testSetId);


    @Query(value = "SELECT COUNT(*) FROM teststeps ts" +
            "                   JOIN subtests st ON ts.subtestid = st.subtestid" +
            "                   WHERE st.subtestid = :subtestid AND ts.testresult = 0", nativeQuery = true)
    int countFailedTestStepsByTestID(@Param("subtestid") Long testId);

}
