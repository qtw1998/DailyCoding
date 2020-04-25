package Tree.LintCode;

import java.util.LinkedList;
import java.util.Queue;

// O(n) 宽度优先遍历
public class breadthTraverse {
    public static void main(String[] args) {
        TreeNode root = buildTree();
        //breadthFirstTraverse(root); // 8 3 10 1 6 14 4 7 13
        breadthDepthWiseTraverse(root);
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

        node5.left = node7;
        node5.right = node8;

        node3.right = node6;
        node6.left = node9;

        return node1;
    }

    public static void breadthFirstTraverse(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) queue.offer(cur.left);
            if (cur.right != null) queue.offer(cur.right);
        }
    }

    // by Depth: O(n) 进队列一次，出队列一次
    public static void breadthDepthWiseTraverse(TreeNode root) {
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                System.out.print(cur.val + "  ");
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            System.out.println();
        }
    }

    static class  TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int value) {
            this.val = value;
        }
    }

}