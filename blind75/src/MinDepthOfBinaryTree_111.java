import java.util.LinkedList;
import java.util.Queue;

public class MinDepthOfBinaryTree_111 {
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

    private static class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public static int preOrder(TreeNode root, int depth){
        if(root.left == null && root.right == null) return depth;

        int leftDepth = Integer.MAX_VALUE;
        if(root.left != null) leftDepth = preOrder(root.left, depth + 1);
        int rightDepth = Integer.MAX_VALUE;
        if(root.right != null) rightDepth = preOrder(root.right, depth + 1);

        return Math.min(leftDepth, rightDepth);
    }

    //TC: O(n)   SC: O(n)
    public static int minDepthNaive(TreeNode root) {
        if(root == null) return 0;
        return preOrder(root, 1);
    }

    public static int minDepthOptimal(TreeNode root) {
        if(root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 1));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i  = 0; i < size; i++){
                Pair currElm = q.poll();
                TreeNode currNode = currElm.node;
                if(currNode.left == null && currNode.right == null) return currElm.depth;

                if(currNode.left != null) q.offer(new Pair(currNode.left, currElm.depth + 1));

                if(currNode.right != null) q.offer(new Pair(currNode.right, currElm.depth + 1));
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
