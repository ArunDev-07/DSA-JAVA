/*
===============================================================================
                    LEETCODE 234 - PALINDROME LINKED LIST
===============================================================================

Platform  : LeetCode
Problem   : 234
Approach  : Fast & Slow Pointer + Reverse Linked List
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given the head of a singly linked list, return true if it is a palindrome.

A palindrome reads the same forwards and backwards.

Examples:

1 -> 2 -> 2 -> 1      => true

1 -> 2                => false

1 -> 2 -> 3 -> 2 -> 1 => true

===============================================================================
CORE IDEA
===============================================================================

We already know two important linked list techniques:

1. Find Middle of Linked List
2. Reverse Linked List

We'll combine both.

Steps:

1. Find middle using slow and fast pointers.
2. Reverse the second half of the linked list.
3. Compare first half and reversed second half.
4. If every value matches → Palindrome.
5. Else → Not a palindrome.

===============================================================================
WHY REVERSE ONLY SECOND HALF?
===============================================================================

Brute Force:

Linked List
    ↓
Array
    ↓
Compare

Time  : O(n)
Space : O(n)

Optimal Solution:

Find Middle
    ↓
Reverse Second Half
    ↓
Compare

Time  : O(n)
Space : O(1)

===============================================================================
VISUAL EXAMPLE
===============================================================================

Input:

1 -> 2 -> 2 -> 1

Step 1: Find Middle

slow
 ↓

1 -> 2 -> 2 -> 1

After traversal:

1 -> 2 -> 2 -> 1
          ↑
        slow

-------------------------------------------------------------------------------

Step 2: Reverse Second Half

Second Half:

2 -> 1

After Reverse:

1 -> 2

-------------------------------------------------------------------------------

Step 3: Compare

First Half:

1 -> 2

Second Half:

1 -> 2

Compare:

1 == 1 ✓
2 == 2 ✓

Return true

===============================================================================
FULL DRY RUN
===============================================================================

Input:

1 -> 2 -> 2 -> 1

-------------------------------------------------------------------------------
PHASE 1 : FIND MIDDLE
-------------------------------------------------------------------------------

Initial:

slow = 1
fast = 1

Iteration 1:

slow = 2
fast = 2

List:

1 -> 2 -> 2 -> 1
     ↑    ↑
   slow  fast

-------------------------------------------------------------------------------

Iteration 2:

slow = 2
fast = null

List:

1 -> 2 -> 2 -> 1
          ↑
        slow

Middle Found

-------------------------------------------------------------------------------
PHASE 2 : REVERSE SECOND HALF
-------------------------------------------------------------------------------

Current:

slow = node(2)

Second Half:

2 -> 1

Initialize:

prev = null
curr = 2

-------------------------------------------------------------------------------

Iteration 1

next = 1

2 -> null

prev = 2
curr = 1

-------------------------------------------------------------------------------

Iteration 2

next = null

1 -> 2 -> null

prev = 1
curr = null

Reverse Completed

Result:

1 -> 2

prev points to head of reversed half

-------------------------------------------------------------------------------
PHASE 3 : COMPARE
-------------------------------------------------------------------------------

first  = head
second = prev

first:

1 -> 2 -> 2 -> 1

second:

1 -> 2

-------------------------------------------------------------------------------

Comparison 1

1 == 1 ✓

Move both

first  = 2
second = 2

-------------------------------------------------------------------------------

Comparison 2

2 == 2 ✓

Move both

second = null

Comparison Finished

Return true

===============================================================================
TIME COMPLEXITY
===============================================================================

Finding Middle     : O(n)

Reverse Half       : O(n)

Compare Halves     : O(n)

Total Time         : O(n)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Only pointers are used.

Space = O(1)

===============================================================================
INTERVIEW NOTES
===============================================================================

Q) Why use slow and fast pointers?

A)

To find the middle in one traversal.

-------------------------------------------------------------------------------

Q) Why reverse only the second half?

A)

Allows comparison without extra memory.

-------------------------------------------------------------------------------

Q) Can we solve using an ArrayList?

A)

Yes.

Store values in array and compare.

Time  : O(n)
Space : O(n)

But interviewer usually expects O(1) space.

-------------------------------------------------------------------------------

Q) What concepts are combined here?

A)

1. Middle of Linked List
2. Reverse Linked List

This is why LeetCode 234 is considered an important interview problem.

===============================================================================
CODE
===============================================================================
*/

class Solution {

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Find middle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {

            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Compare both halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {

            if (first.val != second.val) {
                return false;
            }

            first = first.next;
            second = second.next;
        }

        return true;
    }
}
