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
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Pair {
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {

        int[] dist = new int[100000];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, start));
        
        Arrays.fill(dist, (int)1e9);
        dist[start] = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                Pair it = q.peek();
                q.remove();
                int steps = it.first;
                int node = it.second;
                if(node == end){
                    return steps;
                }
                for(int i = 0; i < arr.length; i++){
                    int num = (arr[i] * node) % 100000;
                    if(steps + 1 < dist[num]){
                        dist[num] = steps + 1;
                        
                        q.add(new Pair(steps + 1, num));
                    }
                }
            }
        }
        if(dist[end] == (int)1e9){
            return -1;
        }
        return dist[end];
    }
}
