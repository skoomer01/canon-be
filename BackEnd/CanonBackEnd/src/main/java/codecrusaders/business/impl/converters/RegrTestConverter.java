package codecrusaders.business.impl.converters;

import codecrusaders.domain.RegressionTest;
import codecrusaders.repository.entity.RegressionTestEntity;

public class RegrTestConverter {
    public static RegressionTest convert(RegressionTestEntity rtEntity) {
        return RegressionTest.builder()
                .id(rtEntity.getId())
                .testSetId(rtEntity.getTestSetId())
                .build();
    }
}
