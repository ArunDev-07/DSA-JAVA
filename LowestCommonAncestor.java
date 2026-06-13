/*
===============================================================================
                    LOWEST COMMON ANCESTOR OF A BST
===============================================================================

Platform  : LeetCode (235)
Approach  : Iterative BST Traversal
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given a Binary Search Tree (BST) and two nodes p and q.

Find the Lowest Common Ancestor (LCA).

Lowest Common Ancestor:

The lowest node in the tree that has both p and q
as descendants (a node can be a descendant of itself).

===============================================================================
BST PROPERTY
===============================================================================

For every node:

Left Subtree  < Root

Right Subtree > Root

Example:

                6
              /   \
             2     8
            / \   / \
           0   4 7   9
              / \
             3   5

===============================================================================
EXAMPLE
===============================================================================

Input:

p = 2
q = 8

                6
              /   \
             2     8

Output:

6

Reason:

6 is the first node where p and q split.

===============================================================================
CORE IDEA
===============================================================================

Use BST Property.

Case 1:

Both nodes smaller than current node.

Move Left.

----------------------------------

Case 2:

Both nodes greater than current node.

Move Right.

----------------------------------

Case 3:

Nodes split.

One node on left.
One node on right.

OR

Current node equals p or q.

Current node is the LCA.

===============================================================================
ALGORITHM
===============================================================================

While root is not null:

    If p and q are both smaller:

        Move Left

    Else if p and q are both greater:

        Move Right

    Else:

        Current node is LCA

===============================================================================
FULL DRY RUN
===============================================================================

Tree:

                6
              /   \
             2     8
            / \   / \
           0   4 7   9
              / \
             3   5

p = 2
q = 8

-------------------------------------------------------------------------------

root = 6

Check:

2 < 6

8 > 6

Nodes are on different sides.

-------------------------------------------------------------------------------

Return:

6

Answer:

6

===============================================================================
ANOTHER DRY RUN
===============================================================================

p = 2
q = 4

-------------------------------------------------------------------------------

root = 6

2 < 6

4 < 6

Move Left

root = 2

-------------------------------------------------------------------------------

Check:

p = 2

q = 4

One node equals root.

Current node is LCA.

Return:

2

===============================================================================
VISUALIZATION
===============================================================================

Case 1

                6
               /
              2
             /
            0

Both nodes smaller.

Move Left.

-------------------------------------------------------------------------------

Case 2

                6
                 \
                  8
                   \
                    9

Both nodes greater.

Move Right.

-------------------------------------------------------------------------------

Case 3

                6
              /   \
             2     8

Nodes split here.

LCA = 6

===============================================================================
WHY THIS WORKS?
===============================================================================

BST gives ordering information.

Instead of searching the entire tree:

We eliminate half the tree at every step.

Similar to Binary Search.

===============================================================================
TIME COMPLEXITY
===============================================================================

Average Case:

O(log n)

-------------------------------------------------------------------------------

Worst Case:

O(n)

For a skewed BST.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(1)

Iterative Solution

===============================================================================
PATTERN LEARNED
===============================================================================

BST Traversal

Binary Search on Tree

Used In:

- Search BST
- Insert BST
- Delete BST
- Lowest Common Ancestor in BST
- Closest Value in BST

===============================================================================
*/

class Solution {

    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        while (root != null) {

            // Both nodes in left subtree
            if (p.val < root.val && q.val < root.val) {

                root = root.left;
            }

            // Both nodes in right subtree
            else if (p.val > root.val && q.val > root.val) {

                root = root.right;
            }

            // Nodes split here
            else {

                return root;
            }
        }

        return null;
    }
}
