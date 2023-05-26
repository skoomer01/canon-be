package codecrusaders.business;

import codecrusaders.domain.GetAllTestSetFromABatchRequest;
import codecrusaders.domain.GetAllTestSetFromABatchResponse;

public interface ITestBatchManager {
    public GetAllTestSetFromABatchResponse getAllTestSetsWithBatchId(GetAllTestSetFromABatchRequest request);
}
