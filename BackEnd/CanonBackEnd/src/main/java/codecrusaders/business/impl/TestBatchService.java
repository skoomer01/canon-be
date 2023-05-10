package codecrusaders.business.impl;

import codecrusaders.business.ITestBatchService;
import codecrusaders.domain.core.TestBatch;
import codecrusaders.domain.core.TestSet;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestBatchService implements ITestBatchService {
    public TestBatch createTestBatch(TestSet testSet){
        return null;
    }
    public TestBatch getTestBatchesById(Long id){
        return null;
    }
    public List<TestBatch> getTestBatchesByBranchId(Long BranchId){
        return null;
    }
    public List<TestBatch> getTestBatches(){
        return null;
    }
}
