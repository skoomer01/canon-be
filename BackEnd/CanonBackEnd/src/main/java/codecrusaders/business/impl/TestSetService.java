package codecrusaders.business.impl;

import codecrusaders.business.ITestSetService;
import codecrusaders.domain.core.TestSet;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestSetService implements ITestSetService {
    public TestSet createTestSet(TestSet testSet){
        return null;
    }
    public TestSet getTestSetById(Long id){
        return null;
    }
    public List<TestSet> getTestSetsByTestBatchId(Long testBatchId){
        return null;
    }
    public List<TestSet> getTestSets(){
        return null;
    }
}
