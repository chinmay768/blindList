import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree_297 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr == null){
                sb.append("# ");
            }

            sb.append(curr.val + " ");

            q.offer(curr.left);
            q.offer(curr.right);
        }

        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == "") return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);

        for(int i = 1; i < values.length; i++){
            TreeNode currNode = queue.poll();

            if(!values[i].equals("#")){
                currNode.left = new TreeNode(Integer.parseInt(values[i]));
                queue.add(currNode.left);
            }

            i++;
            if(!values[i].equals("#")){
                currNode.right = new TreeNode(Integer.parseInt(values[i]));
                queue.add(currNode.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {

    }
}
