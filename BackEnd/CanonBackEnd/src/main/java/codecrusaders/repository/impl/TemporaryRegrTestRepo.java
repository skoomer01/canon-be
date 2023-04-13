package codecrusaders.repository.impl;

import codecrusaders.repository.RegrTestRepository;
import codecrusaders.repository.entity.RegressionTestEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Repository
public class TemporaryRegrTestRepo implements RegrTestRepository {
    private static long NEXT_ID = 1;
    private final List<RegressionTestEntity> savedRegrTests;
    public TemporaryRegrTestRepo() {
        this.savedRegrTests = new ArrayList<>();
    }
    @Override
    public boolean existsById(long id){
       return this.savedRegrTests
               .stream()
               .anyMatch(regressionTestEntity -> regressionTestEntity.getId().equals(id));
    }
    @Override
    public RegressionTestEntity save(RegressionTestEntity testSet){
        testSet.setId(NEXT_ID);
        NEXT_ID++;
        this.savedRegrTests.add(testSet);
        return testSet;
    }
    public void deleteById(long id){
        this.savedRegrTests.removeIf(regressionTestEntity -> regressionTestEntity.getId().equals(id));
    }
    public List<RegressionTestEntity> findAll(){
        return Collections.unmodifiableList(this.savedRegrTests);
    }
    @Override
    public RegressionTestEntity findById(long id){
        return this.savedRegrTests
                .stream()
                .filter(Entity -> Entity.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
