package codecrusaders.business.impl;

import codecrusaders.business.ITestSetManager;
import codecrusaders.business.impl.converters.RegrTestConverter;
import codecrusaders.business.impl.converters.TestSetConverter;
import codecrusaders.domain.*;
import codecrusaders.repository.RegrTestRepository;
import codecrusaders.repository.TestSetRepository;
import codecrusaders.repository.entity.TestSetEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestSetManager implements ITestSetManager {
    private final RegrTestRepository regrTestRepo;
    private final TestSetRepository testSetRepo;
    @Override
    public CreateTestSetResponse createTestSet(CreateTestSetRequest request){
        Optional<TestSetEntity> savedTestSet = saveNewTestSet(request);
        return savedTestSet.map(testSetEntity -> CreateTestSetResponse.builder().id(testSetEntity.getId()).build()).orElse(null);
    }
    private Optional<TestSetEntity> saveNewTestSet(CreateTestSetRequest request){
        TestSetEntity newTestSet = TestSetEntity.builder()
                .testBatchId(request.getTestBatchId())
                .build();
        return Optional.of(testSetRepo.save(newTestSet));
    }

    @Override
    public GetTestSetResponse getAllTestSets(){
        List<TestSet> testSets = testSetRepo.findAll()
                .stream()
                .map(TestSetConverter::convert)
                .toList();
        return GetTestSetResponse.builder()
                .testSets(testSets)
                .build();
    }

    @Override
    public GetLatestTestSetsResponse getLatestTestSets() {
        List<TestSet> latestTestSets = testSetRepo.findLatestTestSets()
                .stream()
                .map(TestSetConverter::convert)
                .toList();
        return GetLatestTestSetsResponse.builder().latestTestSets(latestTestSets).build();
    }

}
