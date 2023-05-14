package codecrusaders.business;

import codecrusaders.domain.Account;

public interface IAccountService {
    Account addAccount(Account account);
    Account getAccountByUsername(String username);
}
