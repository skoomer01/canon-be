package codecrusaders.repository.impl;

import codecrusaders.repository.BranchRepository;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@AllArgsConstructor
public class TemporaryBranchRepo implements BranchRepository {
    private static long NEXT_ID = 1;
    private final List<BranchEntity> savedBranches;
    public TemporaryBranchRepo(){
        this.savedBranches = new ArrayList<>();
    }
    @Override
    public BranchEntity saveBranch(BranchEntity branch) {
        if(branch.getId() == null){
            branch.setId(NEXT_ID);
            NEXT_ID++;
            this.savedBranches.add(branch);
        }
        return branch;
    }

    @Override
    public boolean branchExistByName(String branchName) {
        return this.savedBranches
                .stream()
                .anyMatch(branchEntity -> branchEntity.getBranchName().equals(branchName));
    }

    @Override
    public List<BranchEntity> findAll() {
        return Collections.unmodifiableList(this.savedBranches);
    }
}
