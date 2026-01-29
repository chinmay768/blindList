import java.util.*;

public class ThreeSum_15 {
    private class Triplet {

        private final Integer first;
        private final Integer second;
        private final Integer third;

        public Triplet(Integer first, Integer second, Integer third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public Integer getFirst() { return first; }
        public Integer getSecond() { return second; }
        public Integer getThird() { return third; }

        public List<Integer> getList() { return Arrays.asList(first, second, third);}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triplet triplet)) return false;
            return Objects.equals(first, triplet.first) &&
                    Objects.equals(second, triplet.second) &&
                    Objects.equals(third, triplet.third);
        }


        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Set<Integer> currSet = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int third = -(nums[i] + nums[j]);

                if(currSet.contains(third)){
                    List<Integer> temp =  Arrays.asList(nums[i], nums[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }else {
                    currSet.add(nums[j]);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {

    }
}

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.


Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */