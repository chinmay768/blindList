public class FindMinimumInRotatedSortedArray_153 {

    // TC: O(logn)    SC: O(1)
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if(nums[mid] <= nums[right]){
                min = Math.min(min, nums[mid]);
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {

    }
}
