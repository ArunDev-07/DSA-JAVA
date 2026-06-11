/*
===============================================================================
                      TIME NEEDED TO BUY TICKETS
===============================================================================

Platform  : LeetCode (2073)
Approach  : Simulation + Queue Simulation
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

There are n people standing in a queue.

tickets[i] represents the number of tickets person i wants to buy.

Rules:

1) Front person buys exactly one ticket.
2) If tickets are still needed:
      Person goes back to the queue.
3) Otherwise:
      Person leaves the queue.

Return the time required for person k to finish buying all tickets.

===============================================================================
APPROACH 1 : ARRAY SIMULATION
===============================================================================

Instead of explicitly maintaining a Queue:

Simulate each second using the array.

For every round:

    Traverse all people.

    If a person still needs tickets:

        tickets[i]--
        time++

Continue until person k reaches 0 tickets.

-------------------------------------------------------------------------------
WHY THIS WORKS?
-------------------------------------------------------------------------------

Queue order remains:

0 -> 1 -> 2 -> ... -> n-1

Every complete traversal of the array represents one full rotation
of the queue.

Thus we can simulate the process directly without maintaining
an actual Queue.

-------------------------------------------------------------------------------
TIME COMPLEXITY
-------------------------------------------------------------------------------

O(n * max(tickets))

-------------------------------------------------------------------------------
SPACE COMPLEXITY
-------------------------------------------------------------------------------

O(1)

-------------------------------------------------------------------------------
DRY RUN
-------------------------------------------------------------------------------

Input:

tickets = [2,3,2]
k = 2

time = 0

----------------------------------

Round 1

Person 0:

2 -> 1

time = 1

Person 1:

3 -> 2

time = 2

Person 2:

2 -> 1

time = 3

tickets:

[1,2,1]

----------------------------------

Round 2

Person 0:

1 -> 0

time = 4

Person 1:

2 -> 1

time = 5

Person 2:

1 -> 0

time = 6

Person k finished.

Answer = 6

===============================================================================
APPROACH 2 : QUEUE SIMULATION
===============================================================================

Store indices inside a Queue.

Queue:

[0,1,2,3...]

Front person:

1) Buys one ticket.
2) If tickets remain:
       Move to rear.
3) Otherwise:
       Leave queue.

Stop when person k finishes.

-------------------------------------------------------------------------------
DRY RUN
-------------------------------------------------------------------------------

tickets = [2,3,2]
k = 2

Initial Queue:

[0,1,2]

time = 0

----------------------------------

Poll 0

tickets[0] = 1

Queue:

[1,2,0]

time = 1

----------------------------------

Poll 1

tickets[1] = 2

Queue:

[2,0,1]

time = 2

----------------------------------

Poll 2

tickets[2] = 1

Queue:

[0,1,2]

time = 3

----------------------------------

Poll 0

tickets[0] = 0

Queue:

[1,2]

time = 4

----------------------------------

Poll 1

tickets[1] = 1

Queue:

[2,1]

time = 5

----------------------------------

Poll 2

tickets[2] = 0

time = 6

Person k finished.

Answer = 6

-------------------------------------------------------------------------------
TIME COMPLEXITY
-------------------------------------------------------------------------------

O(total tickets)

-------------------------------------------------------------------------------
SPACE COMPLEXITY
-------------------------------------------------------------------------------

O(n)

===============================================================================
PATTERN LEARNED
===============================================================================

Simulation

Queue Simulation

Used In:

- Round Robin Scheduling
- Ticket Systems
- Process Scheduling
- CPU Scheduling
- Customer Service Queues

===============================================================================
*/


// ============================================================================
// APPROACH 1 : ARRAY SIMULATION
// ============================================================================

class Solution {

    public int timeRequiredToBuy(int[] arr, int k) {

        int count = 0;

        while (arr[k] != 0) {

            for (int i = 0; i < arr.length; i++) {

                if (arr[i] > 0) {

                    arr[i]--;

                    count++;

                    if (arr[i] == 0 && i == k) {
                        return count;
                    }
                }
            }
        }

        return count;
    }
}


// ============================================================================
// APPROACH 2 : QUEUE SIMULATION
// ============================================================================

import java.util.*;

class QueueSolution {

    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }

        int time = 0;

        while (!queue.isEmpty()) {

            int person = queue.poll();

            tickets[person]--;

            time++;

            if (tickets[person] > 0) {
                queue.offer(person);
            }

            if (person == k && tickets[person] == 0) {
                return time;
            }
        }

        return time;
    }
}
