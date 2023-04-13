package codecrusaders.business.impl.converters;

import codecrusaders.domain.TestStep;
import codecrusaders.repository.entity.TestStepEntity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TestStepConverter {

    public static TestStep convert(TestStepEntity testStepEntity) {
        return TestStep.builder()
                .id(testStepEntity.getId())
                .testResult(testStepEntity.isTestResult())
                .description(testStepEntity.getDescription())
                .message(ErrorMessageConverter.convert(testStepEntity.getMessage()))
                .subTestId(testStepEntity.getSubTestId())
                .build();
    }
}
