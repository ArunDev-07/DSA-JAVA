class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        // total = stores the overall gas balance of the full journey.
        // If total becomes negative at the end,
        // it means total gas is less than total cost,
        // so completing the circle is impossible.
        int total = 0;

        // tank = stores the current gas balance while checking
        // whether we can travel from the current chosen starting station.
        int tank = 0;

        // start = stores the current possible starting station index.
        // We begin by assuming station 0 as the starting point.
        int start = 0;

        // Traverse all gas stations one by one.
        for (int i = 0; i < gas.length; i++) {

            // diff = gas gained at station i - cost required to go to next station.
            // This tells whether this station gives us profit or loss.
            int diff = gas[i] - cost[i];

            // Add this station's contribution to current tank.
            // This simulates moving station by station from the current start.
            tank += diff;

            // Also add it to total overall balance.
            total += diff;

            // If tank becomes negative,
            // it means we cannot reach the next station from the current start.
            if (tank < 0) {

                // So current start is invalid.
                // The next station becomes the new possible start.
                start = i + 1;

                // Reset tank to 0 because we are starting fresh
                // from the next station.
                tank = 0;
            }
        }

        // After checking all stations:
        // If total >= 0, journey is possible, return start.
        // Else, return -1 because overall gas is insufficient.
        return total >= 0 ? start : -1;
    }
}

/*
========================
EXPLANATION PARAGRAPH
========================

This problem asks us to find the gas station index from which we can complete one full circular trip.
At each station, we get some gas from gas[i], and we spend some gas equal to cost[i] to reach the next station.
The logic is based on two important ideas.

1) If the total gas available at all stations is less than the total cost required,
   then completing the journey is impossible from any station.
   That is why we maintain "total".

2) If while travelling from a chosen start station, the tank becomes negative at station i,
   then that starting point is not valid.
   Not only that, any station between the old start and i also cannot be a valid starting point.
   So we directly move the start to i + 1 and reset tank to 0.

This is a greedy approach because whenever we fail, we immediately discard the whole invalid segment
and move to the next possible station. At the end, if total gas is enough, the stored "start" index
will be the correct answer.

========================
WHY DOES THIS LOGIC WORK?
========================

Suppose we start from index "start" and at some station i the tank becomes negative.

That means:
From start to i, the total gas collected is not enough to cover the total cost.

Now think about any station between start and i.
If we start from any of them, we would have even less gas advantage,
so they also cannot reach beyond i.

Therefore:
If failure happens at i, all stations from start to i are useless as starting points.
So we safely jump to i + 1.

That is the key greedy logic.

========================
VISUAL EXAMPLE
========================

Example:
gas  =  [1, 2, 3, 4, 5]
cost =  [3, 4, 5, 1, 2]

Let's calculate:
station 0 -> diff = 1 - 3 = -2
station 1 -> diff = 2 - 4 = -2
station 2 -> diff = 3 - 5 = -2
station 3 -> diff = 4 - 1 = +3
station 4 -> diff = 5 - 2 = +3

total = (-2) + (-2) + (-2) + 3 + 3 = 0

Since total = 0, journey is possible.

========================
FULL DRY RUN
========================

Initial:
total = 0
tank  = 0
start = 0

--------------------------------------------------
i = 0
gas[0] = 1
cost[0] = 3
diff = 1 - 3 = -2

tank = 0 + (-2) = -2
total = 0 + (-2) = -2

tank < 0, so current start = 0 is invalid
Update:
start = 0 + 1 = 1
tank = 0

Now:
total = -2
tank  = 0
start = 1
--------------------------------------------------

i = 1
gas[1] = 2
cost[1] = 4
diff = 2 - 4 = -2

tank = 0 + (-2) = -2
total = -2 + (-2) = -4

tank < 0, so current start = 1 is invalid
Update:
start = 1 + 1 = 2
tank = 0

Now:
total = -4
tank  = 0
start = 2
--------------------------------------------------

i = 2
gas[2] = 3
cost[2] = 5
diff = 3 - 5 = -2

tank = 0 + (-2) = -2
total = -4 + (-2) = -6

tank < 0, so current start = 2 is invalid
Update:
start = 2 + 1 = 3
tank = 0

Now:
total = -6
tank  = 0
start = 3
--------------------------------------------------

i = 3
gas[3] = 4
cost[3] = 1
diff = 4 - 1 = +3

tank = 0 + 3 = 3
total = -6 + 3 = -3

tank is not negative,
so continue

Now:
total = -3
tank  = 3
start = 3
--------------------------------------------------

i = 4
gas[4] = 5
cost[4] = 2
diff = 5 - 2 = +3

tank = 3 + 3 = 6
total = -3 + 3 = 0

tank is not negative,
so continue

Final:
total = 0
start = 3

Since total >= 0,
answer = 3

========================
VISUAL PATH CHECK FROM START = 3
========================

Start at station 3

Station 3:
gas = 4
cost to next = 1
tank = 4 - 1 = 3

Station 4:
tank = 3 + 5 - 2 = 6

Station 0:
tank = 6 + 1 - 3 = 4

Station 1:
tank = 4 + 2 - 4 = 2

Station 2:
tank = 2 + 3 - 5 = 0

Back to station 3 successfully

So answer = 3

========================
ANOTHER SMALL EXAMPLE
========================

gas  = [2, 3, 4]
cost = [3, 4, 3]

diff = [-1, -1, +1]

total = -1 + -1 + 1 = -1

Since total < 0,
answer = -1

Reason:
Overall gas is less than overall cost,
so no starting point can complete the trip.

========================
TIME COMPLEXITY
========================

O(n)
Because we traverse the array only once.

========================
SPACE COMPLEXITY
========================

O(1)
Because we only use a few variables.

========================
SHORT MEMORY TRICK
========================

1. Find diff = gas[i] - cost[i]
2. Add diff to total and tank
3. If tank < 0:
   - current start fails
   - move start to i + 1
   - reset tank = 0
4. At end:
   - total >= 0 -> return start
   - total < 0 -> return -1

========================
INTERVIEW ONE-LINE LOGIC
========================

If I cannot reach station i + 1 from my current start,
then every station between current start and i is also invalid,
so I greedily choose i + 1 as the next starting point.
*/
