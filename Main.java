import java.lang.Comparable;
import java.util.Arrays;

public class Main<T extends Comparable<T>> {
    T[] data;

    public Main(T[] d) {
        data = d;
    }

    public T[] mergeSort() {
        T[] result = Arrays.copyOf(data, data.length);
        mergeSort(result, 0, data.length - 1);
        return result;
    }

    private void mergeSort(T[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private void merge(T[] array, int start, int mid, int end) {
        T[] temp = Arrays.copyOfRange(array, start, end + 1);

        int i = 0, j = mid - start + 1, k = start;
        while (i <= mid - start && j <= end - start) {
            if (temp[i].compareTo(temp[j]) <= 0) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= mid - start) {
            array[k++] = temp[i++];
        }
    }

    public T[] quickSort() {
        T[] result = Arrays.copyOf(data, data.length);
        quickSort(result, 0, data.length - 1);
        return result;
    }

    private void quickSort(T[] array, int start, int end) {
        if (start < end) {
            int pIndex = partition(array, start, end);
            quickSort(array, start, pIndex - 1);
            quickSort(array, pIndex + 1, end);
        }
    }

    private int partition(T[] array, int start, int end) {
        T pivot = array[end];
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (array[i].compareTo(pivot) <= 0) {
                T temp = array[i];
                array[i] = array[pIndex];
                array[pIndex] = temp;
                pIndex++;
            }
        }
        T temp = array[pIndex];
        array[pIndex] = array[end];
        array[end] = temp;
        return pIndex;
    }
}