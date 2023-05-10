package codecrusaders.business.converters;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.core.SubTest;
import codecrusaders.domain.core.TestStep;
import codecrusaders.repository.entity.SubTestEntity;
import codecrusaders.repository.entity.TestStepEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SubTestConverter {
    public static SubTest toDomain(SubTestEntity entity) {
        return SubTest.builder()
                .id(entity.getId())
                .regressionTestID(entity.getRegressionTestID())
                .testSteps(Optional.ofNullable(entity.getTestSteps())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(TestStepConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }
    public static SubTestEntity toEntity(SubTest domain) {
        return SubTestEntity.builder()
                .id(domain.getId())
                .regressionTestID(domain.getRegressionTestID())
                .testSteps(Optional.ofNullable(domain.getTestSteps())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(TestStepConverter::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
