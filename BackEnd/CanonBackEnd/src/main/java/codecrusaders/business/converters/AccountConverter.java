package codecrusaders.business.converters;

import codecrusaders.domain.core.Account;
import codecrusaders.repository.entity.AccountEntity;

public class AccountConverter {
    public static Account toDomain(AccountEntity entity) {
        return Account.builder()
                .id(entity.getId())
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(entity.getRole())
                .build();
    }
    public static AccountEntity toEntity(Account domain) {
        AccountEntity entity =
                AccountEntity.builder()
                        .id(domain.getId())
                        .username(domain.getUsername())
                        .password(domain.getPassword())
                        .role(domain.getRole())
                        .build();
        return entity;
    }
}

