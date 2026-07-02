# LONGEST INCREASING SUBSEQUENCE (LIS)

===============================================================================

Platform  : LeetCode (300)
Approach  : Dynamic Programming
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given an integer array nums.

Return the length of the Longest Increasing Subsequence.

A subsequence can be formed by deleting some elements without changing the
order of the remaining elements.

An increasing subsequence means:

nums[i1] < nums[i2] < nums[i3] < ...

===============================================================================
EXAMPLE
=======

Input:

[10,9,2,5,3,7,101,18]

Output:

4

One LIS:

2 → 5 → 7 → 101

Another LIS:

2 → 3 → 7 → 18

===============================================================================
CORE IDEA
=========

For every element,

Ask:

"What is the longest increasing subsequence ending at this index?"

Store that answer in DP.

===============================================================================
DP STATE
========

dp[i]

=

Length of the Longest Increasing Subsequence ending at index i.

Example

nums:

10 9 2 5 3 7

dp:

1 1 1 2 2 3

===============================================================================
BASE CASE
=========

Every single element itself is an increasing subsequence.

Therefore

dp[i] = 1

===============================================================================
TRANSITION
==========

For every previous index j

if

nums[j] < nums[i]

then

nums[i] can be appended after nums[j]

So

dp[i]

=

max(dp[i], dp[j] + 1)

===============================================================================
ALGORITHM
=========

1. Create dp array.

2. Fill dp with 1.

3. For every index i

      Check all previous indices j.

4. If nums[j] < nums[i]

      Update

      dp[i] = max(dp[i], dp[j] + 1)

5. Keep track of maximum dp value.

6. Return maximum.

===============================================================================
FULL DRY RUN
============

Input

nums

[10,9,2,5,3,7,101,18]

Initially

dp

[1,1,1,1,1,1,1,1]

maxLen = 1

------------------------------------------------

i = 1

Current = 9

Compare

10

9 > 10 ?

No

Nothing changes

dp

[1,1,1,1,1,1,1,1]

------------------------------------------------

i = 2

Current = 2

Compare

10

2 > 10 ?

No

Compare

9

2 > 9 ?

No

dp

[1,1,1,1,1,1,1,1]

------------------------------------------------

i = 3

Current = 5

Compare

10

No

Compare

9

No

Compare

2

Yes

dp[3]

=

max(1, dp[2]+1)

=

2

dp

[1,1,1,2,1,1,1,1]

Current LIS

2 → 5

maxLen = 2

------------------------------------------------

i = 4

Current = 3

Compare

10

No

9

No

2

Yes

dp[4]

=

2

5

No

dp

[1,1,1,2,2,1,1,1]

Current LIS

2 → 3

------------------------------------------------

i = 5

Current = 7

Compare

10

No

9

No

2

Yes

dp = 2

Compare

5

Yes

dp

=

3

Compare

3

Yes

Still 3

dp

[1,1,1,2,2,3,1,1]

Current LIS

2 → 5 → 7

maxLen = 3

------------------------------------------------

i = 6

Current = 101

Compare

10

dp = 2

9

Still 2

2

Still 2

5

dp = 3

3

Still 3

7

dp = 4

dp

[1,1,1,2,2,3,4,1]

Current LIS

2 → 5 → 7 → 101

maxLen = 4

------------------------------------------------

i = 7

Current = 18

Compare

10

dp = 2

9

Still 2

2

Still 2

5

dp = 3

3

Still 3

7

dp = 4

101

No

dp

[1,1,1,2,2,3,4,4]

Current LIS

2 → 5 → 7 → 18

maxLen = 4

===============================================================================
FINAL DP ARRAY
==============

Index

0 1 2 3 4 5 6 7

Nums

10 9 2 5 3 7 101 18

DP

1 1 1 2 2 3 4 4

Answer

4

===============================================================================
JAVA CODE
=========

```java
class Solution {
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp, 1);

        int maxLen = 1;

        for (int i = 1; i < n; i++) {

            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }

            }

            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }
}
```

===============================================================================
TIME COMPLEXITY
===============

Outer Loop

O(n)

Inner Loop

O(n)

Total

O(n²)

===============================================================================
SPACE COMPLEXITY
================

DP Array

O(n)

===============================================================================
PATTERN LEARNED
===============

Dynamic Programming

State

dp[i]

=

Longest Increasing Subsequence ending at index i.

Transition

dp[i] = max(dp[i], dp[j] + 1)

where

nums[j] < nums[i]

===============================================================================
SIMILAR PROBLEMS
================

• Maximum Length of Pair Chain
• Russian Doll Envelopes
• Number of Longest Increasing Subsequences
• Longest Bitonic Subsequence
• Largest Divisible Subset

===============================================================================
DP THINKING
===========

Question:

"What is the best increasing subsequence that MUST end at index i?"

Answer:

Store it in dp[i].

After computing all dp values,

take the maximum.

===============================================================================
