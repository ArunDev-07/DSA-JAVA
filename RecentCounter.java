/*
===============================================================================
                              RECENT COUNTER
===============================================================================

Platform  : LeetCode (933)
Approach  : Queue
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Implement a counter that returns the number of requests received in the
last 3000 milliseconds.

For every ping(t):

Count requests in:

    [t - 3000, t]

===============================================================================
CORE IDEA
===============================================================================

Store all timestamps in a Queue.

For every new request:

1. Add current timestamp.
2. Remove timestamps outside the valid range.
3. Queue size becomes the answer.

===============================================================================
WHY QUEUE?
===============================================================================

Requests arrive in increasing order.

Oldest request is always at the front.

Queue operations:

offer() -> O(1)
poll()  -> O(1)
peek()  -> O(1)

===============================================================================
TIME COMPLEXITY
===============================================================================

ping() : O(1) amortized

Each timestamp:
    Added once
    Removed once

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(n)

===============================================================================
DRY RUN
===============================================================================

ping(1)

Queue:
[1]

Answer = 1

----------------------------------

ping(100)

Queue:
[1,100]

Answer = 2

----------------------------------

ping(3001)

Valid Range:

[1,3001]

Queue:
[1,100,3001]

Answer = 3

----------------------------------

ping(3002)

Add:

[1,100,3001,3002]

Valid Range:

[2,3002]

Remove 1

Queue:
[100,3001,3002]

Answer = 3

===============================================================================
PATTERN LEARNED
===============================================================================

Queue

Maintaining Valid Elements

Sliding Window Intuition

===============================================================================
*/

import java.util.*;

class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    public int ping(int t) {

        queue.offer(t);

        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }
}
