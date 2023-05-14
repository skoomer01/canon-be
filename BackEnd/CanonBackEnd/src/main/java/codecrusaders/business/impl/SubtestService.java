package codecrusaders.business.impl;

import codecrusaders.business.ISubTestService;

import codecrusaders.business.converters.SubTestConverter;
import codecrusaders.business.converters.TestSetConverter;
import codecrusaders.domain.nestedstructure.SubTest;
import codecrusaders.domain.nestedstructure.TestSet;
import codecrusaders.repository.ISubTestRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubtestService implements ISubTestService {

    @Autowired
    private ISubTestRepository repository;

    @Override
    public SubTest createSubTest(SubTest subTest){
        return SubTestConverter.toDomain(repository.save(SubTestConverter.toEntity(subTest)));
    }
    public SubTest getSubtestById(Long id){
        return null;
    }
    public List<SubTest> getSubtestsByRegressionTestId(Long regressionTestId){
        return null;
    }
    public List<SubTest> getSubtests(){
        List<SubTest> result = repository.findAll().stream()
                .map(SubTestConverter::toDomain)
                .collect(Collectors.toList());
        result.forEach(r -> r.setTestResult());
        return result;
    }
}
