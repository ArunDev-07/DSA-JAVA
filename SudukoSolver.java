class Solution {

    /*
    =====================================================================
    PARAGRAPH EXPLANATION
    =====================================================================

    This program solves the Sudoku puzzle using BACKTRACKING.

    Backtracking means:
    1. Find an empty cell '.'
    2. Try placing numbers from '1' to '9'
    3. Check whether the number is valid using isSafe()
    4. If valid, place it
    5. Recursively solve the remaining board
    6. If later it fails, remove that number and try another one

    So the algorithm works like:
    Try -> Go forward -> If stuck -> Come back -> Try another choice

    Important idea:
    It does NOT erase the whole board while backtracking.
    It only removes the last wrong choice and then tries the next number.

    This is the standard recursion + backtracking approach used in:
    - Sudoku Solver
    - N Queens
    - Rat in a Maze
    - Word Search
    - Permutations / Combinations

    =====================================================================
    FULL CODE WITH COMMAND EXPLANATION FOR EACH LINE
    =====================================================================
    */

    public void solveSudoku(char[][] board) {

        // This is the starting function called by LeetCode.
        // It starts solving from row 0 and col 0.
        solve(board, 0, 0);
    }

    public boolean solve(char[][] board, int row, int col) {

        // BASE CASE:
        // If row becomes 9, it means we have successfully processed rows 0 to 8.
        // So the whole Sudoku is solved.
        if (row == 9) {
            return true;
        }

        // This loop scans all columns in the current row.
        // We are checking whether there is any empty cell '.' in this row.
        for (int i = 0; i < 9; i++) {

            // If current cell is empty, then we need to fill it.
            if (board[row][i] == '.') {

                // Try all numbers from '1' to '9' in this empty place.
                for (char num = '1'; num <= '9'; num++) {

                    // Check whether placing num at board[row][i] is valid.
                    if (isSafe(board, row, i, num)) {

                        // Place the number temporarily.
                        // This is a trial choice, not final yet.
                        board[row][i] = num;

                        // Now recursively try solving the rest of the Sudoku.
                        // If the rest gets solved, then this choice is correct.
                        if (solve(board, row, i)) {
                            return true;
                        } else {

                            // If recursive call failed, it means this choice
                            // created a dead end later.
                            // So undo the current choice (BACKTRACK).
                            board[row][i] = '.';
                        }
                    }
                }

                // If all numbers from 1 to 9 fail for this empty cell,
                // then this path is impossible.
                // So return false to go back and change previous choice.
                return false;
            }
        }

        // If this row has no empty cells, move to the next row.
        // col is not actually used in your logic, but it is passed anyway.
        return solve(board, row + 1, col);
    }

    public boolean isSafe(char[][] board, int row, int col, char number) {

        // Check all 9 positions in:
        // 1. same column
        // 2. same row
        // 3. same 3x3 box
        for (int i = 0; i < 9; i++) {

            // COLUMN CHECK:
            // If the same number already exists in this column,
            // then placing it here is invalid.
            if (board[i][col] == number) {
                return false;
            }

            // ROW CHECK:
            // If the same number already exists in this row,
            // then placing it here is invalid.
            if (board[row][i] == number) {
                return false;
            }

            // 3x3 BOX CHECK:
            // This formula helps us move through all 9 cells
            // inside the corresponding 3x3 sub-box.

            // Find row index inside the 3x3 box
            int r = 3 * (row / 3) + i / 3;

            // Find column index inside the 3x3 box
            int c = 3 * (col / 3) + i % 3;

            // If number already exists in that 3x3 box,
            // then placing it here is invalid.
            if (board[r][c] == number) {
                return false;
            }
        }

        // If it passes row, column, and box checks,
        // then the number is safe to place.
        return true;
    }

    /*
    =====================================================================
    IMPORTANT EXPLANATION OF THE BACKTRACKING PART
    =====================================================================

    This part is the heart of the program:

        if (isSafe(board, row, i, num)) {
            board[row][i] = num;

            if (solve(board, row, i)) {
                return true;
            } else {
                board[row][i] = '.';
            }
        }

    Meaning:

    1. If the number is safe, place it.
    2. Then try solving the remaining board recursively.
    3. If that recursive call returns true, the Sudoku is solved.
    4. If it returns false, it means this choice was wrong.
    5. So remove that number and try the next one.

    So:

    place number
    -> solve rest
    -> if success, return true
    -> if fail, remove number
    -> try next number

    =====================================================================
    WHY return false IS NEEDED
    =====================================================================

    This line:

        return false;

    means:

    "For this empty cell, no number from 1 to 9 works."

    So recursion goes back to the previous step and changes the older choice.

    It does NOT mean the whole Sudoku is impossible immediately.
    It means:

    "Current path is wrong. Go back one step."

    =====================================================================
    WHY row + 1 IS USED
    =====================================================================

    This line:

        return solve(board, row + 1, col);

    means:

    "Current row is fully filled, so move to the next row."

    Since there is no empty cell in this row, there is nothing to try here.

    =====================================================================
    WHY solve(board, row, i) IS USED
    =====================================================================

    In your code, after placing a number, you call:

        solve(board, row, i)

    This still works because in solve(), you again scan the row from start
    and search for the next empty cell.

    So even though you pass (row, i), the function is not truly continuing
    from that exact index. It rechecks the row again.

    That is why your code works, even though it is not the cleanest version.

    =====================================================================
    DRY RUN WITH FULL VISUAL EXAMPLE
    =====================================================================

    Suppose the current row is:

        5 3 . . 7 . . . .

    Let row = 0

    ---------------------------------------------------------------------
    STEP 1: Find first empty cell
    ---------------------------------------------------------------------

    The loop checks:

        board[0][0] = '5'   -> not empty
        board[0][1] = '3'   -> not empty
        board[0][2] = '.'   -> empty found

    So now we try numbers from '1' to '9' in board[0][2].

    ---------------------------------------------------------------------
    STEP 2: Try num = '1'
    ---------------------------------------------------------------------

    Check:

        isSafe(board, 0, 2, '1')

    If '1' is safe:
        board[0][2] = '1'

    Board becomes:

        5 3 1 . 7 . . . .

    Then recursive call:

        solve(board, 0, 2)

    Meaning:
    "Now try solving the rest of the Sudoku."

    ---------------------------------------------------------------------
    STEP 3: Recursive solving continues
    ---------------------------------------------------------------------

    Later, suppose the recursion reaches another empty cell and gets stuck.

    Example idea:

        5 3 1 . 7 . . . .
        6 . . 1 9 5 . . .
        . 9 8 . . . . 6 .

    Suppose at some deeper level,
    no valid number can be placed in some future empty cell.

    Then that recursive call returns:

        false

    ---------------------------------------------------------------------
    STEP 4: Backtracking happens
    ---------------------------------------------------------------------

    Since recursive call returned false:

        board[0][2] = '.'

    Board becomes again:

        5 3 . . 7 . . . .

    This means:
    "1 was not the correct choice here."

    ---------------------------------------------------------------------
    STEP 5: Try next number
    ---------------------------------------------------------------------

    Now loop continues:

        num = '2'
        num = '3'
        num = '4'
        ...

    Suppose '2' is safe.

        board[0][2] = '2'

    Board becomes:

        5 3 2 . 7 . . . .

    Again recursive call happens.

    ---------------------------------------------------------------------
    STEP 6: If one choice finally solves everything
    ---------------------------------------------------------------------

    Suppose with some number, the recursion solves the entire board.

    Then deepest call reaches:

        if (row == 9) return true;

    Then true keeps returning upward through all recursive calls.

    So all calls return true and Sudoku is solved.

    =====================================================================
    SIMPLE VISUAL RECURSION TREE
    =====================================================================

    Empty cell at (0,2)

    Try '1'
      -> solve remaining board
      -> fails
      -> backtrack

    Try '2'
      -> solve remaining board
      -> fails
      -> backtrack

    Try '3'
      -> solve remaining board
      -> success
      -> return true

    =====================================================================
    VISUAL FOR isSafe() 3x3 BOX LOGIC
    =====================================================================

    Formula:

        int r = 3 * (row / 3) + i / 3;
        int c = 3 * (col / 3) + i % 3;

    Suppose:
        row = 4
        col = 5

    Then:

        row / 3 = 1
        col / 3 = 1

    Start of box:

        3 * 1 = 3
        3 * 1 = 3

    So the 3x3 box starts at:

        (3,3)

    Full box is:

        (3,3) (3,4) (3,5)
        (4,3) (4,4) (4,5)
        (5,3) (5,4) (5,5)

    Now i moves from 0 to 8:

        i = 0 -> r = 3, c = 3
        i = 1 -> r = 3, c = 4
        i = 2 -> r = 3, c = 5
        i = 3 -> r = 4, c = 3
        i = 4 -> r = 4, c = 4
        i = 5 -> r = 4, c = 5
        i = 6 -> r = 5, c = 3
        i = 7 -> r = 5, c = 4
        i = 8 -> r = 5, c = 5

    So with one loop, we can check all 9 cells of the box.

    =====================================================================
    FULL FLOW SUMMARY
    =====================================================================

    solveSudoku(board)
        -> calls solve(board, 0, 0)

    solve(board, row, col)
        -> if row == 9, solved
        -> scan current row
        -> if empty found:
              try '1' to '9'
              if safe:
                  place number
                  solve remaining board
                  if failed:
                      remove number
              if no number works:
                  return false
        -> if row is full:
              go to next row

    isSafe(board, row, col, number)
        -> check column
        -> check row
        -> check 3x3 box

    =====================================================================
    TIME COMPLEXITY
    =====================================================================

    Worst case is very large:
        O(9^(number of empty cells))

    Because for each empty cell,
    we may try up to 9 choices.

    But pruning using isSafe() reduces many invalid paths early.

    =====================================================================
    FINAL SHORT INTERVIEW EXPLANATION
    =====================================================================

    I solve Sudoku using backtracking.
    I scan the board row by row to find an empty cell.
    For that empty cell, I try numbers from 1 to 9.
    If a number is safe in the row, column, and 3x3 box,
    I place it and recursively solve the rest of the board.
    If later the recursion fails, I remove the number and try the next one.
    If no number works, I return false to backtrack.
    If I reach row 9, it means the entire board is solved.

    =====================================================================
    SMALL NOTE
    =====================================================================

    Your code works, but a cleaner version usually removes the 'col'
    parameter because it is not really used properly.
    Still, for learning recursion and backtracking, your version is good.
    =====================================================================
    */
}
