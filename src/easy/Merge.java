package easy;

import util.PrintUtil;

public class Merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums1, 0, nums1, n, m);
        int index1 = n;
        int index2 = 0;
        int insertIndex = 0;
        while (insertIndex < m + n) {
            int element;
            if (index1 >= n + m) {
                element = nums2[index2];
                index2++;
            } else if (index2 >= n) {
                element = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2 ]) {
                element = nums1[index1];
                index1++;
            } else {
                element = nums2[index2];
                index2++;
            }
            nums1[insertIndex] = element;
            insertIndex++;
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        new Merge().merge(nums1, 3, nums2, 3);
        PrintUtil.printArr(nums1);
    }
}
