/*
===============================================================================
                         VALIDATE BINARY SEARCH TREE
===============================================================================

Platform  : LeetCode (98)
Approach  : Inorder Traversal
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the root of a binary tree.

Determine whether it is a valid Binary Search Tree (BST).

A BST must satisfy:

1) Left subtree contains only smaller values.
2) Right subtree contains only greater values.
3) Both subtrees must also be BSTs.

===============================================================================
BST PROPERTY
===============================================================================

For every node:

Left Subtree  < Root

Right Subtree > Root

Example:

                5
              /   \
             3     7
            / \   / \
           2   4 6   8

Valid BST

===============================================================================
CORE IDEA
===============================================================================

Inorder Traversal of a BST produces:

Sorted Ascending Order

Example:

        5
       / \
      3   7

Inorder:

3 5 7

Sorted

===============================================================================
IMPORTANT OBSERVATION
===============================================================================

If at any point:

Current Value <= Previous Value

Then BST Property is violated.

Return false.

===============================================================================
FULL DRY RUN
===============================================================================

Tree:

        2
       / \
      1   3

-------------------------------------------------------------------------------

Inorder Traversal

Visit 1

prev = null

Valid

prev = 1

-------------------------------------------------------------------------------

Visit 2

2 > 1

Valid

prev = 2

-------------------------------------------------------------------------------

Visit 3

3 > 2

Valid

prev = 3

-------------------------------------------------------------------------------

Traversal Finished

Return true

===============================================================================
INVALID EXAMPLE
===============================================================================

        5
       / \
      1   4
         / \
        3   6

Inorder:

1 5 3 4 6

-------------------------------------------------------------------------------

Visit:

1

prev = 1

-------------------------------------------------------------------------------

Visit:

5

prev = 5

-------------------------------------------------------------------------------

Visit:

3

3 <= 5

BST Violated

Return false

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

Every node visited once.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(h)

h = Height of Tree

Recursion Stack

===============================================================================
PATTERN LEARNED
===============================================================================

BST + Inorder Traversal

Used In:

- Validate BST
- Kth Smallest Element
- BST Iterator
- Recover BST

===============================================================================
*/

class Solution {

    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {

        return inOrder(root);
    }

    public boolean inOrder(TreeNode root) {

        if (root == null) {
            return true;
        }

        if (!inOrder(root.left)) {
            return false;
        }

        if (prev != null && root.val <= prev.val) {
            return false;
        }

        prev = root;

        return inOrder(root.right);
    }
}
