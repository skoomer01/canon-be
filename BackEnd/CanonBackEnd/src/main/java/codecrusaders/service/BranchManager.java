package codecrusaders.service;

import codecrusaders.domain.Branch;
import codecrusaders.domain.User;

public interface BranchManager {
    public Branch registerBranch(User user, String name);
}
