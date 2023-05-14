package codecrusaders.business.converters;

import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.domain.nestedstructure.TestSet;
import codecrusaders.repository.entity.TestBatchEntity;
import codecrusaders.repository.entity.TestSetEntity;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestSetConverter {
    public static TestSet toDomain(TestSetEntity entity) {
        if(entity == null){
            return null;
        }
        return TestSet.builder()
                .id(entity.getId())
                .testBatch(
                        TestBatch.builder()
                                .id(entity.getTestBatch().getId())
                                .version(entity.getTestBatch().getVersion())
                                .commitShal(entity.getTestBatch().getCommitShal())
                                .build()
                )
                .name(entity.getName())
                .regressionTests(Optional.ofNullable(entity.getRegressionTests())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(RegressionTestConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    public static TestSetEntity toEntity(TestSet domain) {
        if(domain == null){
            return null;
        }
        TestSetEntity entity = new TestSetEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setTestBatch(
                TestBatchEntity.builder()
                        .id(domain.getTestBatch().getId())
                        .version(domain.getTestBatch().getVersion())
                        .commitShal(domain.getTestBatch().getCommitShal())
                        .build()
        );
        entity.setRegressionTests(Optional.ofNullable(domain.getRegressionTests())
                .orElse(Collections.emptyList())
                .stream()
                .map(RegressionTestConverter::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
