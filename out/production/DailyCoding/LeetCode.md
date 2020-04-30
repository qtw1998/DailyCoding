####   Binary Tree Level Order Traversal

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

## Sort

### Simple

> Time: O(n^2)
>
>  Zone: O(1)

#### Selection sort

```java
public static void insertionSort(int[] arrayList) {
        for(int j = 1; j < arrayList.length; ++j) {
            int pivot = arrayList[j];
            int i = j - 1;
            while(i >= 0 && pivot < arrayList[i]) {
                arrayList[i + 1] = arrayList[i--];
            }
            arrayList[i + 1] = pivot;
        }
    }
```

#### Insertion sort

```java
public static void selectionSort(int[] arrayList) {
        for(int i = 0; i < arrayList.length; ++i) {
            for(int j = i + 1; j < arrayList.length; ++j) {
                if(arrayList[j] < arrayList[i]) {
                    swap(arrayList, i, j);
                }
            }
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
```

#### Bubble sort

```java

```



### Merge Sort

#### Merge Two Sorted Arrays

Merge Time & Zone Complexity: O(n)

 ```java
public class Solution {
    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    // https://www.lintcode.com/problem/merge-two-sorted-arrays
    public int[] mergeSortedArray(int[] A, int[] B) {
        if(A == null) return A;
        if(B == null) return B;
        
        int lenA = A.length, lenB = B.length;
        int lenNew = lenA + lenB;
        int[] res = new int[lenNew];
        // two pointer
        int i = 0, j = 0;
        
        for(int k = 0; k < lenNew; k++) {
            if(i < lenA && (j >= lenB || A[i] <= B[j])) {
                res[k] = A[i++];
            } else{
                res[k] = B[j++];
            }
        }
        return res;
    }
}
 ```

#### Merge Sort

- Time complexity: O(nlogn)
- Zone Complexity: O(n)
    - Stack: O(logn) -> layer number
    - Pile: O(nlogn) -> O(n)

```java
package sort;
// https://site-pictures.oss-eu-west-1.aliyuncs.com/e7hyt.png
// MergeSort
// Time complexity: O(nlogn)
// Zone Complexity: O(n)
// Stack: O(logn) -> layer number
// Pile: O(nlogn) -> O(n)
public class SortAlgos {
    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 9, 2, 1};
        mergeSort(array);
        for(int k = 0; k < array.length; ++k) {
            System.out.print(array[k] + " ");
        }
    }
    private static void mergeSort(int[] array) {
        int[] tmp = new int[array.length];
        mergeSortHelper(array, 0, array.length - 1, tmp);
    }

    private static void mergeSortHelper(int[] array, int left, int right, int[] tmp) {
        if(left >= right) return;
        int mid = left + (right - left) / 2; // take precautious of overflow
        mergeSortHelper(array, left, mid, tmp);
        mergeSortHelper(array, mid + 1, right, tmp);
        merge(array, left, right, tmp);
    }
    private static void merge(int[] array, int left, int right, int[] tmp) {
        int n = right - left + 1;
        int mid = left + (right - left) / 2;
        // int[] tmp = new int[n];
        int i = left, j = mid + 1;
        for(int k = 0; k < n; ++k) {
            if(i <= mid && (j > right || array[i] <= array[j])) {
                tmp[k] = array[i++];
            } else {
                tmp[k] = array[j++];
            }
        }
        for(int k = 0; k < n; k++) { // m 
            array[left + k] = tmp[k];
        }
    }
}

```

### Quick Sort

Thinking: 

- split into two sides: left <= right part (not must be equal)
- Recursive: sort left and right parts
- First integreted, then local part 

Complexity:

- Time Complexity: **O(nlogn)** worst->O(n^2)
- Zone Complexity: average(**O(logn)**) worst(O(n)) no new arries built

> **Steps：**
>
> 1. pick the pivot 
> 2. partition 
> 3. recurse

```java
package sort;
// https://site-pictures.oss-eu-west-1.aliyuncs.com/e7hyt.png
// MergeSort
// Time complexity: O(nlogn)
// Zone Complexity: O(n)
// Stack: O(logn) -> layer number
// Pile: O(nlogn) -> O(n)
public class SortAlgos {
    public static void main(String[] args) {
        int[] array = new int[] {5, 4, 9, 2, 1};
        quickSort(array);
        for(int k = 0; k < array.length; ++k) {
            System.out.print(array[k] + " ");
        }
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
    private static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);
    }
    private static void quickSortHelper(int[] array, int left, int right) {
        if(left >= right) return;
        int i = left, j = right;
        int pivot = array[left + (right - left) / 2];

        while(i <= j) {
            while(i <= j && array[i] < pivot) {
                ++i;
            }
            while(i <= j && array[j] > pivot) {
                --j;
            }
            if(i <= j) {
                swap(array, i++, j--);
            }
        }
        quickSortHelper(array, left, j);
        quickSortHelper(array, i, right);
    }
}

```

🥗 More Details

1. How to pick the **pivot**? 

    - From 1st position && in order: [1, 2, 3, 4, 5]   --- O(n^2)    (n + 1)n / 2
    - random from the array 

    <img src="https://site-pictures.oss-eu-west-1.aliyuncs.com/k3hn6.png" style="zoom:33%;" />

2. How to define the **boundary** in subproblems?

    - definitely **[left, j] [i, right]** 
    - leave alone: **pivot**
    - different methods different boundaries

    <img src="https://site-pictures.oss-eu-west-1.aliyuncs.com/1x2lt.png" style="zoom:33%;" />

3. Why `while(i <= j && array[i] < pivot) `  not `array[i] <= pivot`?

    - subproblems size < origin problems
    - make the subproblems size equal -> decrease the time complexity

    <img src="https://site-pictures.oss-eu-west-1.aliyuncs.com/1b2yy.png" style="zoom:33%;" />

#### Sort in Java

- Arrays.sort

- Collections.sort [list: interface] -> ArrayList LinkedList

- Self-define method

    ```java
    Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2
        }
    }
    ```

    
