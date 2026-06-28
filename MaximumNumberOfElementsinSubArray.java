# FIND THE MAXIMUM NUMBER OF ELEMENTS IN SUBSET

===============================================================================

Platform  : LeetCode (3020)
Approach  : HashMap + Frequency Counting
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given an array nums.

Build the longest subset:

x, x², x⁴, x⁸ ...

Each intermediate value must appear at least twice.

The last value may appear once.

Return maximum possible length.

===============================================================================
EXAMPLE
=======

Input:

[5,4,1,2,2]

Frequency Map:

1 -> 1
2 -> 2
4 -> 1
5 -> 1

Output:

3

Subset:

[2,4,2]

Length = 3

===============================================================================
CORE IDEA
=========

1. Count frequency of every number.
2. Start from each unique value.
3. Repeatedly square the current number.
4. Every intermediate value must occur at least twice.
5. Last value can occur once.

===============================================================================
WHY HASHMAP?
============

Need O(1) lookup.

Check quickly:

Does current value exist?

How many times does it occur?

===============================================================================
ALGORITHM
=========

1. Build frequency map.

2. Handle value 1 separately.

3. For every unique number:

   count = 0

   curr = number

4. While:

   curr exists
   and frequency > 1

   count += 2

   curr = curr * curr

5. Final length:

   if curr exists:
   count + 1

   else:
   count - 1

6. Track maximum answer.

===============================================================================
FULL DRY RUN
============

Input:

[5,4,1,2,2]

Frequency Map:

1 -> 1
2 -> 2
4 -> 1
5 -> 1

---

Start = 2

count = 0

curr = 2

freq(2) = 2

count = 2

curr = 4

---

freq(4) = 1

Loop stops

---

4 exists

Length:

count + 1

= 2 + 1

= 3

---

Start = 5

freq(5) = 1

Length = 1

---

Maximum Length:

3

===============================================================================
SPECIAL CASE OF 1
=================

1² = 1

Infinite squaring.

Example:

[1,1,1,1,1]

Maximum odd length:

5

Example:

[1,1,1,1]

Maximum odd length:

3

Formula:

if count of 1 is odd:
use all

if count of 1 is even:
use count - 1

===============================================================================
TIME COMPLEXITY
===============

O(n)

HashMap operations are O(1).

===============================================================================
SPACE COMPLEXITY
================

O(n)

Frequency map stores unique values.

===============================================================================
PATTERN LEARNED
===============

HashMap Frequency Counting

Used In:

* Frequency Problems
* Longest Chains
* Counting Occurrences
* Number Transformation Problems

===============================================================================
