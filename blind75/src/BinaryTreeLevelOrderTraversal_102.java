import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_102 {
    private static class TreeNode {
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> levelOrder = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        if(root != null) q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> currList = new ArrayList<>();
            for (int i = 0; i < size; i++){
                TreeNode currElm = q.poll();
                currList.add(currElm.val);

                if(currElm.left != null) q.add(currElm.left);
                if(currElm.right != null) q.add(currElm.right);
            }

            levelOrder.add(currList);
        }

        return levelOrder;
    }

    public static void main(String[] args) {

    }
}
