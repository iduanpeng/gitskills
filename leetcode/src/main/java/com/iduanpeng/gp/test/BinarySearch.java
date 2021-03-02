package com.iduanpeng.gp.test;

public class BinarySearch {

    /**
     * 正常升序 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int pivot, left = 0, right = nums.length - 1;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] == target) {
                return pivot;
            }
            if (target < nums[pivot]){
                right = pivot - 1;
            } else {
                left = pivot + 1;
            }
        }
        return -1;
    }

    /**
     * 旋转数组 找最小 无重复
     */
    public int findMin(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] >= nums[start]){
                if (nums[end] <= nums[mid]){
                    start  = mid;
                } else {
                    end = mid;
                }
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start],nums[end]);
    }

    /**
     * 找峰值元素
     * 1 2 3 1
     * 输出2 index
     * 1213564
     * 1 or 5
     */
    public int findPeekElement(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid-1]){
                end = mid;
            } else if (nums[mid] < nums[mid + 1]){
                start = mid;
            } else {
                return mid;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }





    /**
     * 搜索旋转数组  升序的数组 在多次旋转后 搜索
     * arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5  若有多个相同元素，返回索引值最小的一个
     * 输出 8
     */
    public int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        if (right == -1)
            return -1;
        while (left < right) {                                         // 循环结束条件left==right
            int mid = left + (right - left) / 2;
            if (nums[left] < nums[mid]) {                              // 如果左值小于中值，说明左边区间升序
                if (nums[left] <= target && target <= nums[mid]) {     // 如果目标在左边的升序区间中，右边界移动到mid
                    right = mid;
                } else {                                               // 否则目标在右半边，左边界移动到mid+1
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {                       // 如果左值大于中值，说明左边不是升序，右半边升序
                if (nums[left] <= target || target <= nums[mid]) {     // 如果目标在左边，右边界移动到mid
                    right = mid;
                } else {                                               // 否则目标在右半边，左边界移动到mid+1
                    left = mid + 1;
                }
            } else if (nums[left] == nums[mid]) {                      // 如果左值等于中值，可能是已经找到了目标，也可能是遇到了重复值
                if (nums[left] != target) {                            // 如果左值不等于目标，说明还没找到，需要逐一清理重复值。
                    left++;
                } else {                                               // 如果左值等于目标，说明已经找到最左边的目标值
                    right = left;                                      // 将右边界移动到left，循环结束
                }
            }
        }
        return (nums[left] == target) ? left : -1;                     // 返回left，或者-1
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] num = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 14, 10};
        int[] num2 = new int[]{1,2,1,3,5,6,4};
        int i = binarySearch.search2(num, 10);
        System.out.println(i);


        int peekElement = binarySearch.findPeekElement(num2);
        System.out.println(peekElement);
    }
}
