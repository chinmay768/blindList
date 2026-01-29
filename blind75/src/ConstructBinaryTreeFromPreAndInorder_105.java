import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreAndInorder_105 {

     public class TreeNode {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inIdxMap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            inIdxMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inIdxMap);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> nodeIdxMap) {
         // Base Condition
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]);
        int inorderRootIdx = nodeIdxMap.get(preorder[preStart]);
        int elmsToLeft = inorderRootIdx - inStart;

        root.left = buildTree(preorder, inorder, preStart + 1, preStart + elmsToLeft, inStart, inorderRootIdx - 1, nodeIdxMap);

        root.right = buildTree(preorder, inorder, preStart + elmsToLeft + 1, preEnd, inorderRootIdx + 1, inEnd, nodeIdxMap);

        return root;
    }

    public static void main(String[] args) {

    }
}
