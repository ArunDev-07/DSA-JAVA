/*
===============================================================================
                        SEARCH IN A BINARY SEARCH TREE
===============================================================================

Platform  : LeetCode (700)
Approach  : Iterative BST Search
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the root of a Binary Search Tree (BST) and an integer value.

Return the node whose value equals val.

If the value doesn't exist, return null.

===============================================================================
BST PROPERTY
===============================================================================

For every node:

Left Subtree  < Root

Right Subtree > Root

Example:

                4
              /   \
             2     7
            / \
           1   3

===============================================================================
CORE IDEA
===============================================================================

Use BST Property.

If:

val == root.val

Return root.

----------------------------------

If:

val > root.val

Search Right Subtree.

----------------------------------

If:

val < root.val

Search Left Subtree.

===============================================================================
FULL DRY RUN
===============================================================================

Input:

                4
              /   \
             2     7
            / \
           1   3

val = 2

-------------------------------------------------------------------------------

root = 4

2 < 4

Move Left

root = 2

-------------------------------------------------------------------------------

root = 2

2 == 2

Return root

===============================================================================
VISUALIZATION
===============================================================================

Search 2

        4
       /
      2
     ✓

Found

===============================================================================
TIME COMPLEXITY
===============================================================================

Average Case:

O(log n)

-------------------------------------------------------------------------------

Worst Case:

O(n)

Skewed Tree

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(1)

Iterative Solution

===============================================================================
PATTERN LEARNED
===============================================================================

Binary Search on Tree

Used In:

- Search BST
- Insert BST
- Delete BST
- Lowest Common Ancestor in BST

===============================================================================
*/

class Solution {

    public TreeNode searchBST(TreeNode root, int val) {

        while (root != null) {

            if (root.val == val) {
                return root;
            }

            else if (root.val < val) {
                root = root.right;
            }

            else {
                root = root.left;
            }
        }

        return null;
    }
}  

/*
===============================================================================
                        DIAMETER OF BINARY TREE
===============================================================================

Platform  : LeetCode (543)
Approach  : DFS + Height Calculation
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the root of a binary tree.

Return the diameter of the tree.

Diameter:

The length of the longest path between any two nodes.

The path may or may not pass through the root.

===============================================================================
EXAMPLE
===============================================================================

                1
               / \
              2   3
             / \
            4   5

Longest Path:

4 → 2 → 1 → 3

Diameter = 3

===============================================================================
CORE IDEA
===============================================================================

At every node:

Calculate:

Left Height

Right Height

Possible Diameter:

leftHeight + rightHeight

Update global answer.

===============================================================================
IMPORTANT OBSERVATION
===============================================================================

Height:

Number of nodes from current node to deepest leaf.

-------------------------------------------------------------------------------

Diameter Through Current Node:

leftHeight + rightHeight

===============================================================================
RECURSIVE RELATION
===============================================================================

left = height(left subtree)

right = height(right subtree)

diameter = left + right

height = max(left, right) + 1

===============================================================================
FULL DRY RUN
===============================================================================

Tree:

                1
               / \
              2   3
             / \
            4   5

-------------------------------------------------------------------------------

Node 4

left = 0

right = 0

diameter = 0

height = 1

-------------------------------------------------------------------------------

Node 5

left = 0

right = 0

diameter = 0

height = 1

-------------------------------------------------------------------------------

Node 2

left = 1

right = 1

diameter = 2

maxDiameter = 2

height = 2

-------------------------------------------------------------------------------

Node 3

height = 1

-------------------------------------------------------------------------------

Node 1

left = 2

right = 1

diameter = 3

maxDiameter = 3

height = 3

-------------------------------------------------------------------------------

Answer:

3

===============================================================================
RECURSION TREE
===============================================================================

Calculate(1)
│
├── Calculate(2)
│   ├── Calculate(4)
│   └── Calculate(5)
│
└── Calculate(3)

===============================================================================
VISUALIZATION
===============================================================================

                1
               / \
              2   3
             / \
            4   5

Longest Path:

4 → 2 → 1 → 3

Length:

3 Edges

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

===============================================================================
PATTERN LEARNED
===============================================================================

Tree DFS

Height-Based Problems

Used In:

- Diameter of Binary Tree
- Balanced Binary Tree
- Maximum Depth
- Minimum Depth

===============================================================================
*/

class Solution {

    private int maxdiameter;

    public int diameterOfBinaryTree(TreeNode root) {

        maxdiameter = 0;

        Calculate(root);

        return maxdiameter;
    }

    public int Calculate(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = Calculate(root.left);

        int right = Calculate(root.right);

        maxdiameter = Math.max(maxdiameter, left + right);

        return Math.max(left, right) + 1;
    }
}
