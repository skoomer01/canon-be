package codecrusaders.repository.entity;

import codecrusaders.domain.Enum.Visibility;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.ORDINAL)
    private Visibility visibility;

    @OneToMany(mappedBy = "branch", cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<TestBatchEntity> testBatches;

    @ManyToOne(fetch = FetchType.EAGER)
    private AccountEntity createdUser;
}
