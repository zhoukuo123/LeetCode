package 字符串;

import 二叉树.TreeNode;

/**
 * @author CoderZk
 */
public class _572_另一棵树的子树 {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) {
            return false;
        }

        return postSerialize(root).contains(postSerialize(subRoot));
    }

    /**
     * 利用后序遍历的方式进行序列化
     *
     * @param root 树的根节点
     * @return
     */
    private String postSerialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        postSerialize(root, sb);
        return sb.toString();
    }

    private void postSerialize(TreeNode node, StringBuilder sb) {
        if (node.left == null) {
            sb.append("#!");
        } else {
            postSerialize(node.left, sb);
        }
        if (node.right == null) {
            sb.append("#!");
        } else {
            postSerialize(node.right, sb);
        }

        sb.append(node.val).append("!");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

    }
}
