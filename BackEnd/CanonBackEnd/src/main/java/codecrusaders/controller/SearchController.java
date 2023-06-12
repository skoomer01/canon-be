package codecrusaders.controller;

import codecrusaders.business.ISearchManager;
import codecrusaders.domain.SearchResult;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.PATCH})
public class SearchController {

    @Autowired
    private final ISearchManager manager;

    @GetMapping("/public/error/{errorId}")
    public ResponseEntity<List<SearchResult>> getByErrorIdFromPublic(
            @PathVariable Long errorId,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNumber) {
        List<SearchResult> searchResults = manager.getByErrorIdFromPublic(errorId, pageSize, pageNumber);
        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/public/error/{errorId}/count")
    public ResponseEntity<Integer> countPagesForErrorIdFromPublic(
            @PathVariable Long errorId,
            @RequestParam(defaultValue = "10") int pageSize) {
        int totalPages = manager.countPagesForErrorIdFromPublic(errorId, pageSize);
        return ResponseEntity.ok(totalPages);
    }

    @GetMapping("/public/version/{version}")
    public ResponseEntity<List<SearchResult>> getByVersionFromPublic(
            @PathVariable String version,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNumber) {
        List<SearchResult> searchResults = manager.getByVersionFromPublic(version, pageSize, pageNumber);
        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/public/version/{version}/count")
    public ResponseEntity<Integer> countPagesForVersionFromPublic(
            @PathVariable String version,
            @RequestParam(defaultValue = "10") int pageSize) {
        int totalPages = manager.countPagesForVersionFromPublic(version, pageSize);
        return ResponseEntity.ok(totalPages);
    }
    @GetMapping("/public/commit/{commit}")
    public ResponseEntity<List<SearchResult>> getByCommitFromPublic(
            @PathVariable String commit,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "1") int pageNumber) {
        List<SearchResult> searchResults = manager.getByCommitFromPublic(commit, pageSize, pageNumber);
        return ResponseEntity.ok(searchResults);
    }

    @GetMapping("/public/commit/{commit}/count")
    public ResponseEntity<Integer> countPagesForCommitFromPublic(
            @PathVariable String commit,
            @RequestParam(defaultValue = "10") int pageSize) {
        int totalPages = manager.countPagesForCommitFromPublic(commit, pageSize);
        return ResponseEntity.ok(totalPages);
    }
}
