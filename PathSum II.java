===============================================================================

                      PATH SUM II

===============================================================================

Platform  : LeetCode 113
Approach  : DFS + Backtracking
Language  : Java

===============================================================================
PROBLEM SUMMARY
===============

Given the root of a binary tree and an integer targetSum.

Return all root-to-leaf paths where:

    Sum of all node values in the path = targetSum

Example:

            5
           / \
          4   8
         /   / \
       11   13  4
       / \      / \
      7   2    5   1

Target:

    22

Answer:

    [
      [5,4,11,2],
      [5,8,4,5]
    ]

===============================================================================
CORE IDEA
=========

Use DFS Traversal.

For every node:

1. Add current node to path
2. Reduce target by node value
3. If target becomes 0 and node is a leaf
      Store the path
4. Explore left subtree
5. Explore right subtree
6. Remove current node from path (Backtracking)

===============================================================================
WHY DOES THIS WORK?
===================

A valid path must satisfy:

1. Start from root
2. End at a leaf node
3. Sum of path = targetSum

While moving down the tree:

    Store current path in ans

When returning:

    Remove current node

This allows us to reuse the same path list
for different branches.

===============================================================================
TIME COMPLEXITY
===============

Every node is visited exactly once.

O(n)

===============================================================================
SPACE COMPLEXITY
================

Recursion Stack + Current Path

Worst Case:

O(h)

where h = height of tree

===============================================================================
FULL DRY RUN
============

Input:

            5
           / \
          4   8
         /   / \
       11   13  4
       / \      / \
      7   2    5   1

Target = 22

-------------------------------------------------------------------------------

INITIAL

Path:

[]

Result:

[]

-------------------------------------------------------------------------------

ROOT NODE = 5

Add:

[5]

Target:

22 - 5 = 17

Go Left

-------------------------------------------------------------------------------

NODE = 4

Add:

[5,4]

Target:

17 - 4 = 13

Go Left

-------------------------------------------------------------------------------

NODE = 11

Add:

[5,4,11]

Target:

13 - 11 = 2

Go Left

-------------------------------------------------------------------------------

NODE = 7

Add:

[5,4,11,7]

Target:

2 - 7 = -5

Leaf Node

Target != 0

Not Valid

Backtrack:

Remove 7

Path:

[5,4,11]

Return

-------------------------------------------------------------------------------

NODE = 2

Add:

[5,4,11,2]

Target:

2 - 2 = 0

Leaf Node

Target == 0

VALID PATH FOUND

Store Copy:

result =

[
 [5,4,11,2]
]

Backtrack:

Remove 2

Path:

[5,4,11]

Return

-------------------------------------------------------------------------------

Finished 11

Backtrack:

Remove 11

Path:

[5,4]

-------------------------------------------------------------------------------

Finished 4

Backtrack:

Remove 4

Path:

[5]

-------------------------------------------------------------------------------

GO RIGHT TO 8

Current Path:

[5]

Important:

Target is still 17

Because every recursive call gets its own copy
of target.

-------------------------------------------------------------------------------

NODE = 8

Add:

[5,8]

Target:

17 - 8 = 9

-------------------------------------------------------------------------------

NODE = 13

Add:

[5,8,13]

Target:

9 - 13 = -4

Leaf Node

Not Valid

Backtrack:

Remove 13

Path:

[5,8]

-------------------------------------------------------------------------------

NODE = 4

Add:

[5,8,4]

Target:

9 - 4 = 5

-------------------------------------------------------------------------------

NODE = 5

Add:

[5,8,4,5]

Target:

5 - 5 = 0

Leaf Node

VALID PATH

Store Copy:

[
 [5,4,11,2],
 [5,8,4,5]
]

Backtrack:

Remove 5

Path:

[5,8,4]

-------------------------------------------------------------------------------

NODE = 1

Add:

[5,8,4,1]

Target:

5 - 1 = 4

Leaf Node

Not Valid

Backtrack:

Remove 1

Path:

[5,8,4]

-------------------------------------------------------------------------------

Finished 4

Backtrack:

Remove 4

Path:

[5,8]

-------------------------------------------------------------------------------

Finished 8

Backtrack:

Remove 8

Path:

[5]

-------------------------------------------------------------------------------

Finished Root

Backtrack:

Remove 5

Path:

[]

Traversal Finished

===============================================================================
WHY new ArrayList<>(ans)?
=========================

Wrong:

result.add(ans);

Because later:

ans.remove(...)

will modify the stored answer also.

Correct:

result.add(new ArrayList<>(ans));

This stores a separate copy.

===============================================================================
BACKTRACKING VISUALIZATION
==========================

Choose:

ans.add(root.val)

Example:

[5]
[5,4]
[5,4,11]

Explore:

dfs(left)
dfs(right)

Undo:

ans.remove(last)

Example:

[5,4,11,7]

Remove 7

[5,4,11]

Now explore sibling 2

[5,4,11,2]

===============================================================================
PATTERN LEARNED
===============

DFS + Backtracking

Used In:

• Path Sum II
• Subsets
• Permutations
• Combination Sum
• N Queens
• Word Search
• Generate Parentheses

===============================================================================
JAVA SOLUTION
=============

class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int target) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        dfs(root, target, result, ans);

        return result;
    }

    public void dfs(TreeNode root,
                    int target,
                    List<List<Integer>> result,
                    List<Integer> ans) {

        if (root == null) {
            return;
        }

        ans.add(root.val);

        target -= root.val;

        if (target == 0 &&
            root.left == null &&
            root.right == null) {

            result.add(new ArrayList<>(ans));
        }

        dfs(root.left, target, result, ans);
        dfs(root.right, target, result, ans);

        ans.remove(ans.size() - 1);
    }
}

===============================================================================
KEY TAKEAWAY
============

Choose  → Add current node

Explore → DFS Left + DFS Right

Undo    → Remove current node

This is the standard Backtracking Pattern.

===============================================================================
