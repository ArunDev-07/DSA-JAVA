/*
===============================================================================
                        SUBTREE OF ANOTHER TREE
===============================================================================

Platform  : LeetCode (572)
Approach  : DFS + Tree Comparison
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the roots of two binary trees:

root     -> Main Tree
subRoot  -> Candidate Subtree

Return true if subRoot is a subtree of root.

A subtree consists of a node in root and all of its descendants.

===============================================================================
EXAMPLE 1
===============================================================================

root:

            3
           / \
          4   5
         / \
        1   2

subRoot:

          4
         / \
        1   2

Output:

true

===============================================================================
EXAMPLE 2
===============================================================================

root:

            3
           / \
          4   5
         / \
        1   2
           /
          0

subRoot:

          4
         / \
        1   2

Output:

false

Reason:

The structures are different.

===============================================================================
CORE IDEA
===============================================================================

At every node in root:

Check:

Is this subtree identical to subRoot?

If yes:

Return true.

Otherwise:

Search in left subtree
OR
Search in right subtree.

===============================================================================
ALGORITHM
===============================================================================

For every node:

1) Compare current tree with subRoot.

2) If same:
      Return true

3) Otherwise:
      Search left subtree
      Search right subtree

===============================================================================
HELPER FUNCTION
===============================================================================

isSame(root, sub)

Checks whether two trees are identical.

Conditions:

1) Both null -> true

2) One null -> false

3) Values different -> false

4) Check left and right recursively

===============================================================================
FULL DRY RUN
===============================================================================

root:

            3
           / \
          4   5
         / \
        1   2

subRoot:

          4
         / \
        1   2

-------------------------------------------------------------------------------

isSubtree(3, subRoot)

Check:

isSame(3,4)

3 != 4

false

-------------------------------------------------------------------------------

Search Left

isSubtree(4, subRoot)

Check:

isSame(4,4)

Values Match

-------------------------------------------------------------------------------

Compare Left

isSame(1,1)

true

-------------------------------------------------------------------------------

Compare Right

isSame(2,2)

true

-------------------------------------------------------------------------------

Both sides true

Return true

-------------------------------------------------------------------------------

Final Answer:

true

===============================================================================
RECURSION TREE
===============================================================================

isSubtree(3, sub)
│
├── isSame(3,4)
│       false
│
├── isSubtree(4,sub)
│       │
│       └── isSame(4,4)
│              │
│              ├── isSame(1,1)
│              │
│              └── isSame(2,2)
│
│       true
│
└── Stop

===============================================================================
VISUALIZATION
===============================================================================

Main Tree

            3
           / \
          4   5
         / \
        1   2

          ↑

Possible Matching Root

-------------------------------------------------------------------------------

SubTree

          4
         / \
        1   2

Match Found

===============================================================================
TIME COMPLEXITY
===============================================================================

Worst Case:

O(n * m)

n = Nodes in root

m = Nodes in subRoot

Reason:

For every node in root,
we may compare an entire subtree.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(h)

h = Height of Tree

Recursion Stack

===============================================================================
PATTERN LEARNED
===============================================================================

Tree DFS

Tree Comparison

Combination of:

- Same Tree (100)
- Recursive Tree Traversal

Used In:

- Subtree of Another Tree
- Symmetric Tree
- Tree Matching Problems
- Duplicate Subtrees

===============================================================================
*/

class Solution {

    public boolean isSubtree(TreeNode root, TreeNode sub) {

        if (root == null) {
            return false;
        }

        // Found matching subtree
        if (isSame(root, sub)) {
            return true;
        }

        // Search left or right subtree
        return isSubtree(root.left, sub)
                || isSubtree(root.right, sub);
    }

    public boolean isSame(TreeNode root, TreeNode sub) {

        // Both null
        if (root == null && sub == null) {
            return true;
        }

        // One null
        if (root == null || sub == null) {
            return false;
        }

        // Values differ
        if (root.val != sub.val) {
            return false;
        }

        // Compare left and right subtrees
        return isSame(root.left, sub.left)
                && isSame(root.right, sub.right);
    }
}
