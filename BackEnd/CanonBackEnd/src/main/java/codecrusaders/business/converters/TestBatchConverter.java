package codecrusaders.business.converters;

import codecrusaders.domain.core.TestBatch;
import codecrusaders.repository.entity.TestBatchEntity;

import java.util.stream.Collectors;

public class TestBatchConverter {
    public static TestBatch toDomain(TestBatchEntity entity) {
        return TestBatch.builder()
                .id(entity.getId())
                .buildTime(entity.getBuildTime())
                .version(entity.getVersion())
                .commitShal(entity.getCommitShal())
                .branchID(entity.getBranchID())
                .testSets(entity.getTestSets().stream()
                        .map(TestSetConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    public static TestBatchEntity toEntity(TestBatch domain) {
        TestBatchEntity entity = new TestBatchEntity();
        entity.setId(domain.getId());
        entity.setBuildTime(domain.getBuildTime());
        entity.setVersion(domain.getVersion());
        entity.setCommitShal(domain.getCommitShal());
        entity.setBranchID(domain.getBranchID());
        entity.setTestSets(domain.getTestSets().stream()
                .map(TestSetConverter::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
