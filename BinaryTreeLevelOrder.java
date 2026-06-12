# /*

```
                  BINARY TREE LEVEL ORDER TRAVERSAL
```

===============================================================================

Platform  : LeetCode (102)
Approach  : Breadth First Search (BFS)
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given the root of a binary tree.

Return the level order traversal of its nodes' values.

Traverse the tree level by level from left to right.

===============================================================================
EXAMPLE
=======

Input:

```
            3
          /   \
         9     20
              /  \
             15   7
```

Output:

[
[3],
[9,20],
[15,7]
]

===============================================================================
CORE IDEA
=========

Use a Queue to perform Breadth First Search (BFS).

At every iteration:

1. Determine the number of nodes in the current level.
2. Process exactly those nodes.
3. Store their values in a list.
4. Add their children to the queue.
5. Add the current level list to the result.

===============================================================================
WHY QUEUE?
==========

Queue follows FIFO (First In First Out).

Nodes are processed in the same order they appear in each level.

Queue Operations:

offer() -> Add node

poll() -> Remove node

===============================================================================
ALGORITHM
=========

1. If root is null:
   Return empty list.

2. Create Queue.

3. Add root to Queue.

4. While Queue is not empty:

   size = queue.size()

   Create current level list.

   Process exactly size nodes.

   Add children to queue.

   Store current level.

5. Return result.

===============================================================================
FULL DRY RUN
============

Tree:

```
            3
          /   \
         9     20
              /  \
             15   7
```

---

Initial

Queue:

[3]

Result:

[]

---

Level 1

size = 1

Poll:

3

Current Level:

[3]

Add children:

9,20

Queue:

[9,20]

Result:

[[3]]

---

Level 2

size = 2

Poll:

9

Current Level:

[9]

No children

---

Poll:

20

Current Level:

[9,20]

Add:

15,7

Queue:

[15,7]

Result:

[[3],[9,20]]

---

Level 3

size = 2

Poll:

15

Current Level:

[15]

---

Poll:

7

Current Level:

[15,7]

Queue:

[]

Result:

[[3],[9,20],[15,7]]

---

Queue Empty

Return Result

===============================================================================
VISUALIZATION
=============

Level 1

[3]

---

Level 2

[9,20]

---

Level 3

[15,7]

Final Answer:

[
[3],
[9,20],
[15,7]
]

===============================================================================
TIME COMPLEXITY
===============

O(n)

Every node is visited exactly once.

===============================================================================
SPACE COMPLEXITY
================

O(w)

w = Maximum Width of Tree

Queue may contain all nodes of one level.

===============================================================================
PATTERN LEARNED
===============

Breadth First Search (BFS)

Level Order Traversal

Used In:

* Binary Tree Level Order Traversal
* Right Side View
* Zigzag Traversal
* Minimum Depth
* Graph BFS

===============================================================================
*/

import java.util.*;

class Solution {

```
public List<List<Integer>> levelOrder(TreeNode root) {

    List<List<Integer>> result = new ArrayList<>();

    if (root == null) {
        return new ArrayList<>();
    }

    Queue<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

        int size = queue.size();

        List<Integer> level = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            TreeNode curr = queue.poll();

            level.add(curr.val);

            if (curr.left != null) {
                queue.offer(curr.left);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            }
        }

        result.add(level);
    }

    return result;
}
```

}
