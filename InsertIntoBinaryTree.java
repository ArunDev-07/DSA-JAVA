# /*

```
                     INSERT INTO BINARY SEARCH TREE
```

===============================================================================

Platform  : LeetCode 701
Approach  : Iterative BST Traversal
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given the root of a Binary Search Tree (BST) and a value to insert,
insert the value into the BST and return the root.

The inserted value must follow BST rules:

```
Left Subtree  < Root
Right Subtree > Root
```

===============================================================================
CORE IDEA
=========

Traverse the BST until we find an empty position (null).

If:

```
val < curr.val
```

Go Left

Else

Go Right

When a null child is found:

```
Create a new node and attach it.
```

===============================================================================
BST PROPERTY
============

Example:

```
      4
     / \
    2   7
```

Insert = 5

5 > 4  → Go Right

```
      4
     / \
    2   7
```

5 < 7  → Go Left

```
      4
     / \
    2   7
       /
      5
```

===============================================================================
TIME COMPLEXITY
===============

Average Case:

```
O(log n)
```

Worst Case (Skewed Tree):

```
O(n)
```

===============================================================================
SPACE COMPLEXITY
================

Iterative Solution:

```
O(1)
```

No recursion stack used.

===============================================================================
FULL DRY RUN
============

Input Tree:

```
      4
     / \
    2   7
```

Insert:

```
val = 5
```

---

curr = 4

5 < 4 ?

No

Go Right

curr = 7

---

curr = 7

5 < 7 ?

Yes

Check:

curr.left == null

Yes

Create Node(5)

curr.left = new TreeNode(5)

Tree becomes:

```
      4
     / \
    2   7
       /
      5
```

Break Loop

Return root

===============================================================================
PATTERN LEARNED
===============

Binary Search Tree Traversal

Used In:

* Search BST
* Insert BST
* Delete BST
* Lowest Common Ancestor in BST
* Validate BST
* Kth Smallest Element in BST

===============================================================================
JAVA SOLUTION
=============

*/

class Solution {

```
public TreeNode insertIntoBST(TreeNode root, int val) {

    // Empty Tree
    if (root == null) {
        return new TreeNode(val);
    }

    TreeNode curr = root;

    while (true) {

        // Go Left
        if (val < curr.val) {

            if (curr.left == null) {
                curr.left = new TreeNode(val);
                break;
            }

            curr = curr.left;
        }

        // Go Right
        else {

            if (curr.right == null) {
                curr.right = new TreeNode(val);
                break;
            }

            curr = curr.right;
        }
    }

    return root;
}
```

}
