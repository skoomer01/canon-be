package codecrusaders.repository.impl;

import codecrusaders.repository.SubTestRepository;
import codecrusaders.repository.entity.SubTestEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Repository
public class TemporarySubTestRepo implements SubTestRepository {
    private static long NEXT_ID = 1;

    private final List<SubTestEntity> savedSubTests;

    public TemporarySubTestRepo(){
        this.savedSubTests = new ArrayList<>();
    }

    @Override
    public boolean existsById(long testStepId)
    {
        return this.savedSubTests
                .stream()
                .anyMatch(testStepEntity -> testStepEntity.getId() == testStepId);
    }

    @Override
    public SubTestEntity save(SubTestEntity testStep) {
        testStep.setId(NEXT_ID);
        NEXT_ID++;
        this.savedSubTests.add(testStep);
        return testStep;
    }

    @Override
    public List<SubTestEntity> findAll() {
        return Collections.unmodifiableList(this.savedSubTests);
    }
}
