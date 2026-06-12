# /*

```
                      BINARY TREE TRAVERSALS
```

===============================================================================

Platform  : Concept / Tree Basics
Approach  : DFS + BFS
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given a Binary Tree, perform the following traversals:

1. Inorder Traversal
2. Preorder Traversal
3. Postorder Traversal
4. Level Order Traversal

===============================================================================
TREE USED
=========

```
            10
          /    \
        20      30
       /  \    /  \
     40   50  60   70
```

===============================================================================
TRAVERSAL ORDERS
================

INORDER

Left -> Root -> Right

Output:

40 20 50 10 60 30 70

---

PREORDER

Root -> Left -> Right

Output:

10 20 40 50 30 60 70

---

POSTORDER

Left -> Right -> Root

Output:

40 50 20 60 70 30 10

---

LEVEL ORDER

Level by Level

Output:

10 20 30 40 50 60 70

===============================================================================
CORE IDEA
=========

DFS Traversals:

1. Inorder
2. Preorder
3. Postorder

Use Recursion.

---

BFS Traversal:

Level Order

Use Queue.

===============================================================================
TIME COMPLEXITY
===============

Inorder     : O(n)

Preorder    : O(n)

Postorder   : O(n)

Level Order : O(n)

===============================================================================
SPACE COMPLEXITY
================

DFS Traversals:

O(h)

h = height of tree

---

Level Order:

O(w)

w = maximum width of tree

===============================================================================
PATTERN LEARNED
===============

Tree Traversal

DFS:

* Inorder
* Preorder
* Postorder

BFS:

* Level Order

Foundation for:

* Binary Search Trees
* Tree Problems
* Graph Traversal
* Heaps

===============================================================================
*/

import java.util.*;

class Node {

```
int val;
Node left;
Node right;

public Node(int val) {
    this.val = val;
}

// Inorder Traversal
public void Inorder(Node root) {

    if (root == null) {
        return;
    }

    Inorder(root.left);

    System.out.print(root.val + " ");

    Inorder(root.right);
}

// Preorder Traversal
public void PreOrder(Node root) {

    if (root == null) {
        return;
    }

    System.out.print(root.val + " ");

    PreOrder(root.left);

    PreOrder(root.right);
}

// Postorder Traversal
public void PostOrder(Node root) {

    if (root == null) {
        return;
    }

    PostOrder(root.left);

    PostOrder(root.right);

    System.out.print(root.val + " ");
}

// Level Order Traversal
public void Level(Node root) {

    if (root == null) {
        return;
    }

    Queue<Node> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

        Node curr = queue.poll();

        System.out.print(curr.val + " ");

        if (curr.left != null) {
            queue.offer(curr.left);
        }

        if (curr.right != null) {
            queue.offer(curr.right);
        }
    }
}
```

}

public class Main {

```
public static void main(String[] args) {

    Node root = new Node(10);

    root.left = new Node(20);
    root.right = new Node(30);

    root.left.left = new Node(40);
    root.left.right = new Node(50);

    root.right.left = new Node(60);
    root.right.right = new Node(70);

    System.out.println("Inorder Traversal:");
    root.Inorder(root);

    System.out.println();

    System.out.println("Preorder Traversal:");
    root.PreOrder(root);

    System.out.println();

    System.out.println("Postorder Traversal:");
    root.PostOrder(root);

    System.out.println();

    System.out.println("Level Order Traversal:");
    root.Level(root);
}
```

}
