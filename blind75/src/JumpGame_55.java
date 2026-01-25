import static java.lang.Math.max;

public class JumpGame_55 {

    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        int currIdx = 0;

        while (currIdx < nums.length && currIdx <= maxIdx){
            maxIdx =  Math.max(currIdx + nums[currIdx], maxIdx);

            currIdx++;
        }

        if(maxIdx >= nums.length - 1) return true;

        return false;
    }

    public static void main(String[] args) {

    }
}
