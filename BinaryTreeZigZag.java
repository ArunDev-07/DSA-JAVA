===============================================================================

                 BINARY TREE ZIGZAG LEVEL ORDER TRAVERSAL

===============================================================================

Platform  : LeetCode 103
Approach  : Breadth First Search (Level Order Traversal)
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given the root of a binary tree.

Return the level order traversal of its nodes'
values in a zigzag pattern.

Meaning:

Level 0 → Left to Right
Level 1 → Right to Left
Level 2 → Left to Right
Level 3 → Right to Left

and so on.

Example:

            1
          /   \
         2     3
        / \   / \
       4  5  6   7

Output:

[
 [1],
 [3,2],
 [4,5,6,7]
]

===============================================================================
CORE IDEA
=========

Use Level Order Traversal (BFS).

For every level:

1. Process all nodes
2. Store nodes in a list
3. If current direction is Right to Left
      reverse the list
4. Add list to result
5. Toggle direction

===============================================================================
WHY DOES THIS WORK?
===================

Level 0:

[1]

Direction:

Left → Right

Result:

[1]

-------------------------------------------------------------------------------

Level 1:

[2,3]

Direction:

Right → Left

Reverse:

[3,2]

Result:

[
 [1],
 [3,2]
]

-------------------------------------------------------------------------------

Level 2:

[4,5,6,7]

Direction:

Left → Right

No reverse.

Result:

[
 [1],
 [3,2],
 [4,5,6,7]
]

===============================================================================
TIME COMPLEXITY
===============

Every node is visited once.

O(n)

===============================================================================
SPACE COMPLEXITY
================

Queue stores nodes level by level.

Worst Case:

O(n)

===============================================================================
FULL DRY RUN
============

Input:

            1
          /   \
         2     3
        / \   / \
       4  5  6   7

-------------------------------------------------------------------------------

INITIAL

Queue:

[1]

Result:

[]

lefttoright = true

-------------------------------------------------------------------------------

LEVEL 0

size = 1

List:

[]

-------------------------------------------------------------------------------

i = 0

curr = 1

list.add(1)

List:

[1]

Add Children:

2
3

Queue:

[2,3]

-------------------------------------------------------------------------------

Check Direction

lefttoright = true

No reverse

Result:

[
 [1]
]

Toggle:

lefttoright = false

-------------------------------------------------------------------------------

LEVEL 1

Queue:

[2,3]

size = 2

List:

[]

-------------------------------------------------------------------------------

i = 0

curr = 2

List:

[2]

Add Children:

4
5

Queue:

[3,4,5]

-------------------------------------------------------------------------------

i = 1

curr = 3

List:

[2,3]

Add Children:

6
7

Queue:

[4,5,6,7]

-------------------------------------------------------------------------------

Check Direction

lefttoright = false

Reverse:

[3,2]

Result:

[
 [1],
 [3,2]
]

Toggle:

lefttoright = true

-------------------------------------------------------------------------------

LEVEL 2

Queue:

[4,5,6,7]

size = 4

List:

[]

-------------------------------------------------------------------------------

i = 0

curr = 4

List:

[4]

-------------------------------------------------------------------------------

i = 1

curr = 5

List:

[4,5]

-------------------------------------------------------------------------------

i = 2

curr = 6

List:

[4,5,6]

-------------------------------------------------------------------------------

i = 3

curr = 7

List:

[4,5,6,7]

Queue:

[]

-------------------------------------------------------------------------------

Check Direction

lefttoright = true

No Reverse

Result:

[
 [1],
 [3,2],
 [4,5,6,7]
]

Toggle:

lefttoright = false

-------------------------------------------------------------------------------

Queue Empty

Traversal Finished

Final Answer:

[
 [1],
 [3,2],
 [4,5,6,7]
]

===============================================================================
WHY IS lefttoright OUTSIDE THE WHILE LOOP?
==========================================

Correct:

boolean lefttoright = true;

while(!queue.isEmpty()){

    ...

    lefttoright = !lefttoright;
}

-------------------------------------------------------------------------------

Level 0:

lefttoright = true

-------------------------------------------------------------------------------

After Level 0:

lefttoright = false

-------------------------------------------------------------------------------

Level 1:

lefttoright = false

-------------------------------------------------------------------------------

After Level 1:

lefttoright = true

-------------------------------------------------------------------------------

Level 2:

lefttoright = true

-------------------------------------------------------------------------------

Pattern:

true
false
true
false

-------------------------------------------------------------------------------

Wrong:

while(!queue.isEmpty()){

    boolean lefttoright = true;

}

Every level starts with:

true

true

true

true

So reverse never happens.

===============================================================================
PATTERN LEARNED
===============

Level Order Traversal (BFS)

Used In:

• Binary Tree Level Order Traversal
• Zigzag Level Order Traversal
• Right Side View
• Left Side View
• Average of Levels
• Maximum Level Sum

===============================================================================
JAVA SOLUTION
=============

class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        boolean lefttoright = true;

        while(!queue.isEmpty()){

            int size = queue.size();

            List<Integer> list = new ArrayList<>();

            for(int i = 0 ; i < size ; i++){

                TreeNode curr = queue.poll();

                list.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
                }

                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }

            if(!lefttoright){
                Collections.reverse(list);
            }

            result.add(list);

            lefttoright = !lefttoright;
        }

        return result;
    }
}

===============================================================================
KEY TAKEAWAY
============

Level Order Traversal

+

Alternate Direction

Level 0 → Left to Right

Level 1 → Right to Left

Level 2 → Left to Right

Level 3 → Right to Left

This creates the Zigzag pattern.

===============================================================================
