#### Binary Tree Level Order Traversal

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur =  queue.poll();
                list.add(cur.val);
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(list);
        }
        return res;
    }
}
```

#### Convert Binary Tree to Linked Lists by DepthFollow

```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            ListNode dummy = new ListNode(-1);
            ListNode tmp = dummy;
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                tmp.next = new ListNode(cur.val);
                tmp = tmp.next;
                if(cur.left != null) queue.offer(cur.left);
                if(cur.right != null) queue.offer(cur.right);
            }
            res.add(dummy.next);
        }
        return res;
    }
}
```

## Divide and Conquer

> Core Idea: just resolve the root, think others later...

### Identical Binary Tree

-  root
- left child tree
- right child tree

```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// https://www.lintcode.com/problem/same-tree/description
public class Solution {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical( TreeNode a, TreeNode b) {
        // write your code here
        if(a == null && b == null) {
            return true;
        }else if (a == null || b == null) {
            return false;
        }
        
        if(a.val != b.val) {
            return false;
        }
        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}
```

#### Balanced Binary Tree

```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// https://www.lintcode.com/problem/balanced-binary-tree/description
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null) return true;
        if(!isBalanced(root.left)) return false;
        if(!isBalanced(root.right)) return false;
        
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1;
    }
    public int getHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
```

#### Validate Binary Search Tree

- left - BST
- right - BST
- Max(left) < Max(root) < Max(right)

```java
/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
// https://www.lintcode.com/problem/validate-binary-search-tree
public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    // root tree isValidBST & minVal <= root.val <= maxVal
    private boolean helper(TreeNode root, long minVal, long maxVal) {
        if(root == null) return true;
        if(root.val <= minVal || root.val >= maxVal) return false;
        
        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
}
```

