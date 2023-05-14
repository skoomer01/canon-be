package codecrusaders.business.impl;

import codecrusaders.business.ITestSetService;
import codecrusaders.business.converters.TestBatchConverter;
import codecrusaders.business.converters.TestSetConverter;
import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.domain.nestedstructure.TestSet;
import codecrusaders.repository.ITestSetRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestSetService implements ITestSetService {

    @Autowired
    private ITestSetRepository repository;
    public TestSet createTestSet(TestSet testSet){
        return TestSetConverter.toDomain(repository.save(TestSetConverter.toEntity(testSet)));
    }
    public TestSet getTestSetById(Long id){
        return null;
    }
    public List<TestSet> getTestSetsByTestBatchId(Long testBatchId){
        return null;
    }
    public List<TestSet> getTestSets(){
        List<TestSet> result = repository.findAll().stream()
                .map(TestSetConverter::toDomain)
                .collect(Collectors.toList());
        result.forEach(r -> r.setTestResult());
        return result;
    }
}
