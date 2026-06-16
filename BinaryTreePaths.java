/*
===============================================================================
                           BINARY TREE PATHS
===============================================================================

Platform  : LeetCode 257
Approach  : DFS + Backtracking
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the root of a binary tree, return all root-to-leaf paths.

A root-to-leaf path is a path that starts from the root node and
ends at a leaf node.

Example:

        1
       / \
      2   3
       \
        5

Output:

["1->2->5", "1->3"]

===============================================================================
CORE IDEA
===============================================================================

Use DFS Traversal.

At each node:

    Add current node value to path.

If current node is a leaf:

    Store path into result.

Otherwise:

    Continue DFS on left subtree.
    Continue DFS on right subtree.

===============================================================================
WHY DFS WORKS?
===============================================================================

DFS naturally explores one complete path from:

    Root → Leaf

before moving to another path.

Exactly what the problem requires.

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

Where:

n = Number of nodes

Every node is visited once.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(h)

h = Height of tree

Recursion stack stores one path at a time.

Worst Case:

O(n)

for skewed tree.

===============================================================================
FULL DRY RUN
===============================================================================

Input Tree:

        1
       / \
      2   3
       \
        5

-------------------------------------------------------------------------------
Step 1

dfs(1, "")

path = "1"

Not a leaf.

Add:

path = "1->"

Go Left

-------------------------------------------------------------------------------
Step 2

dfs(2, "1->")

path = "1->2"

Not a leaf.

Add:

path = "1->2->"

Go Right

-------------------------------------------------------------------------------
Step 3

dfs(5, "1->2->")

path = "1->2->5"

Leaf Node Found

Add to result:

["1->2->5"]

Return

-------------------------------------------------------------------------------
Backtrack to Root

Go Right

dfs(3, "1->")

path = "1->3"

Leaf Node Found

Add to result:

["1->2->5", "1->3"]

Return

-------------------------------------------------------------------------------
Traversal Finished

Final Answer:

["1->2->5", "1->3"]

===============================================================================
PATTERN LEARNED
===============================================================================

Tree DFS + Path Building

Used In:

- Binary Tree Paths
- Path Sum II
- Sum Root to Leaf Numbers
- Count Good Nodes
- Root to Leaf Path Problems

===============================================================================
JAVA SOLUTION
===============================================================================
*/

class Solution {

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> result = new ArrayList<>();

        dfs(root, "", result);

        return result;
    }

    public void dfs(TreeNode root, String path, List<String> result) {

        if (root == null) {
            return;
        }

        path += root.val;

        // Leaf Node
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        path += "->";

        dfs(root.left, path, result);
        dfs(root.right, path, result);
    }
}
