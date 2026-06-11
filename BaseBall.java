/*
===============================================================================
                              BASEBALL GAME
===============================================================================

Platform  : LeetCode (682)
Approach  : Stack
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Calculate score using operations:

Integer -> Add score

"+" -> Sum previous two scores

"D" -> Double previous score

"C" -> Remove previous score

===============================================================================
CORE IDEA
===============================================================================

Need quick access to latest scores.

Stack perfectly matches requirement.

Operations:

"+" -> Current score = previous score + second previous score

"D" -> Double previous score

"C" -> Remove previous score

===============================================================================
WHY STACK?
===============================================================================

Need access to most recent score.

Stack provides:

push() -> O(1)
pop()  -> O(1)
peek() -> O(1)

===============================================================================
TIME COMPLEXITY
===============================================================================

O(n)

Each operation processed once.

===============================================================================
SPACE COMPLEXITY
===============================================================================

O(n)

Stack stores valid scores.

===============================================================================
DRY RUN
===============================================================================

Input:

["5","2","C","D","+"]

Stack:

[]

----------------------------------

"5"

Push 5

[5]

----------------------------------

"2"

Push 2

[5,2]

----------------------------------

"C"

Remove 2

[5]

----------------------------------

"D"

Push 10

[5,10]

----------------------------------

"+"

10 + 5 = 15

[5,10,15]

Sum:

5 + 10 + 15 = 30

===============================================================================
PATTERN LEARNED
===============================================================================

Stack Simulation

Used in:

- Undo Operations
- Browser History
- Expression Evaluation

===============================================================================
*/

import java.util.*;

class Solution {

    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for (String op : ops) {

            if (op.equals("+")) {

                int top = stack.pop();
                int sum = top + stack.peek();

                stack.push(top);
                stack.push(sum);

            } else if (op.equals("D")) {

                stack.push(2 * stack.peek());

            } else if (op.equals("C")) {

                stack.pop();

            } else {

                stack.push(Integer.parseInt(op));
            }
        }

        int score = 0;

        for (int num : stack) {
            score += num;
        }

        return score;
    }
}
