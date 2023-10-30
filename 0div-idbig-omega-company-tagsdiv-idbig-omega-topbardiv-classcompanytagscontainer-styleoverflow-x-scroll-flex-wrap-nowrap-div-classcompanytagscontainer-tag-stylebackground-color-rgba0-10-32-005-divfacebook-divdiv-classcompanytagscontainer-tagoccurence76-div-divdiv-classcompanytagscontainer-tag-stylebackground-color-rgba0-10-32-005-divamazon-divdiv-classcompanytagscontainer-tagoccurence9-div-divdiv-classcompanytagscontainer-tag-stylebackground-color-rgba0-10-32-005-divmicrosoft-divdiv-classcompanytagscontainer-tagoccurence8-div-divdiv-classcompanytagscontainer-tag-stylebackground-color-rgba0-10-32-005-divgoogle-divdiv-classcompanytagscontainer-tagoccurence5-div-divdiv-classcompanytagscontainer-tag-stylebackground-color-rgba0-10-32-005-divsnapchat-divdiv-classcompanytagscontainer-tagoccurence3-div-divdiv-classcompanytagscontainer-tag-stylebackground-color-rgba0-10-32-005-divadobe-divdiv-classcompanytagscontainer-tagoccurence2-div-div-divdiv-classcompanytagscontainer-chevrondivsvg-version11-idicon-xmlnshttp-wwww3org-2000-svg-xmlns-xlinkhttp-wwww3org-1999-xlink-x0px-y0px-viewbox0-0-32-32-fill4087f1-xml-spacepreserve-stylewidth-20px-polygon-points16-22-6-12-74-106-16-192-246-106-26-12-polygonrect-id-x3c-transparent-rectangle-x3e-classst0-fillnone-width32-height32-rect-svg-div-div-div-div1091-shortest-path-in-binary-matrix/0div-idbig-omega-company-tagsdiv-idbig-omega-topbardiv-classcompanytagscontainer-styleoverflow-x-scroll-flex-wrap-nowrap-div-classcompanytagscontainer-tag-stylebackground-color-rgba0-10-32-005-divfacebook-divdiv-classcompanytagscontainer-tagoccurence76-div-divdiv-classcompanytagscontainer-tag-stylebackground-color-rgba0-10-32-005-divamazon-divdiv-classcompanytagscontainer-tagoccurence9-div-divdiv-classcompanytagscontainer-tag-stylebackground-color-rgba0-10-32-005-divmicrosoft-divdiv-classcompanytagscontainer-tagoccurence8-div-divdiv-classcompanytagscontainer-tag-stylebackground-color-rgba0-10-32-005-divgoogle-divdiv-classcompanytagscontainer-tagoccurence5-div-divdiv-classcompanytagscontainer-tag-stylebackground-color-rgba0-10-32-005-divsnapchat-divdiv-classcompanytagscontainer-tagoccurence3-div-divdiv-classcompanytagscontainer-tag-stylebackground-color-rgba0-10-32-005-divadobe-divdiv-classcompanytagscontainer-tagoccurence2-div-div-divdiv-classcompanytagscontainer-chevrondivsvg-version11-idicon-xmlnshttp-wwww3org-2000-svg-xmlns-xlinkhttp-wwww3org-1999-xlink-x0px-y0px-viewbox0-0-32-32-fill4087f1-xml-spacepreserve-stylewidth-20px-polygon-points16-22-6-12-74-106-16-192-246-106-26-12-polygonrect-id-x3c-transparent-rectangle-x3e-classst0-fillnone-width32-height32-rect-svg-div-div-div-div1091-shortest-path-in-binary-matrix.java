class tuple {
    int first, second, third;
    tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        if(grid.length == 1 && grid[0].length == 1){
            return grid[0][0] == 0 ? 1 : -1;
        }
        
        int n = grid.length; // Size of the grid

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1; // No clear path from start to end
        }
        int[][] dist = new int[grid.length][grid[0].length];
        
        int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                dist[i][j] = (int)(1e9); 
            }
        }
        dist[0][0] = 1;
        Queue<tuple> q = new LinkedList<>();
        q.add(new tuple(1, 0, 0));

        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                tuple it = q.peek();
                q.remove();
                int dis = it.first;
                int x = it.second;
                int y = it.third;

                for(int i = 0; i < 8; i++){
                    int a = x + dx[i];
                    int b = y + dy[i];

                    if(a >= 0 && a < grid.length && b >= 0 && b < grid[0].length && grid[a][b] == 0 && dist[a][b] > dis + 1){
                        dist[a][b] = dis + 1;
                        q.add(new tuple(dis + 1, a, b));
                    }
                }
            }
        }

        if(dist[grid.length - 1][grid[0].length - 1] == (int)1e9){
            return -1;
        }
        return dist[grid.length - 1][grid[0].length - 1];
        
    }
} 
