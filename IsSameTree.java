/*
===============================================================================
                                SAME TREE
===============================================================================

Platform  : LeetCode (100)
Approach  : Recursion / DFS
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the roots of two binary trees p and q.

Return true if the trees are identical.

Two trees are considered the same if:

1) They have the same structure.
2) Corresponding nodes have the same values.

Otherwise return false.

===============================================================================
EXAMPLE 1
===============================================================================

Tree P:

        1
       / \
      2   3

Tree Q:

        1
       / \
      2   3

Output:

true

===============================================================================
EXAMPLE 2
===============================================================================

Tree P:

        1
       /
      2

Tree Q:

        1
         \
          2

Output:

false

Reason:

Structures are different.

===============================================================================
CORE IDEA - RECURSION
===============================================================================

For every pair of nodes:

1) Both null
      -> Same

2) One null
      -> Different

3) Values different
      -> Different

4) Values same
      -> Check left subtree
      -> Check right subtree

Both subtrees must be identical.

===============================================================================
RECURSIVE RELATION
===============================================================================

SameTree(p, q)

=

(p.val == q.val)

AND

SameTree(p.left, q.left)

AND

SameTree(p.right, q.right)

===============================================================================
BASE CASES
===============================================================================

Case 1:

p == null && q == null

Return true

Reason:

Both trees ended at the same position.

-------------------------------------------------------------------------------

Case 2:

p == null || q == null

Return false

Reason:

One tree has a node while the other doesn't.

-------------------------------------------------------------------------------

Case 3:

p.val != q.val

Return false

Reason:

Node values differ.

===============================================================================
FULL DRY RUN
===============================================================================

Input:

Tree P:

        1
       / \
      2   3

Tree Q:

        1
       / \
      2   3

-------------------------------------------------------------------------------

Call:

isSameTree(1,1)

Values equal

Check:

isSameTree(2,2)

AND

isSameTree(3,3)

-------------------------------------------------------------------------------

Left Side

isSameTree(2,2)

Values equal

Check:

isSameTree(null,null)

AND

isSameTree(null,null)

Both return true

Result:

true

-------------------------------------------------------------------------------

Right Side

isSameTree(3,3)

Values equal

Check:

isSameTree(null,null)

AND

isSameTree(null,null)

Both return true

Result:

true

-------------------------------------------------------------------------------

Final

true && true

Return:

true

===============================================================================
RECURSION TREE
===============================================================================

isSameTree(1,1)
│
├── isSameTree(2,2)
│   ├── isSameTree(null,null) → true
│   └── isSameTree(null,null) → true
│
└── isSameTree(3,3)
    ├── isSameTree(null,null) → true
    └── isSameTree(null,null) → true

Final Answer:

true

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

n = Number of Nodes

Every node is visited once.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(h)

h = Height of Tree

Used by recursion stack.

Worst Case:

O(n)

For a skewed tree.

===============================================================================
PATTERN LEARNED
===============================================================================

Tree DFS

Recursion

Used In:

- Same Tree
- Symmetric Tree
- Subtree of Another Tree
- Balanced Binary Tree
- Path Sum
- Diameter of Binary Tree

===============================================================================
*/

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // One node is null
        if (p == null || q == null) {
            return false;
        }

        // Values are different
        if (p.val != q.val) {
            return false;
        }

        // Check left and right subtrees
        return isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
    }
}
