# GRAPH DFS CHEAT SHEET

===============================================================================

Topic     : Graph & Grid DFS
Language  : Java

===============================================================================

WHAT IS A GRAPH?
================

A Graph is a collection of Nodes (Vertices) connected by Edges.

Graph Representation

1. Adjacency List (Most Used)
2. Adjacency Matrix

Grid Problems are also Graph Problems where:

Up
Down
Left
Right

are considered as edges.

===============================================================================

GRAPH THINKING PROCESS
======================

1. Build the Graph/Grid.
2. Create visited array (if needed).
3. Decide where DFS starts.
4. Write Base Case.
5. Process Current Node.
6. Visit all Neighbours.
7. Return Answer.

===============================================================================

GRAPH DFS TEMPLATE
==================

void dfs(ArrayList<ArrayList<Integer>> graph,
         int node,
         boolean[] visited){

    visited[node] = true;

    for(int neigh : graph.get(node)){

        if(!visited[neigh]){

            dfs(graph, neigh, visited);

        }
    }
}

===============================================================================
1) FIND IF PATH EXISTS IN GRAPH (LC 1971)
===============================================================================

Question

Can we reach destination from source?

Thinking

1. Build Adjacency List.
2. Start DFS from source.
3. If current node == destination
      return true.
4. Otherwise visit neighbours.
5. If no path exists return false.

Code

class Solution {

    public boolean validPath(int n, int[][] edges,
                             int source,
                             int destination) {

        ArrayList<ArrayList<Integer>> graph =
                new ArrayList<>();

        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){

            int u=edge[0];
            int v=edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean[] visited=new boolean[n];

        return dfs(graph,source,destination,visited);
    }

    public boolean dfs(ArrayList<ArrayList<Integer>> graph,
                       int node,
                       int destination,
                       boolean[] visited){

        if(node==destination)
            return true;

        visited[node]=true;

        for(int neigh:graph.get(node)){

            if(!visited[neigh]){

                if(dfs(graph,neigh,destination,visited))
                    return true;

            }

        }

        return false;
    }
}

Time Complexity

O(V+E)

Space Complexity

O(V)

Pattern

Need to find a path.

===============================================================================
2) NUMBER OF ISLANDS (LC 200)
===============================================================================

Question

Count the number of islands.

Thinking

1. Traverse every cell.
2. If land and not visited
      New Island Found.
3. count++
4. DFS marks entire island.
5. Continue searching.

Code

class Solution {

    public int numIslands(char[][] grid) {

        int m=grid.length;
        int n=grid[0].length;

        boolean[][] visited=new boolean[m][n];

        int count=0;

        for(int i=0;i<m;i++){

            for(int j=0;j<n;j++){

                if(grid[i][j]=='1' && !visited[i][j]){

                    count++;

                    dfs(grid,i,j,visited);

                }

            }

        }

        return count;
    }

    public void dfs(char[][] grid,
                    int i,
                    int j,
                    boolean[][] visited){

        if(i<0 || j<0 ||
           i>=grid.length ||
           j>=grid[0].length ||
           grid[i][j]=='0' ||
           visited[i][j]){

            return;
        }

        visited[i][j]=true;

        dfs(grid,i+1,j,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i,j-1,visited);

    }
}

Time Complexity

O(m*n)

Space Complexity

O(m*n)

Pattern

Count Connected Components.

===============================================================================
3) FLOOD FILL (LC 733)
===============================================================================

Question

Change all connected cells having same color.

Thinking

1. Store original color.
2. If original == new color
      return image.
3. Start DFS from (sr,sc).
4. Change current cell color.
5. Visit neighbours having original color.

Code

class Solution {

    public int[][] floodFill(int[][] image,
                             int sr,
                             int sc,
                             int color) {

        int original=image[sr][sc];

        if(original==color)
            return image;

        dfs(image,sr,sc,original,color);

        return image;
    }

    public void dfs(int[][] image,
                    int i,
                    int j,
                    int original,
                    int color){

        if(i<0 || j<0 ||
           i>=image.length ||
           j>=image[0].length ||
           image[i][j]!=original){

            return;
        }

        image[i][j]=color;

        dfs(image,i+1,j,original,color);
        dfs(image,i-1,j,original,color);
        dfs(image,i,j+1,original,color);
        dfs(image,i,j-1,original,color);

    }
}

Time Complexity

O(m*n)

Space Complexity

O(m*n)

Pattern

Modify Connected Component.

===============================================================================
COMMON GRAPH DFS PATTERNS
===============================================================================

Find Path

DFS returns boolean

Example

1971

--------------------------------------

Count Components

DFS returns void

count++

Example

200

547

--------------------------------------

Modify Components

DFS returns void

Change Value

Example

733

130

--------------------------------------

Find Area

DFS returns int

Example

695

--------------------------------------

Clone Graph

DFS returns Node

Example

133

===============================================================================
NEXT GRAPH PROBLEMS
===============================================================================

695. Max Area of Island
547. Number of Provinces
133. Clone Graph
994. Rotting Oranges
130. Surrounded Regions
417. Pacific Atlantic Water Flow
841. Keys and Rooms
207. Course Schedule
210. Course Schedule II

===============================================================================
