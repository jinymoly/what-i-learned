package algorithms;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = { 5, 2, 7, 1, 8, 4, 6 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println("정렬된 배열은 : ");
        for (int num : arr) {
            System.out.println(num);
        }
    }

    /**
     * 분할된 배열을 정렬
     * @param arr
     * @param low
     * @param high
     */
    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    /**
     * pivot을 기준으로 배열을 분할
     * @param arr
     * @param low
     * @param high
     * @return
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}