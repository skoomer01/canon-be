package codecrusaders.business.converters;

import codecrusaders.domain.core.TestSet;
import codecrusaders.repository.entity.TestSetEntity;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestSetConverter {
    public static TestSet toDomain(TestSetEntity entity) {
        return TestSet.builder()
                .id(entity.getId())
                .testBatchId(entity.getTestBatchId())
                .regressionTests(Optional.ofNullable(entity.getRegressionTests())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(RegressionTestConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    public static TestSetEntity toEntity(TestSet domain) {
        TestSetEntity entity = new TestSetEntity();
        entity.setId(domain.getId());
        entity.setTestBatchId(domain.getTestBatchId());
        entity.setRegressionTests(Optional.ofNullable(domain.getRegressionTests())
                .orElse(Collections.emptyList())
                .stream()
                .map(RegressionTestConverter::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
