# /*

```
                      BINARY TREE RIGHT SIDE VIEW
```

===============================================================================

Platform  : LeetCode 199
Approach  : Breadth First Search (Level Order Traversal)
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given the root of a binary tree, imagine standing on the right side
of the tree.

Return all nodes visible from top to bottom.

Example:

```
    1
   / \
  2   3
   \   \
    5   4
```

Visible Nodes:

```
1 → 3 → 4
```

Answer:

```
[1, 3, 4]
```

===============================================================================
CORE IDEA
=========

Perform Level Order Traversal (BFS).

For every level:

```
Process all nodes.
```

The LAST node processed in that level
will be the rightmost node.

Store only:

```
i == size - 1
```

===============================================================================
WHY DOES THIS WORK?
===================

Level 0:

```
[1]
```

Rightmost = 1

Level 1:

```
[2, 3]
```

Rightmost = 3

Level 2:

```
[5, 4]
```

Rightmost = 4

Result:

```
[1, 3, 4]
```

===============================================================================
TIME COMPLEXITY
===============

Every node is visited once.

```
O(n)
```

===============================================================================
SPACE COMPLEXITY
================

Queue stores one level at a time.

Worst Case:

```
O(n)
```

===============================================================================
FULL DRY RUN
============

Input:

```
    1
   / \
  2   3
   \   \
    5   4
```

---

Initial:

Queue:

```
[1]
```

Result:

```
[]
```

---

LEVEL 0

size = 1

i = 0

curr = 1

i == size - 1

0 == 0

TRUE

Add:

```
result = [1]
```

Add Children:

```
2
3
```

Queue:

```
[2, 3]
```

---

LEVEL 1

size = 2

Queue:

```
[2, 3]
```

---

i = 0

curr = 2

0 == 1

FALSE

Do not add.

Add Child:

```
5
```

Queue:

```
[3, 5]
```

---

i = 1

curr = 3

1 == 1

TRUE

Add:

```
result = [1, 3]
```

Add Child:

```
4
```

Queue:

```
[5, 4]
```

---

LEVEL 2

size = 2

Queue:

```
[5, 4]
```

---

i = 0

curr = 5

0 == 1

FALSE

Do not add.

Queue:

```
[4]
```

---

i = 1

curr = 4

1 == 1

TRUE

Add:

```
result = [1, 3, 4]
```

Queue:

```
[]
```

---

Traversal Finished

Answer:

```
[1, 3, 4]
```

===============================================================================
PATTERN LEARNED
===============

Level Order Traversal (BFS)

Used In:

* Binary Tree Level Order Traversal
* Right Side View
* Left Side View
* Zigzag Level Order Traversal
* Average of Levels
* Maximum Level Sum

===============================================================================
JAVA SOLUTION
=============

*/

class Solution {

```
public List<Integer> rightSideView(TreeNode root) {

    if (root == null) {
        return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

        int size = queue.size();

        for (int i = 0; i < size; i++) {

            TreeNode curr = queue.poll();

            // Rightmost node of current level
            if (i == size - 1) {
                result.add(curr.val);
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }
    }

    return result;
}
```

}
