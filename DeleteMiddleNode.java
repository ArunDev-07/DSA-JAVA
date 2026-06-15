/*
===============================================================================
                      DELETE THE MIDDLE NODE OF A LINKED LIST
===============================================================================

Platform  : LeetCode (2095)
Approach  : Fast & Slow Pointers
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the head of a singly linked list.

Delete the middle node and return the head of the modified list.

Middle Node:

Index = floor(n / 2)

(0-based indexing)

===============================================================================
EXAMPLE 1
===============================================================================

Input:

1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

Length = 7

Middle Index = 3

Middle Node = 7

Output:

1 -> 3 -> 4 -> 1 -> 2 -> 6

===============================================================================
EXAMPLE 2
===============================================================================

Input:

1 -> 2 -> 3 -> 4

Length = 4

Middle Index = 2

Middle Node = 3

Output:

1 -> 2 -> 4

===============================================================================
CORE IDEA
===============================================================================

Use Fast and Slow Pointers.

Slow Pointer:

Moves 1 step.

Fast Pointer:

Moves 2 steps.

When Fast reaches the end:

Slow reaches the middle.

===============================================================================
WHY PREV IS NEEDED?
===============================================================================

To delete a node in a singly linked list:

We need access to the previous node.

Example:

1 -> 2 -> 3 -> 4

Delete 3

Need:

2.next = 4

Therefore:

Keep track of previous node.

===============================================================================
ALGORITHM
===============================================================================

1) Handle edge case:

   If only one node exists:
   Return null.

2) Initialize:

   slow = head
   fast = head
   prev = null

3) Move:

   slow = slow.next

   fast = fast.next.next

4) When loop ends:

   slow = middle node

   prev = node before middle

5) Delete:

   prev.next = slow.next

6) Return head

===============================================================================
FULL DRY RUN
===============================================================================

Input:

1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6

-------------------------------------------------------------------------------

Initial

slow = 1

fast = 1

prev = null

-------------------------------------------------------------------------------

Iteration 1

prev = 1

slow = 3

fast = 4

-------------------------------------------------------------------------------

Iteration 2

prev = 3

slow = 4

fast = 1

-------------------------------------------------------------------------------

Iteration 3

prev = 4

slow = 7

fast = 6

-------------------------------------------------------------------------------

Loop Ends

slow = 7

prev = 4

-------------------------------------------------------------------------------

Delete Middle

prev.next = slow.next

4 -> 1

-------------------------------------------------------------------------------

Result

1 -> 3 -> 4 -> 1 -> 2 -> 6

===============================================================================
VISUALIZATION
===============================================================================

Initial

1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
S
F

-------------------------------------------------------------------------------

After Iteration 1

1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
     S
          F

-------------------------------------------------------------------------------

After Iteration 2

1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
          S
                    F

-------------------------------------------------------------------------------

After Iteration 3

1 -> 3 -> 4 -> 7 -> 1 -> 2 -> 6
               S
                              F

Middle Found

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

Single traversal of the linked list.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(1)

No extra data structures used.

===============================================================================
PATTERN LEARNED
===============================================================================

Fast & Slow Pointer

Used In:

- Delete Middle Node
- Middle of Linked List
- Linked List Cycle
- Find Start of Cycle
- Happy Number

===============================================================================
*/

class Solution {

    public ListNode deleteMiddle(ListNode head) {

        // Single node
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // Find middle node
        while (fast != null && fast.next != null) {

            prev = slow;

            slow = slow.next;

            fast = fast.next.next;
        }

        // Delete middle node
        prev.next = slow.next;

        return head;
    }
}
