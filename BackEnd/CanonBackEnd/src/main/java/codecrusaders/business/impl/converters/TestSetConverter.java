package codecrusaders.business.impl.converters;

import codecrusaders.domain.TestSet;
import codecrusaders.repository.entity.TestSetEntity;

public class TestSetConverter {
    public static TestSet convert(TestSetEntity tsEntity) {
        return TestSet.builder()
                .id(tsEntity.getId())
                .name(tsEntity.getTestSetName())
//                .testBatch(TestBatchConverter.convert(tsEntity.getTestBatchEntity()))
                .testSetTime(tsEntity.getTestSetTime())
                .regressionTests(tsEntity.getRegressionTestEntities().stream().map(RegrTestConverter::convert).toList())
                .build();
    }
}
