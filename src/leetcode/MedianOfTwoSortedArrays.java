package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    /**
     * nums1과 nums2 합치고, 중간값
     * [1,2,3] -> 2
     * [1,2,3,4] -> 2,3 -> (2+3)/2 = 2.5
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, arr, 0, nums1.length); // n
        System.arraycopy(nums2, 0, arr, nums1.length, nums2.length); // n

        Arrays.sort(arr); // nlogn

        if (arr.length % 2 != 0) { // 홀수, 중간값 하나
            return arr[arr.length / 2];
        }
        return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        if (n1 > n2) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int totalLength = n1 + n2;
        int left = (n1 + n2 + 1) / 2;
        int low = 0;
        int high = n1;

        while (low <= high) {
            int mid1 = (low + high) >> 1; // (low + high) / 2
            int mid2 = left - mid1;

            int l1 = Integer.MIN_VALUE; // nums1의 왼쪽에서 가장 큰 값
            int l2 = Integer.MIN_VALUE; // nums2의 왼쪽에서 가장 큰 값
            int r1 = Integer.MAX_VALUE; // nums1의 오른쪽에서 가장 작은 값
            int r2 = Integer.MAX_VALUE; // nums2의 오른쪽에서 가장 작은 값

            if (mid1 < n1) {
                r1 = nums1[mid1];
            }
            if (mid2 < n2) {
                r2 = nums2[mid2];
            }
            if (mid1 - 1 >= 0) {
                l1 = nums1[mid1 - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = nums2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                if (totalLength % 2 == 1) {
                    return Math.max(l1, l2);
                } else {
                    return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
                }
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    } // 이해못함
}
