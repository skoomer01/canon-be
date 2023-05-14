package codecrusaders.business.impl;

import codecrusaders.business.IRegressionTestService;
import codecrusaders.business.converters.RegressionTestConverter;
import codecrusaders.business.converters.SubTestConverter;
import codecrusaders.domain.nestedstructure.RegressionTest;
import codecrusaders.domain.nestedstructure.SubTest;
import codecrusaders.repository.IRegressionTestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RegressionTestService implements IRegressionTestService {

    @Autowired
    private IRegressionTestRepository repository;
    @Override
    public RegressionTest createRegressionTest(RegressionTest regressionTest){
        return RegressionTestConverter.toDomain(repository.save(RegressionTestConverter.toEntity(regressionTest)));
    }
    public RegressionTest getRegressionTestById(Long id){
        return null;
    }
    public List<RegressionTest> getRegressionTestsByTestSetId(Long testSetId){
        return null;
    }
    public List<RegressionTest> getRegressionTests(){
        List<RegressionTest> result = repository.findAll().stream()
                .map(RegressionTestConverter::toDomain)
                .collect(Collectors.toList());
        result.forEach(r -> r.setTestResult());
        return result;
    }
}
