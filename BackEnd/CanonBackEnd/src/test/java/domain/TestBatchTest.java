package domain;

import codecrusaders.domain.Enum.TestResult;
import codecrusaders.domain.ITestResultProvider;
import codecrusaders.domain.nestedstructure.INestedComponent;
import codecrusaders.domain.nestedstructure.TestBatch;
import codecrusaders.domain.nestedstructure.TestSet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TestBatchTest {
    private TestBatch testBatch;
    private TestSet testSet1;
    private TestSet testSet2;

    @BeforeEach
    public void setUp() {
        testBatch = new TestBatch();
        testSet1 = mock(TestSet.class);
        testSet2 = mock(TestSet.class);
    }

    @Test
    public void testWhenAllTestSetsPassedTestBatchTestResultPassed() {
        when(testSet1.getTestResult()).thenReturn(TestResult.PASSED);
        when(testSet2.getTestResult()).thenReturn(TestResult.PASSED);

        List<TestSet> testSets = new ArrayList<>();
        testSets.add(testSet1);
        testSets.add(testSet2);
        testBatch.setTestSets(testSets);

        testBatch.setTestResult();

        assertEquals(TestResult.PASSED, testBatch.getTestResult());
    }

    @Test
    public void testWhenAtLeastOneTestSetFailedTestBatchTestResultFailed() {
        when(testSet1.getTestResult()).thenReturn(TestResult.PASSED);
        when(testSet2.getTestResult()).thenReturn(TestResult.FAILED);

        List<TestSet> testSets = new ArrayList<>();
        testSets.add(testSet1);
        testSets.add(testSet2);
        testBatch.setTestSets(testSets);

        testBatch.setTestResult();

        assertEquals(TestResult.FAILED, testBatch.getTestResult());
    }

    @Test
    public void testWhenComponentTypeIsCompatibleCanBeAddedAndRemovedToOrFromTestSetList() {
        TestSet testSet = new TestSet();
        testBatch.add(testSet);
        assertTrue(testBatch.getTestSets().contains(testSet));
        assertEquals(testBatch, testSet.getTestBatch());

        testBatch.remove(testSet);
        assertFalse(testBatch.getTestSets().contains(testSet));
    }

    @Test
    public void testWhenComponentTypeIsIncompatibleCanNotBeAddedAndRemovedToOrFromTestSetList() {
        INestedComponent nestedComponent = mock(INestedComponent.class);

        assertThrows(UnsupportedOperationException.class, () -> testBatch.add(nestedComponent));
        assertThrows(UnsupportedOperationException.class, () -> testBatch.remove(nestedComponent));
    }
}

