/*
===============================================================================
                  LOWEST COMMON ANCESTOR OF A BINARY TREE
===============================================================================

Platform  : Binary Tree Concept
Approach  : Recursion / DFS
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given a Binary Tree and two nodes p and q.

Find their Lowest Common Ancestor (LCA).

Lowest Common Ancestor:

The lowest node that has both p and q
as descendants.

A node can be a descendant of itself.

===============================================================================
EXAMPLE
===============================================================================

Tree:

                3
              /   \
             5     1
            / \   / \
           6   2 0   8
              / \
             7   4

p = 5
q = 1

Output:

3

===============================================================================
ANOTHER EXAMPLE
===============================================================================

p = 5
q = 4

Output:

5

Reason:

5 is an ancestor of 4.

===============================================================================
CORE IDEA
===============================================================================

For every node:

1) If node is null
      Return null

2) If node equals p or q
      Return current node

3) Search left subtree

4) Search right subtree

5) If both sides return non-null
      Current node is LCA

6) Otherwise return the non-null side

===============================================================================
RECURSIVE RELATION
===============================================================================

left = lca(root.left)

right = lca(root.right)

----------------------------------

If left != null && right != null

Return root

----------------------------------

Otherwise

Return left != null ? left : right

===============================================================================
BASE CASES
===============================================================================

Case 1

root == null

Return null

-------------------------------------------------------------------------------

Case 2

root.data == p

Return root

-------------------------------------------------------------------------------

Case 3

root.data == q

Return root

===============================================================================
FULL DRY RUN
===============================================================================

Tree:

                3
              /   \
             5     1
            / \   / \
           6   2 0   8
              / \
             7   4

p = 5
q = 1

-------------------------------------------------------------------------------

lca(3)

Search Left

lca(5)

Found p

Return 5

-------------------------------------------------------------------------------

Search Right

lca(1)

Found q

Return 1

-------------------------------------------------------------------------------

At Node 3

left = 5

right = 1

Both Non-Null

Return 3

===============================================================================
ANOTHER DRY RUN
===============================================================================

p = 7
q = 4

-------------------------------------------------------------------------------

lca(3)

Search Left

-------------------------------------------------------------------------------

lca(5)

Search Left

lca(6)

Returns null

-------------------------------------------------------------------------------

Search Right

lca(2)

-------------------------------------------------------------------------------

lca(7)

Found

Return 7

-------------------------------------------------------------------------------

lca(4)

Found

Return 4

-------------------------------------------------------------------------------

At Node 2

left = 7

right = 4

Both Non-Null

Return 2

-------------------------------------------------------------------------------

Final Answer:

2

===============================================================================
RECURSION TREE
===============================================================================

lca(3)
│
├── lca(5)
│   ├── lca(6)
│   └── lca(2)
│       ├── lca(7)
│       └── lca(4)
│
└── lca(1)

===============================================================================
VISUALIZATION
===============================================================================

                3
              /   \
             5     1

            ↑     ↑

          p=5   q=1

First node where both paths meet:

                3

Answer = 3

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

Tree DFS

Postorder Traversal Logic

Used In:

- Lowest Common Ancestor
- Distance Between Nodes
- Tree Path Problems
- Binary Tree Queries

===============================================================================
*/

import java.util.*;

class Node {

    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Main {

    static Node lca(Node root, int p, int q) {

        // Base Case
        if (root == null) {
            return null;
        }

        // Found p or q
        if (root.data == p || root.data == q) {
            return root;
        }

        Node left = lca(root.left, p, q);

        Node right = lca(root.right, p, q);

        // Both sides found
        if (left != null && right != null) {
            return root;
        }

        // Return non-null side
        return left != null ? left : right;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        HashMap<Integer, Node> map = new HashMap<>();

        Node root = null;

        for (int i = 0; i < n; i++) {

            int parent = sc.nextInt();
            int l = sc.nextInt();
            int r = sc.nextInt();

            if (!map.containsKey(parent)) {
                map.put(parent, new Node(parent));
            }

            Node curr = map.get(parent);

            if (i == 0) {
                root = curr;
            }

            if (l != -1) {

                map.putIfAbsent(l, new Node(l));

                curr.left = map.get(l);
            }

            if (r != -1) {

                map.putIfAbsent(r, new Node(r));

                curr.right = map.get(r);
            }
        }

        int p = sc.nextInt();

        int q = sc.nextInt();

        System.out.println(lca(root, p, q).data);
    }
}
