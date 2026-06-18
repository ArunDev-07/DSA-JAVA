/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */

class Solution {

    /*
    ============================================================
    LEETCODE 92 : Reverse Linked List II
    ============================================================

    Reverse nodes from position left to right.

    Example:

        head = 1 -> 2 -> 3 -> 4 -> 5

        left = 2
        right = 4

    Expected:

        1 -> 4 -> 3 -> 2 -> 5

    ============================================================
    🧠 IDEA : HEAD INSERTION TECHNIQUE
    ============================================================

    We do NOT reverse the entire list.

    Step 1:
        Move prev to node BEFORE left.

    Step 2:
        curr = first node of reversal section.

    Step 3:
        Keep taking curr.next and move it
        immediately after prev.

    ============================================================
    🔥 DRY RUN
    ============================================================

    Input:

        1 -> 2 -> 3 -> 4 -> 5

        left = 2
        right = 4

    ------------------------------------------------------------
    STEP 1 : Create Dummy
    ------------------------------------------------------------

        dummy -> 1 -> 2 -> 3 -> 4 -> 5

    ------------------------------------------------------------
    STEP 2 : Move prev before left
    ------------------------------------------------------------

        dummy -> 1 -> 2 -> 3 -> 4 -> 5
                 ^
                prev

    curr = prev.next

        dummy -> 1 -> 2 -> 3 -> 4 -> 5
                 ^    ^
               prev  curr

    ============================================================
    ITERATION 1
    ============================================================

    Current List:

        1 -> 2 -> 3 -> 4 -> 5

    next = curr.next

        next = 3

    ------------------------------------------------------------
    Remove 3
    ------------------------------------------------------------

    curr.next = next.next

        1 -> 2 -> 4 -> 5

    Visual:

        dummy -> 1 -> 2 -> 4 -> 5
                         ^
                        curr

        3 is detached

    ------------------------------------------------------------
    Insert 3 after prev
    ------------------------------------------------------------

    next.next = prev.next

        3 -> 2

    prev.next = next

    Result:

        1 -> 3 -> 2 -> 4 -> 5

    Visual:

        dummy -> 1 -> 3 -> 2 -> 4 -> 5
                 ^    ^
               prev  curr

    ============================================================
    ITERATION 2
    ============================================================

    Current List:

        1 -> 3 -> 2 -> 4 -> 5

    next = curr.next

        next = 4

    ------------------------------------------------------------
    Remove 4
    ------------------------------------------------------------

    curr.next = next.next

        1 -> 3 -> 2 -> 5

    Visual:

        dummy -> 1 -> 3 -> 2 -> 5
                              ^
                            curr

    ------------------------------------------------------------
    Insert 4 after prev
    ------------------------------------------------------------

    next.next = prev.next

        4 -> 3

    prev.next = next

    Result:

        1 -> 4 -> 3 -> 2 -> 5

    ============================================================
    FINAL ANSWER
    ============================================================

        1 -> 4 -> 3 -> 2 -> 5

    ============================================================
    🧠 WHY LOOP RUNS (right - left) TIMES ?
    ============================================================

    left = 2
    right = 4

    Nodes to reverse:

        2 -> 3 -> 4

    First node (2) stays as curr.

    We only need to move:

        3
        4

    Total moves:

        right - left
        = 4 - 2
        = 2

    ============================================================
    🎯 PATTERN
    ============================================================

    Reverse Entire List:
        prev, curr, next

    Reverse Partial List:
        Dummy
        +
        prev before left
        +
        Head Insertion Technique

    ============================================================
    TIME COMPLEXITY
    ============================================================

        O(n)

    ============================================================
    SPACE COMPLEXITY
    ============================================================

        O(1)

    ============================================================
    MEMORY TRICK
    ============================================================

    Keep curr fixed.

    Take curr.next.

    Insert it after prev.

    Repeat until right position reached.

    ============================================================
    */

    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Move prev before left position
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // First node of reversing section
        ListNode curr = prev.next;

        // Head Insertion Technique
        for (int i = 0; i < right - left; i++) {

            ListNode next = curr.next;

            curr.next = next.next;

            next.next = prev.next;

            prev.next = next;
        }

        return dummy.next;
    }
}
