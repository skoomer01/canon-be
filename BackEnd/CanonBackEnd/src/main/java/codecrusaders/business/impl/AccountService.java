package codecrusaders.business.impl;

import codecrusaders.business.IAccountService;
import codecrusaders.business.converters.AccountConverter;
import codecrusaders.domain.core.Account;
import codecrusaders.repository.IAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {
    @Autowired
    private IAccountRepository repository;
    @Override
    public Account addAccount(Account account){
        return AccountConverter.toDomain(repository.save(AccountConverter.toEntity(account)));
    }
}
