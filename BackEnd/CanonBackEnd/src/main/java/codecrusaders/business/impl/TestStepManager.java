package codecrusaders.business.impl;
import codecrusaders.business.ITestStepManager;
import codecrusaders.business.impl.converters.ErrorMessageConverter;
import codecrusaders.business.impl.converters.TestStepConverter;
import codecrusaders.domain.*;
import codecrusaders.repository.ErrorMessageRepository;
import codecrusaders.repository.TestStepRepository;
import codecrusaders.repository.entity.ErrorEntity;
import codecrusaders.repository.entity.TestStepEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TestStepManager implements ITestStepManager {
    private final TestStepRepository testStepRepository;
    private final ErrorMessageRepository errorMessageRepository;
    @Override
    public CreateTestStepResponse registerTestStep(CreateTestStepRequest request)
    {
        TestStepEntity savedTestStep = saveNewTestStepEntity(request);
        return CreateTestStepResponse.builder()
                .testStepId(savedTestStep.getId())
                .build();
    }

    private TestStepEntity saveNewTestStepEntity(CreateTestStepRequest request) {
            TestStepEntity newTestStep = TestStepEntity.builder()
                    .testResult(request.isTestResult())
                    .description(request.getDescription())
                    //.message(convertErrorMessage(request.getMessage()))
                    .subTestID(request.getSubTestId())
                    .build();
            errorMessageRepository.save(convertErrorMessage(request.getMessage()));
            return testStepRepository.save(newTestStep);
    }
    private ErrorEntity convertErrorMessage(ErrorMessage errorMessage)
    {
        return ErrorEntity.builder()
                //.message(errorMessage.getMessage())
                .build();
    }

    @Override
    public GetTestStepsResponse getTestSteps() {
        List<TestStep> testSteps = testStepRepository.findAll()
                .stream()
                .map(TestStepConverter::convert)
                .toList();

        return GetTestStepsResponse.builder()
                .testSteps(testSteps)
                .build();
    }

    @Override
    public GetTestStepsResponse getTestStepBySubTestId(Long subTestId){
        List<TestStep> testSteps = testStepRepository.findBySubTestID(subTestId)
                .stream()
                .map(TestStepConverter::convert)
                .toList();

        return GetTestStepsResponse.builder()
                .testSteps(testSteps)
                .build();
    }

    @Override
    public Optional<TestStep> getTestStepById(Long id) {
        Optional<TestStepEntity> testStepEntityOptional = testStepRepository.findById(id);
        return testStepEntityOptional.map(TestStepConverter::convert);
    }
}
