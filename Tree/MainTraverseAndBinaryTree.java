package Tree;

// 可以有多个后继，但只能有一个前驱 https://site-pictures.oss-eu-west-1.aliyuncs.com/cqe4g.png
// recursive is one method of implementation of algorithm
public class MainTraverseAndBinaryTree {
    public static void main(String[] args) {
        TreeNode root = buildTree();
        // traverse(root);
        inorderTraverse(root);
    }
    public static TreeNode buildTree() {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(14);
        TreeNode node7 = new TreeNode(4);
        TreeNode node8 = new TreeNode(7);
        TreeNode node9 = new TreeNode(13);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.right = node6;
        
        node5.left = node7;
        node5.right = node8;

        node6.left = node9;

        return node1;
    }
    // traverse: 
    /* DEFINATION: F(n) = F(n - 1) + F(n - 2)
     * EXIT: n = 0 || n = 1 small enough
     * DETACHMENT: fibonacci(n - 1) + fibonacci(n - 2)
     */

    public static void traverse(TreeNode root) { // preorderTraverse
        if(root == null) return;

        System.out.print(root.val + " ");
        traverse(root.left);
        traverse(root.right);
    }
    public static void inorderTraverse(TreeNode root) {
        if(root == null) return;
        inorderTraverse(root.left);
        System.out.print(root.val + " ");
        inorderTraverse(root.right);
    }
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }
    }
}