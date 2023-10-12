//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    int first;
    int second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Solution {
    
    private void topoSort(int i, int[] vis, Stack<Integer> st, List<List<Pair>> adj){
        vis[i] = 1;
        
        for(int it = 0; it < adj.get(i).size(); it++){
            int temp = adj.get(i).get(it).first;
            if(vis[temp] == 0){
                topoSort(temp, vis, st, adj);
            }
        }
        st.push(i);
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		List<List<Pair>> adj = new ArrayList<>();
		for(int i = 0; i < N; i++){
		    List<Pair> arr = new ArrayList<>();
		    adj.add(arr);
		}
		
		for(int i = 0; i < M; i++){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int wt = edges[i][2];
		    adj.get(u).add(new Pair(v, wt));
		}
		
		Stack<Integer> st = new Stack<Integer>();
		int[] vis = new int[N];
		for(int i = 0; i < N; i++){
		    if(vis[i] == 0){
		        topoSort(i, vis, st, adj);
		    }
		}
		
		int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[0] = 0;
		while(!st.isEmpty()){
		    int node = st.pop();
		    
		    for(int i = 0; i < adj.get(node).size(); i++){
		        int u = adj.get(node).get(i).first;
		        int wt = adj.get(node).get(i).second;
		        
		        if(dist[node] != Integer.MAX_VALUE && dist[node] + wt < dist[u]){
		            dist[u] =  dist[node] + wt;
		        }
		    }
		}
		
		for(int i = 0; i < N; i++){
		    if(dist[i] == Integer.MAX_VALUE){
		        dist[i] = -1;
		    }
		}
		return dist;
		
	}
	
}
