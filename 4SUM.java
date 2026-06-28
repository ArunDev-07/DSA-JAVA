# 4SUM

===============================================================================

Platform  : LeetCode (18)
Approach  : Sorting + Two Loops + Two Pointers
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given an array nums and an integer target.

Return all unique quadruplets:

```
nums[i] + nums[j] + nums[left] + nums[right] = target
```

No duplicate quadruplets are allowed.

===============================================================================
EXAMPLE
=======

Input:

nums = [1,0,-1,0,-2,2]

target = 0

Sorted:

[-2,-1,0,0,1,2]

Output:

[
[-2,-1,1,2],
[-2,0,0,2],
[-1,0,0,1]
]

===============================================================================
CORE IDEA
=========

4Sum is an extension of 3Sum.

3Sum:

```
Fix 1 number
Use Two Pointers
```

4Sum:

```
Fix 2 numbers
Use Two Pointers
```

Steps:

1. Sort the array.
2. Fix first number (i).
3. Fix second number (j).
4. Use left and right pointers.
5. Skip duplicates.

===============================================================================
WHY SORTING?
============

Sorting helps us decide pointer movement.

If sum < target:

```
Move left forward.
```

If sum > target:

```
Move right backward.
```

===============================================================================
ALGORITHM
=========

1. Sort the array.

2. Loop through every i.

   Skip duplicate i values.

3. Loop through every j.

   Skip duplicate j values.

4. Initialize:

   left = j + 1

   right = n - 1

5. While left < right:

   sum = nums[i] + nums[j] + nums[left] + nums[right]

   If sum == target:

   Store answer.

   Move both pointers.

   Skip duplicates.

   If sum < target:

   left++

   If sum > target:

   right--

===============================================================================
FULL DRY RUN
============

Input:

nums = [1,0,-1,0,-2,2]

target = 0

Sorted:

[-2,-1,0,0,1,2]

---

i = 0

nums[i] = -2

---

j = 1

nums[j] = -1

left = 2

right = 5

sum = -2 + (-1) + 0 + 2

```
= -1
```

sum < target

left++

---

left = 3

sum = -2 + (-1) + 0 + 2

```
= -1
```

left++

---

left = 4

sum = -2 + (-1) + 1 + 2

```
= 0
```

Found:

[-2,-1,1,2]

Move:

left++

right--

---

j = 2

nums[j] = 0

left = 3

right = 5

sum = -2 + 0 + 0 + 2

```
= 0
```

Found:

[-2,0,0,2]

Move:

left++

right--

---

i = 1

nums[i] = -1

---

j = 2

nums[j] = 0

left = 3

right = 5

sum = -1 + 0 + 0 + 2

```
= 1
```

sum > target

right--

---

right = 4

sum = -1 + 0 + 0 + 1

```
= 0
```

Found:

[-1,0,0,1]

---

Final Answer

[
[-2,-1,1,2],
[-2,0,0,2],
[-1,0,0,1]
]

===============================================================================
DUPLICATE HANDLING
==================

Skip duplicate i:

```java
if(i > 0 && nums[i] == nums[i - 1]) continue;
```

Skip duplicate j:

```java
if(j > i + 1 && nums[j] == nums[j - 1]) continue;
```

Skip duplicate left:

```java
while(left < right && nums[left] == nums[left - 1])
    left++;
```

Skip duplicate right:

```java
while(left < right && nums[right] == nums[right + 1])
    right--;
```

===============================================================================
WHY LONG?
=========

Use:

```java
long sum
```

Instead of:

```java
int sum
```

Because values can be large.

Example:

```text
1000000000 + 1000000000 + 1000000000 + 1000000000
```

This exceeds int range.

===============================================================================
TIME COMPLEXITY
===============

Sorting:

O(n log n)

Outer Loop:

O(n)

Inner Loop:

O(n)

Two Pointers:

O(n)

Total:

O(n³)

===============================================================================
SPACE COMPLEXITY
================

O(1)

Ignoring output list.

===============================================================================
PATTERN LEARNED
===============

Sorting + Two Pointers

Relationship:

2Sum

```
Two Pointers
```

3Sum

```
One Loop + Two Pointers
```

4Sum

```
Two Loops + Two Pointers
```

KSum

```
Fix numbers recursively
Eventually reduce to 2Sum
```

===============================================================================
JAVA CODE
=========

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0; i < n - 3; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n - 2; j++) {

                if(j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                while(left < right) {

                    long sum = (long) nums[i]
                             + nums[j]
                             + nums[left]
                             + nums[right];

                    if(sum == target) {

                        res.add(Arrays.asList(
                            nums[i],
                            nums[j],
                            nums[left],
                            nums[right]
                        ));

                        left++;
                        right--;

                        while(left < right &&
                              nums[left] == nums[left - 1])
                            left++;

                        while(left < right &&
                              nums[right] == nums[right + 1])
                            right--;

                    } else if(sum < target) {

                        left++;

                    } else {

                        right--;
                    }
                }
            }
        }

        return res;
    }
}
```

===============================================================================
