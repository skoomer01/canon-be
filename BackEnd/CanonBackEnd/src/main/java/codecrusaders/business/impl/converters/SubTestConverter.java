package codecrusaders.business.impl.converters;

import codecrusaders.domain.SubTest;
import codecrusaders.repository.entity.SubTestEntity;

public class SubTestConverter {
    public static SubTest convert(SubTestEntity subTestEntity) {
        return SubTest.builder()
                .id(subTestEntity.getId())
                .testResult(subTestEntity.isTestResult())
                .testId(subTestEntity.getTestId())
                .build();
    }
}
