/*
===============================================================================
                           LAST STONE WEIGHT
===============================================================================

Platform  : LeetCode 1046
Approach  : Max Heap (Priority Queue)
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

You are given an array of stone weights.

Each turn:

1) Remove the two heaviest stones (x and y)
   where x <= y

2) Smash them together

Rules:

If x == y
    Both stones are destroyed

If x != y
    New stone = y - x

Return the weight of the last remaining stone.
If no stones remain, return 0.

===============================================================================
CORE IDEA
===============================================================================

We repeatedly need:

- Largest stone
- Second largest stone

A Max Heap allows us to get both efficiently.

Process:

1) Insert all stones into Max Heap
2) Remove two largest stones
3) Smash them
4) Insert remaining stone (if any)
5) Continue until <= 1 stone remains

===============================================================================
WHY MAX HEAP?
===============================================================================

Example:

    [2,7,4,1,8,1]

Need:

    8 and 7
    then
    4 and 2
    then
    2 and 1

We always need the largest elements.

Max Heap provides:

    poll() -> largest element

in O(log n) time.

===============================================================================
DRY RUN
===============================================================================

Input:

    [2,7,4,1,8,1]

Max Heap:

    [8,7,4,2,1,1]

---------------------------------------------------------

Take:

    8 and 7

Smash:

    8 - 7 = 1

Heap:

    [4,2,1,1,1]

---------------------------------------------------------

Take:

    4 and 2

Smash:

    4 - 2 = 2

Heap:

    [2,1,1,1]

---------------------------------------------------------

Take:

    2 and 1

Smash:

    2 - 1 = 1

Heap:

    [1,1,1]

---------------------------------------------------------

Take:

    1 and 1

Smash:

    destroyed

Heap:

    [1]

---------------------------------------------------------

Answer:

    1

===============================================================================
TIME COMPLEXITY
===============================================================================

Building Heap:

    O(n log n)

Each smash operation:

    poll() + poll() + offer()

    O(log n)

Total:

    O(n log n)

===============================================================================
SPACE COMPLEXITY
===============================================================================

Heap Storage:

    O(n)

===============================================================================
PATTERN LEARNED
===============================================================================

Heap / Priority Queue

Use Heap when:

- Largest element repeatedly needed
- Smallest element repeatedly needed
- Top K problems
- Scheduling problems
- Stream processing

===============================================================================
CODE
===============================================================================
*/

class Solution {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxheap =
                new PriorityQueue<>((a, b) -> b - a);

        // Insert all stones
        for (int num : stones) {
            maxheap.offer(num);
        }

        // Smash until at most one stone remains
        while (maxheap.size() >= 2) {

            int y = maxheap.poll(); // largest
            int x = maxheap.poll(); // second largest

            if (x == y) {
                continue;
            } else if (x > y) {
                maxheap.offer(x - y);
            } else {
                maxheap.offer(y - x);
            }
        }

        return maxheap.isEmpty() ? 0 : maxheap.poll();
    }
}
