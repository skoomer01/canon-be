package codecrusaders.domain;

import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetLatestTestSetsResponse {
    private List<TestSet> latestTestSets;
}
