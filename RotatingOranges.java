class Solution {

    /*
    ============================================================
                    ROTTING ORANGES (LEETCODE 994)
    ============================================================

    PATTERN:
        BFS (Multi-source level order traversal)

    IDEA:
        - All rotten oranges start spreading at same time
        - Each BFS level = 1 minute
        - Spread in 4 directions

    ============================================================
                    🔥 DRY RUN (VISUAL EXAMPLE)
    ============================================================

    INPUT:
        2 1 1
        1 1 0
        0 1 1

    Legend:
        0 = empty
        1 = fresh
        2 = rotten

    ------------------------------------------------------------
    INITIAL STATE
    ------------------------------------------------------------

    Grid:
        2 1 1
        1 1 0
        0 1 1

    Queue (rotten sources):
        (0,0)

    Fresh count:
        6

    Minutes:
        0

    ============================================================
    MINUTE 1 (BFS LEVEL 1)
    ============================================================

    Process (0,0)

    Spread to:
        (1,0) → fresh → rot
        (0,1) → fresh → rot

    Grid becomes:
        2 2 1
        2 1 0
        0 1 1

    Queue:
        (1,0), (0,1)

    Fresh:
        4

    Minutes:
        1

    ============================================================
    MINUTE 2 (BFS LEVEL 2)
    ============================================================

    Process:
        (1,0), (0,1)

    From (1,0):
        (1,1) → rot

    From (0,1):
        (0,2) → rot

    Grid becomes:
        2 2 2
        2 2 0
        0 1 1

    Queue:
        (1,1), (0,2)

    Fresh:
        2

    Minutes:
        2

    ============================================================
    MINUTE 3 (BFS LEVEL 3)
    ============================================================

    Process:
        (1,1), (0,2)

    From (1,1):
        (2,1) → rot

    Grid becomes:
        2 2 2
        2 2 0
        0 2 1

    Queue:
        (0,2), (2,1)

    Fresh:
        1

    Minutes:
        3

    ============================================================
    MINUTE 4 (BFS LEVEL 4)
    ============================================================

    Process:
        (0,2), (2,1)

    From (2,1):
        (2,2) → rot

    Grid becomes:
        2 2 2
        2 2 0
        0 2 2

    Queue:
        (2,2)

    Fresh:
        0

    Minutes:
        4

    ============================================================
    END CONDITION
    ============================================================

    Fresh == 0 → all oranges rotten

    ANSWER:
        4 minutes

    ============================================================
    */

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new LinkedList<>();

        int rows = grid.length;
        int cols = grid[0].length;

        int fresh = 0;

        // STEP 1: collect all rotten + count fresh
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;

        int minutes = 0;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // STEP 2: BFS by levels (each level = 1 minute)
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];

                for (int[] dir : directions) {

                    int newrow = row + dir[0];
                    int newcol = col + dir[1];

                    if (newrow >= 0 &&
                        newrow < rows &&
                        newcol >= 0 &&
                        newcol < cols &&
                        grid[newrow][newcol] == 1) {

                        grid[newrow][newcol] = 2;
                        fresh--;

                        queue.offer(new int[]{newrow, newcol});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
