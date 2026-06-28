# 3SUM

===============================================================================

Platform  : LeetCode (15)
Approach  : Sorting + Two Pointers
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given an integer array nums.

Return all unique triplets:

```
nums[i] + nums[j] + nums[k] = 0
```

No duplicate triplets are allowed.

===============================================================================
EXAMPLE
=======

Input:

[-1,0,1,2,-1,-4]

After Sorting:

[-4,-1,-1,0,1,2]

Output:

[
[-1,-1,2],
[-1,0,1]
]

===============================================================================
CORE IDEA
=========

1. Sort the array.
2. Fix one number using i.
3. Use two pointers (left and right).
4. Find pairs that make the total sum 0.
5. Skip duplicates.

===============================================================================
WHY SORTING?
============

Sorting helps us move pointers efficiently.

If sum < 0:
Move left forward.

If sum > 0:
Move right backward.

===============================================================================
ALGORITHM
=========

1. Sort array.

2. For every index i:

   Skip duplicates.

3. Set:

   left = i + 1
   right = n - 1

4. While left < right:

   sum = nums[i] + nums[left] + nums[right]

   If sum == 0:
   Store answer.
   Move both pointers.
   Skip duplicates.

   If sum < 0:
   left++

   If sum > 0:
   right--

===============================================================================
FULL DRY RUN
============

Input:

[-1,0,1,2,-1,-4]

Sorted:

[-4,-1,-1,0,1,2]

---

i = 0

nums[i] = -4

left = 1
right = 5

sum = -4 + (-1) + 2 = -3

sum < 0

left++

---

left = 2

sum = -4 + (-1) + 2 = -3

left++

---

left = 3

sum = -4 + 0 + 2 = -2

left++

---

left = 4

sum = -4 + 1 + 2 = -1

left++

left == right

Stop

No answer

---

i = 1

nums[i] = -1

left = 2
right = 5

sum = -1 + (-1) + 2 = 0

Found:

[-1,-1,2]

Move:

left++
right--

---

left = 3
right = 4

sum = -1 + 0 + 1 = 0

Found:

[-1,0,1]

Move:

left++
right--

Stop

---

i = 2

Duplicate -1

Skip

---

Final Answer:

[
[-1,-1,2],
[-1,0,1]
]

===============================================================================
TIME COMPLEXITY
===============

Sorting : O(n log n)

Two Pointers : O(n²)

Total:

O(n²)

===============================================================================
SPACE COMPLEXITY
================

O(1)

Ignoring output list.

===============================================================================
PATTERN LEARNED
===============

Sorting + Two Pointers

Used In:

* 3Sum
* 4Sum
* Container With Most Water
* Two Sum Sorted Array

===============================================================================
