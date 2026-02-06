import java.util.LinkedList;
import java.util.Queue;

public class PathSum_112 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private class Pair {
        TreeNode node;
        int sum;

        Pair(TreeNode node, int sum){
            this.node = node;
            this.sum = sum;
        }
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, root.val));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int sum = curr.sum;

            if(sum == targetSum && curr.node.left == null && curr.node.right == null) return true;

            if(curr.node.left != null) q.offer(new Pair(curr.node.left, sum + curr.node.left.val));

            if(curr.node.right != null) q.offer(new Pair(curr.node.right, sum + curr.node.right.val));
        }

        return false;
    }

    public static void main(String[] args) {

    }
}

/*
Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.

A leaf is a node with no children.



Example 1:


Input: root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
Output: true
Explanation: The root-to-leaf path with the target sum is shown.
Example 2:


Input: root = [1,2,3], targetSum = 5
Output: false
Explanation: There are two root-to-leaf paths in the tree:
(1 --> 2): The sum is 3.
(1 --> 3): The sum is 4.
There is no root-to-leaf path with sum = 5.
Example 3:

Input: root = [], targetSum = 0
Output: false
Explanation: Since the tree is empty, there are no root-to-leaf paths.


Constraints:

The number of nodes in the tree is in the range [0, 5000].
-1000 <= Node.val <= 1000
-1000 <= targetSum <= 1000
 */