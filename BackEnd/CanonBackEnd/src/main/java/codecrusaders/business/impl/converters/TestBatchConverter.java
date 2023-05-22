package codecrusaders.business.impl.converters;

import codecrusaders.domain.SubTest;
import codecrusaders.domain.TestBatch;
import codecrusaders.repository.entity.SubTestEntity;
import codecrusaders.repository.entity.TestBatchEntity;

public class TestBatchConverter {

    public static TestBatch convert(TestBatchEntity entity) {
        return TestBatch.builder().id(entity.getId())
                .version(entity.getVersion())
                .buildTime(entity.getBuildTime())
                .commitShal(entity.getCommitShal())
                .branch(BranchConverter.convert(entity.getBranchEntity()))
                .dateTime(entity.getDateTime())
                .testSets(entity.getTestSetEntities().stream().map(TestSetConverter::convert).toList())
                .build();
    }
}
