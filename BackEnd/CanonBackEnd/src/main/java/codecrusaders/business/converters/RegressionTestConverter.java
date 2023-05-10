package codecrusaders.business.converters;

import codecrusaders.domain.core.RegressionTest;
import codecrusaders.repository.entity.RegressionTestEntity;

import java.util.stream.Collectors;

public class RegressionTestConverter {
    public static RegressionTest toDomain(RegressionTestEntity entity) {
        return RegressionTest.builder()
                .id(entity.getId())
                .heat(entity.getHeat())
                .duration(entity.getDuration())
                .testSetId(entity.getTestSetId())
                .subTests(entity.getSubTests().stream()
                        .map(SubTestConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    public static RegressionTestEntity toEntity(RegressionTest domain) {
        RegressionTestEntity entity = new RegressionTestEntity();
        entity.setId(domain.getId());
        entity.setHeat(domain.getHeat());
        entity.setDuration(domain.getDuration());
        entity.setTestSetId(domain.getTestSetId());
        entity.setSubTests(domain.getSubTests().stream()
                .map(SubTestConverter::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
