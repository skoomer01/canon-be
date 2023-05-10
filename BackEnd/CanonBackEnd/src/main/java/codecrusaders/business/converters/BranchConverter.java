package codecrusaders.business.converters;

import codecrusaders.domain.core.Branch;
import codecrusaders.repository.entity.BranchEntity;

import java.util.stream.Collectors;

public class BranchConverter {
    public static Branch toDomain(BranchEntity entity) {
        return Branch.builder()
                .id(entity.getId())
                .branchName(entity.getBranchName())
                .visibility(entity.getVisibility())
                .createdUser(AccountConverter.toDomain(entity.getCreatedUser()))
                .testBatches(entity.getTestBatches().stream()
                        .map(TestBatchConverter::toDomain)
                        .collect(Collectors.toList()))
                .build();
    }

    public static BranchEntity toEntity(Branch domain) {
        BranchEntity entity = new BranchEntity();
        entity.setId(domain.getId());
        entity.setBranchName(domain.getBranchName());
        entity.setVisibility(domain.getVisibility());
        entity.setCreatedUser(AccountConverter.toEntity(domain.getCreatedUser()));
        entity.setTestBatches(domain.getTestBatches().stream()
                .map(TestBatchConverter::toEntity)
                .collect(Collectors.toList()));
        return entity;
    }
}
