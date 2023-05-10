package codecrusaders.business.converters;

import codecrusaders.domain.core.Branch;
import codecrusaders.domain.core.TestBatch;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.TestBatchEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BranchConverter {
    public static Branch toDomain(BranchEntity entity) {
        List<TestBatch> testBatchList = Optional.ofNullable(entity.getTestBatches())
                .orElse(Collections.emptyList())
                .stream()
                .map(TestBatchConverter::toDomain)
                .collect(Collectors.toList());
        return Branch.builder()
                .id(entity.getId())
                .branchName(entity.getBranchName())
                .visibility(entity.getVisibility())
                .createdUser(AccountConverter.toDomain(entity.getCreatedUser()))
                .testBatches(testBatchList)
                .build();
    }


    public static BranchEntity toEntity(Branch domain) {
        List<TestBatchEntity> testBatchEntityList = Optional.ofNullable(domain.getTestBatches())
                .orElse(Collections.emptyList())
                .stream()
                .map(TestBatchConverter::toEntity)
                .collect(Collectors.toList());
        BranchEntity entity = new BranchEntity();
        entity.setId(domain.getId());
        entity.setBranchName(domain.getBranchName());
        entity.setVisibility(domain.getVisibility());
        entity.setCreatedUser(AccountConverter.toEntity(domain.getCreatedUser()));
        entity.setTestBatches(testBatchEntityList);
        return entity;
    }
}
