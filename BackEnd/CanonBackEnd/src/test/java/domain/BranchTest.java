package domain;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.nestedstructure.Branch;
import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.domain.nestedstructure.TestSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import java.util.ArrayList;
import java.util.List;

class BranchTest {
    private Branch branch;
    private TestBatch testBatch1;
    private TestBatch testBatch2;

    @BeforeEach
    public void setUp() {
        branch = new Branch();
        testBatch1 = mock(TestBatch.class);
        testBatch2 = mock(TestBatch.class);
    }

    @Test
    public void WhenAllTestBatchesPassed_BranchTestResultPassed() {
        when(testBatch1.getTestResult()).thenReturn(TestResult.PASSED);
        when(testBatch2.getTestResult()).thenReturn(TestResult.PASSED);

        List<TestBatch> testBatches = new ArrayList<>();
        testBatches.add(testBatch1);
        testBatches.add(testBatch2);
        branch.setTestBatches(testBatches);

        branch.setTestResult();

        assertEquals(TestResult.PASSED, branch.getTestResult());
    }

    @Test
    public void WhenAtLEastOneTestBatchFailed_BranchTestResultFailed() {
        when(testBatch1.getTestResult()).thenReturn(TestResult.PASSED);
        when(testBatch2.getTestResult()).thenReturn(TestResult.FAILED);

        List<TestBatch> testBatches = new ArrayList<>();
        testBatches.add(testBatch1);
        testBatches.add(testBatch2);
        branch.setTestBatches(testBatches);

        branch.setTestResult();

        assertEquals(TestResult.FAILED, branch.getTestResult());
    }

    @Test
    public void WhenComponentTypeIsCompatible_CanBeAddedAndRemovedToOrFromTestBatchList() {
        TestBatch testBatch = new TestBatch();
        branch.add(testBatch);
        assertTrue(branch.getTestBatches().contains(testBatch));
        assertEquals(branch, testBatch.getBranch());

        branch.remove(testBatch);
        assertFalse(branch.getTestBatches().contains(testBatch));
    }

    @Test
    public void WhenComponentTypeIsIncompatible_CanNotBeAddedAndRemovedToOrFromTestBatchList() {
        TestSet testSet = new TestSet();

        assertThrows(UnsupportedOperationException.class, () -> branch.add(testSet));
        assertThrows(UnsupportedOperationException.class, () -> branch.remove(testSet));
    }

}