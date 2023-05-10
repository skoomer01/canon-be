package codecrusaders.business.impl;

import codecrusaders.business.IRegressionTestManager;
import codecrusaders.business.impl.converters.RegrTestConverter;
import codecrusaders.domain.*;
import codecrusaders.repository.RegrTestRepository;
import codecrusaders.repository.TestSetRepository;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.TestSetEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class RegrTestManager implements IRegressionTestManager {

    private final RegrTestRepository regrTestRepo;
    private final TestSetRepository testSetRepo;
    @Override
    public CreateRegrTestResponse createRegressionTest(CreateRegrTestRequest request){
        Optional<RegressionTestEntity> savedRegrTest = saveNewRegrTest(request);
        return savedRegrTest.map(testSetEntity -> CreateRegrTestResponse.builder().id(testSetEntity.getId()).build()).orElse(null);
    }
    private Optional<RegressionTestEntity> saveNewRegrTest(CreateRegrTestRequest request){
        RegressionTestEntity newRegrTest = RegressionTestEntity.builder()
                .testSetId(request.getTestSetId())
                .testResult(request.isTestResult())
                .duration(request.getDuration())
                .build();
        return Optional.of(regrTestRepo.save(newRegrTest));
    }

    @Override
    public GetRegressionTestResponse getAllRegrTests(){
        List<RegressionTest> regressionTests = regrTestRepo.findAll()
                .stream()
                .map(RegrTestConverter::convert)
                .toList();
        return GetRegressionTestResponse.builder()
                .regressionTests(regressionTests)
                .build();
    }
}
