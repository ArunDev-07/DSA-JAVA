# INTERVAL MASTER FILE (GREEDY + BINARY SEARCH PATTERN)

===============================================================================
PATTERN FAMILY
==============

All these problems use:

👉 Sorting intervals
👉 Greedy decisions
👉 Overlap detection logic

Key idea:

```
Compare interval start vs previous end
```

===============================================================================

1. LEETCODE 57 - INSERT INTERVAL
   ===============================================================================
   Entity: Insert Interval

---

## PROBLEM

Insert a new interval into sorted non-overlapping intervals and merge if needed.

---

## CODE

```java id="ins_all_57"
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;

        // 1. add left side
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. merge overlaps
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        result.add(newInterval);

        // 3. add right side
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
```

---

## DRY RUN

Input:

```
[[1,2],[3,5],[6,7],[8,10],[12,16]]
new = [4,8]
```

Step 1 (left):

* [1,2] added

Step 2 (merge):

* [3,5] → [3,8]
* [6,7] → [3,8]
* [8,10] → [3,10]

Step 3 (right):

* [12,16] added

Output:

```
[[1,2],[3,10],[12,16]]
```

===============================================================================
2. LEETCODE 435 - NON OVERLAPPING INTERVALS
===========================================

Entity: Non-overlapping Intervals

---

## PROBLEM

Remove minimum intervals so that no intervals overlap.

---

## CODE

```java id="non_overlap_435"
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals,
            (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < prevEnd) {
                count++;
            } else {
                prevEnd = intervals[i][1];
            }
        }

        return count;
    }
}
```

---

## DRY RUN

Input:

```
[[1,2],[2,3],[3,4],[1,3]]
```

Sorted:

```
[1,2]
[2,3]
[1,3]
[3,4]
```

Steps:

* prevEnd = 2
* [2,3] → ok → prevEnd = 3
* [1,3] → overlap → remove++
* [3,4] → ok → prevEnd = 4

Output:

```
1
```

===============================================================================
3. LEETCODE 452 - MINIMUM ARROWS TO BURST BALLOONS
==================================================

Entity: Minimum Number of Arrows to Burst Balloons

---

## PROBLEM

Find minimum arrows to burst all overlapping balloons.

---

## CODE

```java id="arrow_452_all"
class Solution {
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points,
            (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {

            if (points[i][0] > end) {
                arrows++;
                end = points[i][1];
            }
        }

        return arrows;
    }
}
```

---

## DRY RUN

Input:

```
[[1,6],[2,8],[7,12],[10,16]]
```

Sorted:

```
[1,6]
[2,8]
[7,12]
[10,16]
```

Steps:

* arrows = 1, end = 6
* [2,8] → overlap → same arrow
* [7,12] → new arrow = 2, end = 12
* [10,16] → overlap

Output:

```
2
```

===============================================================================
MASTER PATTERN
==============

INSERT INTERVAL:
→ build result (left + merge + right)

435:
→ remove overlaps

452:
→ count arrows

===============================================================================
ONE-LINE MEMORY TRICK
=====================

Insert → build
435    → remove overlaps
452    → merge into arrows
