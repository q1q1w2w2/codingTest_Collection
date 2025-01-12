package test;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        int n = 7;

        int index = find(arr, n);
        System.out.println("index = " + index);
    }

    /**
     * arr에서 n의 인덱스 반환
     */
    public static int find(int[] arr, int n) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
