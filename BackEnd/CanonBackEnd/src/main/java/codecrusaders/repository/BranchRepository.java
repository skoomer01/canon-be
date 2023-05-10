package codecrusaders.repository;

import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.UserEntity;

import java.util.List;

public interface BranchRepository {
    public BranchEntity saveBranch(BranchEntity branch);
    public boolean branchExistByName(String branchName);
    //ewew
    public List<BranchEntity> findAll();
}
