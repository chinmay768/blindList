public class TrappingRainWater_42 {

    public static int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int totalCapacity = 0;

        int lMax = 0;
        int rMax = 0;

        while (l < r){
            int currCapacity = 0;
            if(height[l] < height[r]){
                currCapacity = lMax - height[l];
                lMax = Math.max(lMax, height[l]);
                l++;
            }else if(height[l] > height[r]){
                currCapacity = rMax - height[r];
                rMax = Math.max(rMax, height[r]);
                r--;
            }else {
                lMax = Math.max(lMax, height[l]);
                l++;
            }
            totalCapacity += Math.max(currCapacity, 0);
        }

        return totalCapacity;
    }

    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(arr));
    }
}
