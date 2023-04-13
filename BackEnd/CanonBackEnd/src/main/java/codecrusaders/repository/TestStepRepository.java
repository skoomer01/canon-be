package codecrusaders.repository;

import codecrusaders.repository.entity.TestStepEntity;

import java.util.List;

public interface TestStepRepository {
    boolean existsById(long testStepId);
    TestStepEntity save(TestStepEntity testStep);
    public boolean stepExistByError(String errorMessage);
    public List<TestStepEntity> findAll();
}
