package codecrusaders.repository.impl;

import codecrusaders.repository.TestStepRepository;
import codecrusaders.repository.entity.TestStepEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Repository
public class TemporaryTestStepRepo implements TestStepRepository {

    private static long NEXT_ID = 1;

    private final List<TestStepEntity> savedTestSteps;

    public TemporaryTestStepRepo(){
        this.savedTestSteps = new ArrayList<>();
    }

    @Override
    public boolean existsById(long testStepId)
    {
        return this.savedTestSteps
                .stream()
                .anyMatch(testStepEntity -> testStepEntity.getId() == testStepId);
    }

    @Override
    public TestStepEntity save(TestStepEntity testStep) {
        testStep.setId(NEXT_ID);
        NEXT_ID++;
        this.savedTestSteps.add(testStep);
        return testStep;
    }

    @Override
    public boolean stepExistByError(String errorMessage) {
        return this.savedTestSteps
                .stream()
                .anyMatch(userEntity -> userEntity.getMessage().getMessage().equals(errorMessage));
    }

    @Override
    public List<TestStepEntity> findAll() {
        return Collections.unmodifiableList(this.savedTestSteps);
    }
}
