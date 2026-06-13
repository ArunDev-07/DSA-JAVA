/*
===============================================================================
                             SYMMETRIC TREE
===============================================================================

Platform  : LeetCode (101)
Approach  : Recursion / DFS
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the root of a binary tree.

Return true if the tree is symmetric around its center.

Otherwise return false.

A tree is symmetric if the left subtree is a mirror image
of the right subtree.

===============================================================================
EXAMPLE 1
===============================================================================

Input:

            1
          /   \
         2     2
        / \   / \
       3   4 4   3

Output:

true

===============================================================================
EXAMPLE 2
===============================================================================

Input:

            1
          /   \
         2     2
          \     \
           3     3

Output:

false

===============================================================================
CORE IDEA
===============================================================================

To be symmetric:

Left subtree's left child must match
Right subtree's right child.

AND

Left subtree's right child must match
Right subtree's left child.

Mirror Comparison:

left.left  <-> right.right

left.right <-> right.left

===============================================================================
MIRROR RULE
===============================================================================

Two nodes are mirrors if:

1) Both are null
2) Values are equal
3) Outer children are mirrors
4) Inner children are mirrors

===============================================================================
RECURSIVE RELATION
===============================================================================

check(left, right)

=

left.val == right.val

AND

check(left.left, right.right)

AND

check(left.right, right.left)

===============================================================================
BASE CASES
===============================================================================

Case 1

left == null && right == null

Return true

Reason:

Both sides ended together.

-------------------------------------------------------------------------------

Case 2

left == null || right == null

Return false

Reason:

One side exists while the other doesn't.

-------------------------------------------------------------------------------

Case 3

left.val != right.val

Return false

Reason:

Values are different.

===============================================================================
FULL DRY RUN
===============================================================================

Tree:

            1
          /   \
         2     2
        / \   / \
       3   4 4   3

-------------------------------------------------------------------------------

Start:

check(2,2)

Values equal

Check:

check(3,3)

AND

check(4,4)

-------------------------------------------------------------------------------

check(3,3)

Values equal

Check:

check(null,null)

AND

check(null,null)

Returns true

-------------------------------------------------------------------------------

check(4,4)

Values equal

Check:

check(null,null)

AND

check(null,null)

Returns true

-------------------------------------------------------------------------------

Final:

true && true

Return:

true

===============================================================================
RECURSION TREE
===============================================================================

check(2,2)
│
├── check(3,3)
│   ├── check(null,null) → true
│   └── check(null,null) → true
│
└── check(4,4)
    ├── check(null,null) → true
    └── check(null,null) → true

Final Answer:

true

===============================================================================
VISUALIZATION
===============================================================================

            1
          /   \
         2     2
        / \   / \
       3   4 4   3
       ↑       ↑
       Match

       4       4
       ↑       ↑
       Match

Mirror Image

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

Every node is visited once.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(h)

h = Height of Tree

Recursion Stack

Worst Case:

O(n)

For a skewed tree.

===============================================================================
PATTERN LEARNED
===============================================================================

Mirror DFS

Tree Comparison

Used In:

- Symmetric Tree
- Same Tree
- Subtree of Another Tree
- Flip Equivalent Binary Trees

===============================================================================
*/

class Solution {

    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {

        // Both null
        if (left == null && right == null) {
            return true;
        }

        // One null
        if (left == null || right == null) {
            return false;
        }

        // Values differ
        if (left.val != right.val) {
            return false;
        }

        // Mirror comparison
        return check(left.left, right.right)
                && check(left.right, right.left);
    }
}
