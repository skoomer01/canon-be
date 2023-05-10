package codecrusaders.business.converters;

import codecrusaders.domain.core.RegressionTest;
import codecrusaders.domain.core.SubTest;
import codecrusaders.domain.core.TestBatch;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.SubTestEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RegressionTestConverter {
    public static RegressionTest toDomain(RegressionTestEntity entity) {
        List<SubTest> subTests = Optional.ofNullable(entity.getSubTests())
                .orElse(Collections.emptyList())
                .stream()
                .map(SubTestConverter::toDomain)
                .collect(Collectors.toList());
        return RegressionTest.builder()
                .id(entity.getId())
                .heat(entity.getHeat())
                .duration(entity.getDuration())
                .testSetId(entity.getTestSetId())
                .subTests(subTests)
                .build();
    }

    public static RegressionTestEntity toEntity(RegressionTest domain) {
        return RegressionTestEntity.builder()
                .id(domain.getId())
                .heat(domain.getHeat())
                .duration(domain.getDuration())
                .testSetId(domain.getTestSetId())
                .subTests(Optional.ofNullable(domain.getSubTests())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(SubTestConverter::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
