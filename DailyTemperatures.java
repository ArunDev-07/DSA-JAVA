/*
===============================================================================
                           DAILY TEMPERATURES
===============================================================================

Platform  : LeetCode (739)
Approach  : Monotonic Stack
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

For each day, determine how many days must pass until a warmer temperature.

If no warmer day exists:

Return 0.

===============================================================================
CORE IDEA
===============================================================================

Use a Monotonic Decreasing Stack.

Store indices instead of temperatures.

Whenever a warmer temperature is found:

Resolve previous colder days.

===============================================================================
WHY STORE INDICES?
===============================================================================

Need distance:

currentIndex - previousIndex

Example:

73 74

Distance:

1 day

Indices help calculate this directly.

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

Each index:

Pushed once
Popped once

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(n)

===============================================================================
DRY RUN
===============================================================================

Input:

[73,74,75,71]

Stack:

[]

----------------------------------

73

Push index 0

Stack:

[0]

----------------------------------

74

74 > 73

Pop 0

result[0] = 1

Push 1

Stack:

[1]

----------------------------------

75

75 > 74

Pop 1

result[1] = 1

Push 2

Stack:

[2]

----------------------------------

71

71 < 75

Push 3

Stack:

[2,3]

===============================================================================
PATTERN LEARNED
===============================================================================

Monotonic Stack

Used In:

- Next Greater Element
- Stock Span
- Largest Rectangle Histogram
- Daily Temperatures

===============================================================================
*/

import java.util.*;

class Solution {

    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> stack = new Stack<>();

        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty()
                    && temperatures[i] > temperatures[stack.peek()]) {

                int previousIndex = stack.pop();

                result[previousIndex] = i - previousIndex;
            }

            stack.push(i);
        }

        return result;
    }
}
