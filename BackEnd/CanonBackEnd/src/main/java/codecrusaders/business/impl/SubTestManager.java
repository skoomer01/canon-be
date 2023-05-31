package codecrusaders.business.impl;

import codecrusaders.business.ISubTestManager;
import codecrusaders.business.impl.converters.SubTestConverter;

import codecrusaders.domain.*;
import codecrusaders.repository.SubTestRepository;
import codecrusaders.repository.entity.SubTestEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubTestManager implements ISubTestManager {
    private final SubTestRepository subTestRepository;
    @Override
    public CreateSubTestResponse registerSubTest(CreateSubTestRequest request)
    {
        SubTestEntity savedSubTest = saveNewSubTest(request);
        return CreateSubTestResponse.builder()
                .subTestId(savedSubTest.getId())
                .build();
    }

    private SubTestEntity saveNewSubTest(CreateSubTestRequest request) {
        SubTestEntity newSubTest = SubTestEntity.builder()
                //.testResult(request.isTestResult())
                .testID(request.getTestId())
                .build();
        return subTestRepository.save(newSubTest);
    }
    @Override
    public GetSubTestsResponse getSubTests() {
        List<SubTest> subTests = subTestRepository.findAll()
                .stream()
                .map(SubTestConverter::convert)
                .toList();

        return GetSubTestsResponse.builder()
                .subTests(subTests)
                .build();
    }




    @Override
    public GetSubTestsResponse getSubTestsByTestID(Long id) {
        List<SubTest> subTests = subTestRepository.findByTestID(id)
                .stream()
                .map(SubTestConverter::convert)
                .toList();

        return GetSubTestsResponse.builder()
                .subTests(subTests)
                .build();
    }

    @Override
    public GetSubTestsResponse findById(Long id) {
        List<SubTest> subTests = subTestRepository.findById(id)
                .stream()
                .map(SubTestConverter::convert)
                .toList();

        return GetSubTestsResponse.builder()
                .subTests(subTests)
                .build();
    }
}
