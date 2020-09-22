package scene.LeetCode.rotateArrayRelated;

/**
 * @Author: Gpw
 * @Date: 2020/7/17
 * @Description: leetcode 33 搜索旋转排序数组
 */
public class searchRotateSortedArray {

    public static int search(int[] nums, int target) {
        int l = 0,r = nums.length-1,mid = 0;
        while(l <= r){
            mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            // 看[l,mid]和[mid+1,r]哪一个是有序的
            if(nums[mid] >= nums[l]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                }
                else {
                    l = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[r]) {
                    l = mid + 1;
                }
                else {
                    r= mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0));
    }
}
