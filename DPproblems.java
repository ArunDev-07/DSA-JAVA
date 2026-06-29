
# 1D DYNAMIC PROGRAMMING CHEAT SHEET

===============================================================================

Topic     : Dynamic Programming (DP)
Language  : Java

===============================================================================

WHAT IS DP?
===========

Store answers of smaller problems and use them to solve bigger problems.

DP THINKING PROCESS
===================

1. What does dp[i] represent?
2. What are the base cases?
3. What is the recurrence relation?
4. What order should I fill dp?

===============================================================================
1) FIBONACCI NUMBER (LC 509)
===============================================================================

dp[i] = Fibonacci value at index i

Base:
dp[0] = 0
dp[1] = 1

Transition:
dp[i] = dp[i-1] + dp[i-2]

Code:

public int fib(int n) {
    if(n <= 1) return n;

    int[] dp = new int[n + 1];
    dp[0] = 0;
    dp[1] = 1;

    for(int i = 2; i <= n; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];
}

===============================================================================
2) CLIMBING STAIRS (LC 70)
===============================================================================

dp[i] = number of ways to reach stair i

Base:
dp[0] = 1
dp[1] = 1

Transition:
dp[i] = dp[i-1] + dp[i-2]

Code:

public int climbStairs(int n) {
    int[] dp = new int[n + 1];

    dp[0] = 1;
    dp[1] = 1;

    for(int i = 2; i <= n; i++){
        dp[i] = dp[i-1] + dp[i-2];
    }

    return dp[n];
}

===============================================================================
3) MIN COST CLIMBING STAIRS (LC 746)
===============================================================================

dp[i] = minimum cost needed to reach stair i

Base:
dp[0] = cost[0]
dp[1] = cost[1]

Transition:
dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2])

Code:

public int minCostClimbingStairs(int[] cost) {

    int n = cost.length;
    int[] dp = new int[n];

    dp[0] = cost[0];
    dp[1] = cost[1];

    for(int i = 2; i < n; i++){
        dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
    }

    return Math.min(dp[n-1], dp[n-2]);
}

===============================================================================
4) N-th TRIBONACCI NUMBER (LC 1137)
===============================================================================

dp[i] = Tribonacci value at index i

Base:
T0 = 0
T1 = 1
T2 = 1

Transition:
dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

Code:

public int tribonacci(int n) {

    if(n == 0) return 0;
    if(n == 1 || n == 2) return 1;

    int[] dp = new int[n + 1];

    dp[0] = 0;
    dp[1] = 1;
    dp[2] = 1;

    for(int i = 3; i <= n; i++){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }

    return dp[n];
}

===============================================================================
COMMON DP PATTERNS
===============================================================================

Fibonacci:
dp[i] = dp[i-1] + dp[i-2]

Climbing Stairs:
dp[i] = dp[i-1] + dp[i-2]

Tribonacci:
dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

Min Cost Climbing Stairs:
dp[i] = cost[i] + min(dp[i-1], dp[i-2])

===============================================================================
NEXT DP PROBLEMS
===============================================================================

198. House Robber
213. House Robber II
740. Delete and Earn
62. Unique Paths
322. Coin Change
300. Longest Increasing Subsequence
1143. Longest Common Subsequence

===============================================================================
