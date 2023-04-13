package codecrusaders.repository.impl;

import codecrusaders.repository.TestSetRepository;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.TestSetEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Repository
public class TemporaryTestSetRepo implements TestSetRepository {
    private static long NEXT_ID = 1;
    private final List<TestSetEntity> savedTestSets;
    public TemporaryTestSetRepo() {
        this.savedTestSets = new ArrayList<>();
    }
    @Override
    public boolean existsById(long id){
        return this.savedTestSets
                .stream()
                .anyMatch(regressionTestEntity -> regressionTestEntity.getId().equals(id));
    }
    @Override
    public TestSetEntity save(TestSetEntity testSet){
        testSet.setId(NEXT_ID);
        NEXT_ID++;
        this.savedTestSets.add(testSet);
        return testSet;
    }
    public void deleteById(long id){
        this.savedTestSets.removeIf(regressionTestEntity -> regressionTestEntity.getId().equals(id));
    }
    public List<TestSetEntity> findAll(){
        return Collections.unmodifiableList(this.savedTestSets);
    }
    @Override
    public TestSetEntity findById(long id){
        return this.savedTestSets
                .stream()
                .filter(testSetEntity -> testSetEntity.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
