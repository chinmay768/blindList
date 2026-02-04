public class ValidBST_98 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean isValidBST(TreeNode root, Long minRange, Long maxRange) {
        if(root == null) return true;

        if(root.val < minRange || root.val > maxRange) return false;

        return isValidBST(root.left, minRange, (long) (root.val - 1)) &&
                isValidBST(root.right, (long) (root.val + 1), maxRange);
    }

    public static void main(String[] args) {

    }
}
