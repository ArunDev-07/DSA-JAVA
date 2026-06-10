# LINKED LIST INTERVIEW NOTES (JAVA)

===============================================================================
1. LeetCode 83 - Remove Duplicates from Sorted List
2. LeetCode 876 - Middle of the Linked List
3. LeetCode 141 - Linked List Cycle
4. LeetCode 142 - Linked List Cycle II
===============================================================================

-------------------------------------------------------------------------------
LEETCODE 83 - REMOVE DUPLICATES FROM SORTED LIST
-------------------------------------------------------------------------------

PROBLEM SUMMARY
Remove duplicate nodes from a sorted linked list.

CORE IDEA
Use one pointer (curr).
If curr.val == curr.next.val:
    Skip duplicate node.
Else:
    Move forward.

DRY RUN
1 -> 1 -> 2 -> 3 -> 3

curr=1
duplicate found
1 -> 2 -> 3 -> 3

curr=2
move

curr=3
duplicate found

Result:
1 -> 2 -> 3

TIME: O(n)
SPACE: O(1)

CODE

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while(curr != null && curr.next != null){
            if(curr.val == curr.next.val){
                curr.next = curr.next.next;
            }else{
                curr = curr.next;
            }
        }
        return head;
    }
}

-------------------------------------------------------------------------------
LEETCODE 876 - MIDDLE OF THE LINKED LIST
-------------------------------------------------------------------------------

PROBLEM SUMMARY
Return middle node.

CORE IDEA
slow -> 1 step
fast -> 2 steps

When fast reaches end,
slow reaches middle.

DRY RUN

1 -> 2 -> 3 -> 4 -> 5

slow=1 fast=1

Iteration 1
slow=2
fast=3

Iteration 2
slow=3
fast=5

Iteration 3
fast=null

Answer = 3

TIME: O(n)
SPACE: O(1)

CODE

class Solution {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}

-------------------------------------------------------------------------------
LEETCODE 141 - LINKED LIST CYCLE
-------------------------------------------------------------------------------

PROBLEM SUMMARY
Check whether cycle exists.

CORE IDEA
Floyd's Algorithm

slow -> 1 step
fast -> 2 steps

If slow == fast
cycle exists.

DRY RUN

1 -> 2 -> 3 -> 4
     ^         |
     |_________|

Iteration 1
slow=2
fast=3

Iteration 2
slow=3
fast=2

Iteration 3
slow=4
fast=4

slow == fast

Answer = true

TIME: O(n)
SPACE: O(1)

CODE

class Solution {
    public boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }
}

-------------------------------------------------------------------------------
LEETCODE 142 - LINKED LIST CYCLE II
-------------------------------------------------------------------------------

PROBLEM SUMMARY
Return node where cycle starts.

CORE IDEA

PHASE 1
Detect cycle using slow and fast.

PHASE 2
Put ptr at head.

Move:
ptr  -> 1 step
slow -> 1 step

Where they meet:
Cycle start.

DRY RUN

3 -> 2 -> 0 -> -4
     ^         |
     |_________|

Cycle starts at node 2

PHASE 1

slow=3
fast=3

Iteration 1
slow=2
fast=0

Iteration 2
slow=0
fast=2

Iteration 3
slow=-4
fast=-4

Meeting point found.

PHASE 2

ptr=3
slow=-4

Move once

ptr=2
slow=2

Meet at 2

Answer = node 2

TIME: O(n)
SPACE: O(1)

CODE

class Solution {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = head;

        while(fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }
        }

        if(fast == null || fast.next == null){
            return null;
        }

        while(ptr != slow){
            ptr = ptr.next;
            slow = slow.next;
        }

        return ptr;
    }
}

-------------------------------------------------------------------------------
IMPORTANT INTERVIEW PATTERNS
-------------------------------------------------------------------------------

1. Fast and Slow Pointer
   - Middle of Linked List
   - Linked List Cycle
   - Linked List Cycle II

2. Pointer Manipulation
   - Remove Duplicates
   - Reverse Linked List
   - Merge Two Sorted Lists

3. Floyd's Cycle Detection
   - Detect cycle
   - Find cycle start

