package codecrusaders.business.impl;
import codecrusaders.business.ITestStepService;
import codecrusaders.business.converters.TestSetConverter;
import codecrusaders.business.converters.TestStepConverter;
import codecrusaders.domain.nestedstructure.TestSet;
import codecrusaders.domain.nestedstructure.TestStep;
import codecrusaders.repository.ITestStepRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TestStepService implements ITestStepService {

    @Autowired
    private ITestStepRepository repository;

    public TestStep createTestStep(TestStep testStep){
        return TestStepConverter.toDomain(repository.save(TestStepConverter.toEntity(testStep)));
    }
    public TestStep getTestStepById(Long id){
        return null;
    }
    public List<TestStep> getTestStepsBySubTestId(Long subTestId){
        return null;
    }
    public List<TestStep> getTestSteps(){
        List<TestStep> result = repository.findAll().stream()
                .map(TestStepConverter::toDomain)
                .collect(Collectors.toList());
        result.forEach(r -> r.setTestResult());
        return result;
    }

}
