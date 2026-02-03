public class SubtreeOfAnotherTree_572 {

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

    public static boolean isSameTree(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null) {
            return root1 == root2;
        }

        if(root1.val != root2.val) return false;

        boolean isLeftSame = isSameTree(root1.left, root2.left);
        boolean isRightSame = isSameTree(root1.right, root2.right);

        return isLeftSame && isRightSame;
    }

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) return false;

        // This will fail to work as this will directly return false without exploring left and right subtree
//        if(root.val == subRoot.val) {
//            return  isSameTree(root, subRoot);
//        }

        if(isSameTree(root, subRoot)) return true;

//        if(isSubtree(root.left, subRoot)) return true;
//
//        if(isSubtree(root.right, subRoot)) return true;
//
//        return false;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);

        TreeNode subroot = new TreeNode(1);

        System.out.println(isSubtree(root, subroot));
    }
}
