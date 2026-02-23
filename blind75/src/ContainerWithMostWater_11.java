public class ContainerWithMostWater_11 {

    //TC: O(n^2)  SC: O(1)
    public static int maxAreaNaive(int[] height) {
        int max = 0;

        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++) {
                int currMin = Math.min(height[i], height[j]);


                int capacity = (j - i) * currMin;
                max = Math.max(max, capacity);
            }
        }

        return max;
    }

    // TC: O(2n)   SC: O(1)
    public static int maxAreaBetter(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxCapacity = 0;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            int capacity = (right - left) * min;

            maxCapacity = Math.max(maxCapacity, capacity);

            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }

        return maxCapacity;
    }

    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};

        System.out.println(maxAreaBetter(arr));
    }

}

/*
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.



Example 1:


Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
Example 2:

Input: height = [1,1]
Output: 1


Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104
 */
