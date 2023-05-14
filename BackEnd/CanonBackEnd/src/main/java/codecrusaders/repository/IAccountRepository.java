package codecrusaders.repository;

import codecrusaders.repository.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findByUsername(String username);
}
