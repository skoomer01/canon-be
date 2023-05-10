package codecrusaders.business.impl;

import codecrusaders.business.ISubTestService;

import codecrusaders.domain.core.SubTest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubtestService implements ISubTestService {
    public SubTest createSubTest(SubTest subTest){
        return null;
    }
    public SubTest getSubtestById(Long id){
        return null;
    }
    public List<SubTest> getSubtestsByRegressionTestId(Long regressionTestId){
        return null;
    }
    public List<SubTest> getSubtests(){
        return null;
    }
}
