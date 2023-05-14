package codecrusaders.business.converters;

import codecrusaders.domain.nestedstructure.RegressionTest;
import codecrusaders.domain.nestedstructure.SubTest;
import codecrusaders.domain.nestedstructure.TestSet;
import codecrusaders.repository.entity.RegressionTestEntity;
import codecrusaders.repository.entity.TestSetEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class RegressionTestConverter {
    public static RegressionTest toDomain(RegressionTestEntity entity) {
        if(entity == null){
            return null;
        }
        List<SubTest> subTests = Optional.ofNullable(entity.getSubTests())
                .orElse(Collections.emptyList())
                .stream()
                .map(SubTestConverter::toDomain)
                .collect(Collectors.toList());
        return RegressionTest.builder()
                .id(entity.getId())
                .name(entity.getName())
                .heat(entity.getHeat())
                .duration(entity.getDuration())
                .testSet(
                        TestSet.builder()
                                .id(entity.getTestSet().getId())
                                .name(entity.getTestSet().getName())
                                .build()
                )
                .subTests(subTests)
                .build();
    }

    public static RegressionTestEntity toEntity(RegressionTest domain) {
        if(domain == null){
            return null;
        }
        return RegressionTestEntity.builder()
                .id(domain.getId())
                .name(domain.getName())
                .heat(domain.getHeat())
                .duration(domain.getDuration())
                .testSet(
                        TestSetEntity.builder()
                                .id(domain.getTestSet().getId())
                                .name(domain.getTestSet().getName())
                                .build()
                )
                .subTests(Optional.ofNullable(domain.getSubTests())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(SubTestConverter::toEntity)
                        .collect(Collectors.toList()))
                .build();
    }

}
