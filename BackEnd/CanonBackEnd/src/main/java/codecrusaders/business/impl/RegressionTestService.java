package codecrusaders.business.impl;

import codecrusaders.business.IRegressionTestService;
import codecrusaders.domain.core.RegressionTest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RegressionTestService implements IRegressionTestService {

    public RegressionTest createRegressionTest(RegressionTest regressionTest){
        return null;
    }
    public RegressionTest getRegressionTestById(Long id){
        return null;
    }
    public List<RegressionTest> getRegressionTestsByTestSetId(Long testSetId){
        return null;
    }
    public List<RegressionTest> getRegressionTests(){
        return null;
    }
}
