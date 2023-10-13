//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String first;
    int second;
    Pair(String first, int second){
        this.first = first;
        this.second = second;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<String>();
        for(String str : wordList){
            if(str.equals(startWord)){
                continue;
            }
            else{
                set.add(str);                
            }            
        }
        
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(startWord, 1));
        while(!q.isEmpty()){
            
            String word = q.peek().first;
            int step = q.peek().second; 
            q.remove();
            
            if(word.equals(targetWord)){
                return step;
            }
            
            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    String str = word.substring(0, i) + ch + word.substring(i + 1);
                    
                    if(set.contains(str)){
                        set.remove(str);
                        q.add(new Pair(str, step + 1));
                    }
                }
            }           
        }
        return 0;
    }
}