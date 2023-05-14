package codecrusaders.business.converters;

import codecrusaders.domain.Account;
import codecrusaders.domain.nestedstructure.Branch;
import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.repository.entity.AccountEntity;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.TestBatchEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BranchConverter {
    public static Branch toDomain(BranchEntity entity) {
        if(entity == null){
            return null;
        }
        List<TestBatch> testBatchList = Optional.ofNullable(entity.getTestBatches())
                .orElse(Collections.emptyList())
                .stream()
                .map(TestBatchConverter::toDomain)
                .collect(Collectors.toList());
        return Branch.builder()
                .id(entity.getId())
                .name(entity.getName())
                .visibility(entity.getVisibility())
                .createdUser(Account.builder()
                        .id(entity.getCreatedUser().getId())
                        .build())
                .testBatches(testBatchList)
                .build();
    }


    public static BranchEntity toEntity(Branch domain) {
        if(domain == null){
            return null;
        }
        List<TestBatchEntity> testBatchEntityList = Optional.ofNullable(domain.getTestBatches())
                .orElse(Collections.emptyList())
                .stream()
                .map(TestBatchConverter::toEntity)
                .collect(Collectors.toList());
        BranchEntity entity = new BranchEntity();
        entity.setId(domain.getId());
        entity.setName(domain.getName());
        entity.setVisibility(domain.getVisibility());
        entity.setCreatedUser(
                AccountEntity.builder()
                        .id(domain.getCreatedUser().getId())
                        .build()
        );
        entity.setTestBatches(testBatchEntityList);
        return entity;
    }
}
