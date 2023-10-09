//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, 1}};
        
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<int[]>> has = new HashSet<>();
        
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    ArrayList<int[]> arr = new ArrayList<>();
                    dfs(i, j, grid, vis, i, j, dirs, arr);
                    has.add(arr);
                }
            }
        }
        return has.size();
    }
    
    
    private void dfs(int srow,int scol, int[][] grid, boolean[][] vis,int prow, int pcol,
    int[][] dirs, ArrayList<int[]> arr){
        
        vis[srow][scol] = true;
        arr.add(new int[] {srow - prow, scol - pcol});
        
        for(int[] dir : dirs){
            int row = srow + dir[0];
            int col = scol + dir[1];
            
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && 
            grid[row][col] == 1 && vis[row][col] == false){
                dfs(row, col, grid, vis, prow, pcol, dirs, arr);
            }
        }
    }
}
*/


class Solution {

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // Updated directions
        
        boolean[][] vis = new boolean[n][m];
        HashSet<String> has = new HashSet<>(); // Use a set to track unique island shapes
        
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1 && vis[i][j] == false){
                    StringBuilder shape = new StringBuilder(); // To record island shape
                    dfs(i, j, grid, vis, i, j, dirs, shape);
                    has.add(shape.toString()); // Add the island shape as a string
                }
            }
        }
        return has.size();
    }
    
    private void dfs(int srow, int scol, int[][] grid, boolean[][] vis, int prow, int pcol,
                     int[][] dirs, StringBuilder shape){
        
        vis[srow][scol] = true;
        shape.append(srow - prow).append(scol - pcol); // Record relative positions
        
        for(int[] dir : dirs){
            int row = srow + dir[0];
            int col = scol + dir[1];
            
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && 
               grid[row][col] == 1 && vis[row][col] == false){
                dfs(row, col, grid, vis, prow, pcol, dirs, shape);
            }
        }
    }
}

