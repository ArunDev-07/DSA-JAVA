# Binary Search on Answer - Revision Notes

===============================================================================
LEETCODE 875 - KOKO EATING BANANAS
==================================

Pattern:
Binary Search on Answer

Difficulty:
Medium

---

## PROBLEM

Given:

piles[] = bananas in each pile

h = total hours

Find the minimum eating speed k such that Koko can finish all bananas within h
hours.

---

## CORE IDEA

Instead of searching for the answer directly:

Ask:

"Can Koko finish within h hours if her speed is mid bananas/hour?"

If yes:
Try smaller speed.

If no:
Need larger speed.

---

## SEARCH SPACE

Minimum Speed:

1

Maximum Speed:

max(piles)

---

## VISUALIZATION

Speed

1 2 3 4 5 6 7 8 9 10

F F F F T T T T T T

```
    ^
 First True
```

---

## DRY RUN

piles = [3,6,7,11]

h = 8

low = 1

high = 11

mid = 6

Hours:

3 -> 1

6 -> 1

7 -> 2

11 -> 2

Total = 6

6 <= 8

Possible

high = 6

Eventually:

Answer = 4

---

## CODE

```java
class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int p : piles) {
            high = Math.max(high, p);
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            long hours = 0;

            for (int p : piles) {
                hours += (p + mid - 1) / mid;
            }

            if (hours <= h) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
```

Time Complexity:

O(n log(maxPile))

===============================================================================
LEETCODE 1011 - CAPACITY TO SHIP PACKAGES WITHIN D DAYS
=======================================================

Pattern:
Binary Search on Answer

Difficulty:
Medium

---

## PROBLEM

Given:

weights[]

days

Find minimum ship capacity.

---

## CORE IDEA

Ask:

"If ship capacity = mid, can we ship all packages within given days?"

If yes:
Try smaller capacity.

If no:
Need bigger capacity.

---

## SEARCH SPACE

Minimum Capacity:

max(weights)

Maximum Capacity:

sum(weights)

---

## VISUALIZATION

Capacity

10 11 12 13 14 15 16 17

F  F  F  F  F  T  T  T

```
           ^
       First True
```

---

## FULL DRY RUN

weights = [1,2,3,4,5,6,7,8,9,10]

days = 5

low = 10

high = 55

mid = 32

Day 1

1+2+3+4+5+6+7 = 28

Day 2

8+9+10 = 27

Required Days = 2

2 <= 5

Possible

high = 32

---

mid = 21

Day 1

1+2+3+4+5+6 = 21

Day 2

7+8 = 15

Day 3

9+10 = 19

Required Days = 3

Possible

high = 21

---

mid = 15

Day 1

1+2+3+4+5 = 15

Day 2

6+7 = 13

Day 3

8

Day 4

9

Day 5

10

Required Days = 5

Possible

high = 15

---

mid = 12

Required Days = 6

Not Possible

low = 13

---

mid = 14

Required Days = 6

Not Possible

low = 15

---

Answer = 15

---

## CODE

```java
class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canShip(int[] weights,
                            int days,
                            int capacity) {

        int requiredDays = 1;
        int currentLoad = 0;

        for (int w : weights) {

            if (currentLoad + w > capacity) {
                requiredDays++;
                currentLoad = 0;
            }

            currentLoad += w;
        }

        return requiredDays <= days;
    }
}
```

Time Complexity:

O(n log(sum(weights)))

===============================================================================
LEETCODE 1482 - MINIMUM NUMBER OF DAYS TO MAKE M BOUQUETS
=========================================================

Pattern:
Binary Search on Answer

Difficulty:
Medium

---

## PROBLEM

Given:

bloomDay[]

m = bouquets needed

k = flowers per bouquet

Find minimum day needed.

---

## CORE IDEA

Ask:

"If today is day = mid, can we make at least m bouquets?"

If yes:
Try earlier day.

If no:
Need later day.

---

## SEARCH SPACE

Minimum Day:

min(bloomDay)

Maximum Day:

max(bloomDay)

---

## VISUALIZATION

Days

1 2 3 4 5 6 7 8 9 10

F F T T T T T T T T

```
^
```

First True

---

## FULL DRY RUN

bloomDay = [1,10,3,10,2]

m = 3

k = 1

---

mid = 5

[x,*,x,*,x]

Bouquets = 3

3 >= 3

Possible

high = 5

---

mid = 3

[x,*,x,*,x]

Bouquets = 3

Possible

high = 3

---

mid = 2

[x,*,*,_,x]

Bouquets = 2

2 >= 3

False

low = 3

---

Answer = 3

---

## WHY BOUQUETS >= m ?

m = required bouquets

If:

bouquets = 3

Need = 3

Valid

---

If:

bouquets = 5

Need = 3

Still Valid

Because:

If you can make 5 bouquets

You can definitely make 3 bouquets

Therefore:

return bouquets >= m

---

## CODE

```java
class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        if ((long)m * k > bloomDay.length) {
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            low = Math.min(low, day);
            high = Math.max(high, day);
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canBloom(bloomDay, m, k, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean canBloom(int[] bloomDay,
                             int m,
                             int k,
                             int currentDay) {

        int bouquets = 0;
        int consecutive = 0;

        for (int day : bloomDay) {

            if (day <= currentDay) {

                consecutive++;

                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0;
                }

            } else {
                consecutive = 0;
            }
        }

        return bouquets >= m;
    }
}
```

Time Complexity:

O(n log(maxBloomDay))

===============================================================================
MASTER TEMPLATE
===============

1. Find search space

2. Pick mid

3. Write can(mid)

4. If possible

   high = mid

5. Else

   low = mid + 1

6. Answer = low

Pattern:

F F F F T T T T T

```
      ^

  First True
```
