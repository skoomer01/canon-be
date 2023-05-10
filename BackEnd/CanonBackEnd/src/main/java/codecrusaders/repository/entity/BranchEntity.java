package codecrusaders.repository.entity;

import codecrusaders.domain.TestBatch;
import codecrusaders.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "branches")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BranchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branchid")
    private Long branchid;
    @Column(name = "branchname")
    private String branchName;
    @Column(name = "ispublic")
    private boolean isPublic;
}
