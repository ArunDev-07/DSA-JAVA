/*
===============================================================================
                                PATH SUM
===============================================================================

Platform  : LeetCode (112)
Approach  : Recursion / DFS
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the root of a binary tree and an integer targetSum.

Return true if the tree has a root-to-leaf path such that:

Sum of all node values along the path = targetSum

Otherwise return false.

A leaf node is a node with:

left == null
right == null

===============================================================================
EXAMPLE
===============================================================================

Input:

targetSum = 22

                5
              /   \
             4     8
            /     / \
          11    13   4
         /  \          \
        7    2          1

Output:

true

Reason:

5 → 4 → 11 → 2

Sum:

5 + 4 + 11 + 2 = 22

===============================================================================
CORE IDEA - DFS RECURSION
===============================================================================

At every node:

Subtract current node value from target.

remaining = target - root.val

Then move down the tree.

Eventually:

If we reach a leaf node:

Check whether remaining becomes 0.

If yes:

Path found.

If no:

Path doesn't exist.

===============================================================================
RECURSIVE RELATION
===============================================================================

remaining = target - root.val

Return:

hasPathSum(root.left, remaining)

OR

hasPathSum(root.right, remaining)

===============================================================================
BASE CASES
===============================================================================

Case 1:

root == null

Return false

Reason:

No path exists.

-------------------------------------------------------------------------------

Case 2:

Leaf Node

root.left == null
root.right == null

Check:

remaining == 0

If yes:

Return true

Else:

Return false

===============================================================================
FULL DRY RUN
===============================================================================

Input:

targetSum = 22

                5
              /   \
             4     8
            /
          11
         /  \
        7    2

-------------------------------------------------------------------------------

Call:

hasPathSum(5, 22)

remaining:

22 - 5

= 17

-------------------------------------------------------------------------------

Call:

hasPathSum(4, 17)

remaining:

17 - 4

= 13

-------------------------------------------------------------------------------

Call:

hasPathSum(11, 13)

remaining:

13 - 11

= 2

-------------------------------------------------------------------------------

Call:

hasPathSum(2, 2)

remaining:

2 - 2

= 0

Node 2 is a leaf.

Check:

remaining == 0

true

Return true

-------------------------------------------------------------------------------

Recursive Calls Return:

true

-------------------------------------------------------------------------------

Final Answer:

true

===============================================================================
RECURSION TREE
===============================================================================

hasPathSum(5,22)
│
├── hasPathSum(4,17)
│   │
│   └── hasPathSum(11,13)
│       │
│       ├── hasPathSum(7,2)
│       │   └── false
│       │
│       └── hasPathSum(2,2)
│           └── true
│
└── hasPathSum(8,17)
    └── ...

Final Answer:

true

===============================================================================
VISUALIZATION
===============================================================================

Target:

22

At Node 5:

Remaining:

22 - 5 = 17

----------------------------------

At Node 4:

Remaining:

17 - 4 = 13

----------------------------------

At Node 11:

Remaining:

13 - 11 = 2

----------------------------------

At Node 2:

Remaining:

2 - 2 = 0

Leaf Node Reached

Path Found

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

n = Number of Nodes

Every node is visited at most once.

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

Root-to-Leaf Traversal

Used In:

- Path Sum
- Path Sum II
- Sum Root to Leaf Numbers
- Binary Tree Paths
- Maximum Path Sum

===============================================================================
*/

class Solution {

    public boolean hasPathSum(TreeNode root, int target) {

        // Base Case
        if (root == null) {
            return false;
        }

        int remaining = target - root.val;

        // Leaf Node
        if (root.left == null && root.right == null) {
            return remaining == 0;
        }

        // Explore Left or Right Path
        return hasPathSum(root.left, remaining)
                || hasPathSum(root.right, remaining);
    }
}
