package codecrusaders.business.impl;

import codecrusaders.business.IBranchManager;
import codecrusaders.business.exception.BranchAlreadyExistsException;
import codecrusaders.business.impl.converters.BranchConverter;
import codecrusaders.business.impl.converters.TestBatchConverter;
import codecrusaders.business.impl.converters.UserConverter;
import codecrusaders.domain.Branch;
import codecrusaders.domain.GetAllTestBatchesFromABranchRequest;
import codecrusaders.domain.GetAllTestBatchesFromABranchResponse;
import codecrusaders.domain.Http.*;
import codecrusaders.domain.TestBatch;
import codecrusaders.repository.BranchRepository;
import codecrusaders.repository.TestBatchRepository;
import codecrusaders.repository.entity.BranchEntity;
import codecrusaders.repository.entity.TestBatchEntity;
import codecrusaders.repository.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BranchManager implements IBranchManager {
    private final BranchRepository branchRepository;
    private final TestBatchRepository testBatchRepository;

    @Override
    public RegisterBranchResponse registerBranch(RegisterBranchRequest request) {

//        if(branchRepository.findByName(request.getBranchName())){
//            throw new BranchAlreadyExistsException();
//        }
        UserConverter userConverter = new UserConverter();
        BranchEntity branchEntity = saveBranch(request);
        return RegisterBranchResponse.builder()
                .id(branchEntity.getId())
                //.user(UserConverter.convert(branchEntity.getUser()))
                .build();
    }

    public BranchEntity saveBranch(RegisterBranchRequest branch){

        BranchEntity temp = BranchEntity.builder()
                .branchName(branch.getBranchName())
                .build();
        return branchRepository.save(temp);


    }

    public GetAllBranchesResponse getAllBranches(){
        List<BranchEntity> results = branchRepository.findAll();

        List<Branch> branches = results
                .stream()
                .map(BranchConverter::convert)
                .toList();

        return GetAllBranchesResponse.builder()
                .branchList(branches)
                .build();
    }

    @Override
    public GetAllTestBatchesFromABranchResponse getAllTestBatchesFromABranch(GetAllTestBatchesFromABranchRequest request) {
        List<TestBatchEntity> testBatchesEntityList = testBatchRepository.getAllTestBatchesByBranchEntityId(request.getBranchId());

        List<TestBatch> testBatchesList = testBatchesEntityList
                .stream()
                .map(TestBatchConverter::convert)
                .toList();

        return GetAllTestBatchesFromABranchResponse.builder()
                .testBatchList(testBatchesList)
                .build();
    }
}
