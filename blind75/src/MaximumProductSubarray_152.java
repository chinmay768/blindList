public class MaximumProductSubarray_152 {
    public int maxProduct(int[] nums) {
        int preProduct = 1;
        int postProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++){
            if(preProduct == 0) preProduct = 1;

            if(postProduct == 0) postProduct = 1;

            // Keep it below if conditions so as to update maxProduct in case of 0 and all -ve ([-2,0,-1])
            preProduct = preProduct * nums[i];
            postProduct = postProduct * nums[nums.length - 1 - i];

            maxProduct = Math.max(maxProduct, Math.max(preProduct, postProduct));
        }

        return maxProduct;
    }


    public static void main(String[] args) {

    }
}
