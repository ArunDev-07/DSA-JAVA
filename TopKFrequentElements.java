/*
===============================================================================
                          TOP K FREQUENT ELEMENTS
===============================================================================

Platform  : LeetCode (347)
Approach  : HashMap + Sorting
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============================================================================

Given an integer array nums and an integer k.

Return the k most frequent elements.

You may return the answer in any order.

===============================================================================
EXAMPLE
===============================================================================

Input:

nums = [1,1,1,2,2,3]

k = 2

Output:

[1,2]

Reason:

Frequency:

1 -> 3 times

2 -> 2 times

3 -> 1 time

Top 2 frequent elements:

[1,2]

===============================================================================
CORE IDEA
===============================================================================

Step 1:

Count frequency of every number.

-------------------------------------------------------------------------------

Step 2:

Store unique numbers in a list.

-------------------------------------------------------------------------------

Step 3:

Sort the numbers based on frequency.

Higher frequency comes first.

-------------------------------------------------------------------------------

Step 4:

Take first k elements.

===============================================================================
DATA STRUCTURE USED
===============================================================================

HashMap<Integer, ArrayList<Integer>>

Stores:

Number -> List of Occurrences

Example:

nums = [1,1,1,2,2,3]

Map:

1 -> [1,1,1]

2 -> [2,2]

3 -> [3]

Frequency:

size of list

===============================================================================
FULL DRY RUN
===============================================================================

nums:

[1,1,1,2,2,3]

k = 2

-------------------------------------------------------------------------------

Build HashMap

1 -> [1,1,1]

2 -> [2,2]

3 -> [3]

-------------------------------------------------------------------------------

Keys

[1,2,3]

-------------------------------------------------------------------------------

Sort Descending by Frequency

Before:

[1,2,3]

Frequencies:

1 -> 3

2 -> 2

3 -> 1

-------------------------------------------------------------------------------

After Sorting

[1,2,3]

-------------------------------------------------------------------------------

Take First k Elements

k = 2

ans[0] = 1

ans[1] = 2

-------------------------------------------------------------------------------

Result

[1,2]

===============================================================================
VISUALIZATION
===============================================================================

Frequency Table

1 → 3

2 → 2

3 → 1

-------------------------------------------------------------------------------

Sorted By Frequency

1 → 3

2 → 2

3 → 1

-------------------------------------------------------------------------------

Top 2

[1,2]

===============================================================================
TIME COMPLEXITY
===============================================================================

Building HashMap:

O(n)

-------------------------------------------------------------------------------

Sorting Keys:

O(m log m)

m = Unique Elements

-------------------------------------------------------------------------------

Total:

O(n + m log m)

Worst Case:

O(n log n)

===============================================================================
SPACE COMPLEXITY
===============================================================================

HashMap:

O(m)

Result Array:

O(k)

Total:

O(m)

===============================================================================
PATTERN LEARNED
===============================================================================

Frequency Counting

HashMap

Custom Sorting

Used In:

- Top K Frequent Elements
- Frequency Sort
- Group Anagrams
- Majority Element
- Character Frequency Problems

===============================================================================
INTERVIEW NOTE
===============================================================================

Your solution works correctly.

However, it stores:

1 -> [1,1,1]

2 -> [2,2]

3 -> [3]

which uses extra memory.

Most optimized solutions use:

HashMap<Integer,Integer>

Example:

1 -> 3

2 -> 2

3 -> 1

This reduces space usage.

===============================================================================
*/

class Solution {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        // Build Frequency Map
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            if (!map.containsKey(num)) {
                map.put(num, new ArrayList<>());
            }

            map.get(num).add(num);
        }

        // Get Unique Keys
        ArrayList<Integer> keys = new ArrayList<>(map.keySet());

        // Sort by Frequency Descending
        Collections.sort(keys,
                (a, b) -> map.get(b).size() - map.get(a).size());

        // Take First K Elements
        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = keys.get(i);
        }

        return ans;
    }
}
