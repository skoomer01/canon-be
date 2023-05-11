package codecrusaders.business.impl;

import codecrusaders.business.IBranchService;
import codecrusaders.business.converters.BranchConverter;
import codecrusaders.domain.core.Branch;
import codecrusaders.repository.IBranchRepository;
import codecrusaders.repository.entity.BranchEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BranchService implements IBranchService {

    @Autowired
    private IBranchRepository repository;

    @Override
    public Branch createBranch(Branch branch){
        return BranchConverter.toDomain(repository.save(BranchConverter.toEntity(branch)));
    }
    @Override
    public List<Branch> getBranchesWithErrorId(Long errorID) {
        List<Branch> branches = repository.findBranchesByErrorID(errorID).stream()
                .map(BranchConverter::toDomain)
                .collect(Collectors.toList());
        branches.forEach(branch -> branch.setTestResult());
        return branches;
    }
    @Override
    public List<Branch> getBranchesByCommit(String commitShal){
        List<Branch> branches = repository.findBranchesByCommit(commitShal).stream()
                .map(BranchConverter::toDomain)
                .collect(Collectors.toList());
        branches.forEach(branch -> branch.setTestResult());
        return branches;
    }
    @Override
    public List<Branch> getBranchesByVersion(String version){
        List<Branch> branches = repository.findBranchesByVersion(version).stream()
                .map(BranchConverter::toDomain)
                .collect(Collectors.toList());
        branches.forEach(branch -> branch.setTestResult());
        return branches;
    }
    @Override
    public Branch getBranchById(Long id){
        return null;
    }
    @Override
    public List<Branch> getBranches(){
        List<Branch> branches = repository.findAll().stream()
                .map(BranchConverter::toDomain)
                .collect(Collectors.toList());
        branches.forEach(branch -> branch.setTestResult());
        return branches;
    }
}
