//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends




/*Complete the function below*/

class Solution {
    
    // THE DFS TRAVERSAL WILL BE APPLIED HERE 
    
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        boolean[] pathVis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(cycleCheck(i, adj, vis, pathVis) == true){
                    return true;
                }
            } 
        }
        return false;
    }
    
    private boolean cycleCheck(int i, ArrayList<ArrayList<Integer>> adj, 
    boolean[] vis, boolean[] pathVis){
        
        vis[i] = true;
        pathVis[i] = true;
        
        for(int it : adj.get(i)){
            if(vis[it] == false){
                if(cycleCheck(it, adj, vis, pathVis) == true){
                    return true;
                }
            }
            else if(vis[it] == true && pathVis[it] == true){
                return true;
            }
        }
        pathVis[i] = false;
        return false;
    }
}