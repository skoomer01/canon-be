package codecrusaders.business.impl;

import codecrusaders.business.ITestBatchService;
import codecrusaders.business.converters.BranchConverter;
import codecrusaders.business.converters.TestBatchConverter;
import codecrusaders.domain.nestedstructure.Branch;
import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.domain.nestedstructure.TestSet;
import codecrusaders.repository.ITestbatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestBatchService implements ITestBatchService {

    @Autowired
    private ITestbatchRepository repository;

    @Override
    public TestBatch createTestBatch(TestBatch testBatch){
        return TestBatchConverter.toDomain(repository.save(TestBatchConverter.toEntity(testBatch)));
    }
    public TestBatch getTestBatchesById(Long id){
        return null;
    }
    public List<TestBatch> getTestBatchesByBranchId(Long BranchId){
        return null;
    }
    @Override
    public List<TestBatch> getTestBatches(){
        List<TestBatch> testBatches = repository.findAll().stream()
                .map(TestBatchConverter::toDomain)
                .collect(Collectors.toList());
        testBatches.forEach(testBatch -> testBatch.setTestResult());
        return testBatches;
    }
}
