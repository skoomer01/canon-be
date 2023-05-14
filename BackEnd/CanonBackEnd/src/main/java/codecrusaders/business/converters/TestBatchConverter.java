package codecrusaders.business.converters;

import codecrusaders.domain.nestedstructure.Branch;
import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.TestBatchEntity;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestBatchConverter {
    public static TestBatch toDomain(TestBatchEntity entity) {
        if(entity == null){
            return null;
        }
        return TestBatch.builder()
                .id(entity.getId())
                .buildTime(entity.getBuildTime())
                .version(entity.getVersion())
                .commitShal(entity.getCommitShal())
                .branch(
                        Branch.builder()
                                .id(entity.getBranch().getId())
                                .name(entity.getBranch().getName())
                                .build()
                )
                .testSets(Optional.ofNullable(entity.getTestSets())
                        .orElse(Collections.emptyList())
                        .stream()
                        .map(TestSetConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    public static TestBatchEntity toEntity(TestBatch domain) {
        if(domain == null){
            return null;
        }
        TestBatchEntity entity = new TestBatchEntity();
        entity.setId(domain.getId());
        entity.setBuildTime(domain.getBuildTime());
        entity.setVersion(domain.getVersion());
        entity.setCommitShal(domain.getCommitShal());
        entity.setBranch(
                BranchEntity.builder().build().builder()
                .id(domain.getBranch().getId())
                .name(domain.getBranch().getName())
                .build());
        entity.setTestSets(Optional.ofNullable(domain.getTestSets())
                .orElse(Collections.emptyList())
                .stream()
                .map(TestSetConverter::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
