package codecrusaders.repository;

import codecrusaders.repository.entity.SubTestEntity;
import java.util.List;

public interface SubTestRepository {
    boolean existsById(long subTestId);
    SubTestEntity save(SubTestEntity subTestEntity);
    public List<SubTestEntity> findAll();
}
