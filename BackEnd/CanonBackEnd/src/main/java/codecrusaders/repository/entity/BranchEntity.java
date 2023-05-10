package codecrusaders.repository.entity;

import codecrusaders.domain.Enum.Visibility;
import codecrusaders.domain.core.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch")
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="branchName")
    private String branchName;

    @Column(name="visibility")
    @Enumerated(EnumType.STRING)
    private Visibility visibility;

    @ManyToOne
    @JoinColumn(name = "createdUser", referencedColumnName = "id")
    private AccountEntity createdUser;

    @OneToMany(mappedBy = "branch", cascade = CascadeType.ALL)
    private List<TestBatchEntity> testBatches;
}

