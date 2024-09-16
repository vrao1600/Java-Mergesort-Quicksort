import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MainTest {
    private Main<Integer> intData1, intData2;
    private Main<Double> doubleData1, doubleData2;

    @BeforeEach
    public void setUp() {
        intData1 = new Main<>(new Integer[] { 1, 6, 8, 3, 7, 4, 2, 9, 5 });
        intData2 = new Main<>(new Integer[] { 2, 4, 3, 1, 5 });
        doubleData1 = new Main<>(new Double[] { 1.2, 6.7, 8.3, 3.5, 7.4, 4.9, 2.1, 9.6, 5.8 });
        doubleData2 = new Main<>(new Double[] { 2.4, 4.3, 3.5, 1.1, 5.5 });
    }

    @Test
    public void testMergeSort() {
        testHelperMergeSort(intData1);
        testHelperMergeSort(intData2);
        testHelperMergeSort(doubleData1);
        testHelperMergeSort(doubleData2);
    }

    private <T extends Comparable<T>> void testHelperMergeSort(Main<T> data) {
        T[] expected = Arrays.copyOf(data.data, data.data.length);
        Arrays.sort(expected);
        assertArrayEquals(expected, data.mergeSort(), "MergeSort did not sort correctly");
    }

    @Test
    public void testQuickSort() {
        testHelperQuickSort(intData1);
        testHelperQuickSort(intData2);
        testHelperQuickSort(doubleData1);
        testHelperQuickSort(doubleData2);
    }

    private <T extends Comparable<T>> void testHelperQuickSort(Main<T> data) {
        T[] expected = Arrays.copyOf(data.data, data.data.length);
        Arrays.sort(expected);
        assertArrayEquals(expected, data.quickSort(), "QuickSort did not sort correctly");
    }
}
