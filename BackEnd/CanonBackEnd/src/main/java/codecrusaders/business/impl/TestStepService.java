package codecrusaders.business.impl;
import codecrusaders.business.ITestStepService;
import codecrusaders.domain.core.TestStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TestStepService implements ITestStepService {

    public TestStep createTestStep(TestStep testStep){
        return null;
    }
    public TestStep getTestStepById(Long id){
        return null;
    }
    public List<TestStep> getTestStepsBySubTestId(Long subTestId){
        return null;
    }
    public List<TestStep> getTestSteps(){
        return null;
    }

}
