import java.util.*;

// LeetCode: Find All Duplicates in an Array
class Solution {

    public List<Integer> findDuplicates(int[] nums) {

        /*
        ============================================================
        PARAGRAPH EXPLANATION:
        ============================================================
        This is the optimal solution for finding duplicates in the array.

        Why is it optimal?
        - Time Complexity  : O(n)
        - Extra Space      : O(1)  (excluding the output list)

        Main idea:
        The problem guarantees that every number is in the range 1 to n,
        where n = nums.length.

        That means:
        number 1 belongs to index 0
        number 2 belongs to index 1
        number 3 belongs to index 2
        ...
        number x belongs to index x - 1

        We use this property to mark whether a number has been seen before.

        How?
        - For each number, calculate its correct index using:
              index = abs(nums[i]) - 1
        - Then check nums[index]:
              if nums[index] is positive:
                    mark it negative -> means "seen once"
              if nums[index] is already negative:
                    it means the number came before -> duplicate found

        Important:
        We use Math.abs(nums[i]) because some numbers may already have been
        turned negative during previous steps.

        Example:
        nums = [4,3,2,7,8,2,3,1]

        duplicate numbers are 2 and 3
        ============================================================
        */

        // Create a list to store duplicate numbers.
        List<Integer> list = new ArrayList<>();

        // Traverse the array from index 0 to last index.
        for (int i = 0; i < nums.length; i++) {

            /*
            ------------------------------------------------------------
            LINE EXPLANATION:
            ------------------------------------------------------------
            Math.abs(nums[i])
            - Gives the actual value even if nums[i] became negative earlier.

            Why subtract 1?
            - Because values are from 1 to n
            - But array index is from 0 to n-1

            So:
            value 1 -> index 0
            value 2 -> index 1
            value 3 -> index 2
            ...
            */
            int index = Math.abs(nums[i]) - 1;

            /*
            ------------------------------------------------------------
            LINE EXPLANATION:
            ------------------------------------------------------------
            If nums[index] is already negative,
            it means we have already visited this number before.

            So current number is a duplicate.
            */
            if (nums[index] < 0) {

                /*
                --------------------------------------------------------
                LINE EXPLANATION:
                --------------------------------------------------------
                Add the duplicate number to the result list.

                We add Math.abs(nums[i]) and NOT nums[index]
                because nums[i] represents the current number we are processing.
                nums[index] is only the marking location.
                */
                list.add(Math.abs(nums[i]));

            } else {

                /*
                --------------------------------------------------------
                LINE EXPLANATION:
                --------------------------------------------------------
                If nums[index] is positive, it means this number is being
                seen for the first time.

                So we mark it as visited by making it negative.
                */
                nums[index] = -nums[index];
            }
        }

        // Return the final list of duplicates.
        return list;
    }
}

/*
====================================================================
DRY RUN WITH VISUAL EXAMPLE
====================================================================

Input:
nums = [4, 3, 2, 7, 8, 2, 3, 1]

Result list initially:
list = []

--------------------------------------------------------------------
STEP 1:
i = 0
nums[i] = 4

index = abs(4) - 1 = 3

Check nums[3]:
nums[3] = 7  (positive)

So mark it negative.

Array becomes:
[4, 3, 2, -7, 8, 2, 3, 1]

Visual:
value = 4
go to index 3
mark visited

--------------------------------------------------------------------
STEP 2:
i = 1
nums[i] = 3

index = abs(3) - 1 = 2

Check nums[2]:
nums[2] = 2  (positive)

Mark it negative.

Array becomes:
[4, 3, -2, -7, 8, 2, 3, 1]

Visual:
value = 3
go to index 2
mark visited

--------------------------------------------------------------------
STEP 3:
i = 2
nums[i] = -2

index = abs(-2) - 1 = 1

Check nums[1]:
nums[1] = 3  (positive)

Mark it negative.

Array becomes:
[4, -3, -2, -7, 8, 2, 3, 1]

Visual:
value = 2
go to index 1
mark visited

--------------------------------------------------------------------
STEP 4:
i = 3
nums[i] = -7

index = abs(-7) - 1 = 6

Check nums[6]:
nums[6] = 3  (positive)

Mark it negative.

Array becomes:
[4, -3, -2, -7, 8, 2, -3, 1]

Visual:
value = 7
go to index 6
mark visited

--------------------------------------------------------------------
STEP 5:
i = 4
nums[i] = 8

index = abs(8) - 1 = 7

Check nums[7]:
nums[7] = 1  (positive)

Mark it negative.

Array becomes:
[4, -3, -2, -7, 8, 2, -3, -1]

Visual:
value = 8
go to index 7
mark visited

--------------------------------------------------------------------
STEP 6:
i = 5
nums[i] = 2

index = abs(2) - 1 = 1

Check nums[1]:
nums[1] = -3  (already negative)

That means 2 was already seen before.
So 2 is a duplicate.

list = [2]

Array remains:
[4, -3, -2, -7, 8, 2, -3, -1]

Visual:
value = 2
go to index 1
already negative -> duplicate found

--------------------------------------------------------------------
STEP 7:
i = 6
nums[i] = -3

index = abs(-3) - 1 = 2

Check nums[2]:
nums[2] = -2  (already negative)

That means 3 was already seen before.
So 3 is a duplicate.

list = [2, 3]

Visual:
value = 3
go to index 2
already negative -> duplicate found

--------------------------------------------------------------------
STEP 8:
i = 7
nums[i] = -1

index = abs(-1) - 1 = 0

Check nums[0]:
nums[0] = 4  (positive)

Mark it negative.

Array becomes:
[-4, -3, -2, -7, 8, 2, -3, -1]

--------------------------------------------------------------------
FINAL ANSWER:
list = [2, 3]

====================================================================
SHORT VISUAL LOGIC
====================================================================

Number -> Target Index

1 -> 0
2 -> 1
3 -> 2
4 -> 3
5 -> 4
6 -> 5
7 -> 6
8 -> 7

Whenever a number comes:
1. Go to its target index
2. If value there is positive -> mark negative
3. If value there is already negative -> duplicate found

====================================================================
WHY Math.abs(nums[i]) IS NEEDED
====================================================================

During traversal, many elements become negative.

Example:
nums[i] may become -3

But actual value is still 3

So:
Math.abs(-3) = 3

Without abs, index calculation becomes wrong.

====================================================================
TIME AND SPACE COMPLEXITY
====================================================================

Time Complexity:
O(n)
Because we traverse the array only once.

Space Complexity:
O(1)
Because we do not use any extra array or hash map.
Only the output list is used.

====================================================================
IMPORTANT NOTE
====================================================================

This solution modifies the original array.
So use this only when modifying the input array is allowed.

====================================================================
INTERVIEW ONE-PARAGRAPH EXPLANATION
====================================================================

Since the array contains numbers from 1 to n, every number can be mapped
to an index using value - 1. I use the input array itself as a visited
marker. For each number, I check its mapped index. If the value at that
index is positive, I mark it negative to indicate that the number has
been seen once. If it is already negative, it means the number has
already appeared before, so it is a duplicate. This gives O(n) time
and O(1) extra space.
====================================================================
*/
