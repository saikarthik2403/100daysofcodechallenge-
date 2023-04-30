//Powerfull Integer
//https://practice.geeksforgeeks.org/problems/d894706c496da5c5a4f45b0360c7f4164c516f83/1
/*
You are given a 2D integer array of intervals whose length is n where intervals[i]=[start, end] I.e. all integers from start to end inclusive of start and end are also present and also we are given an integer k. We have to return the Powerfull Integer. A powerful Integer is an integer that occurs at least k times. If multiple integers have at least k occurrences, we have to return the maximum integer out of all those elements. 

Note: If no integer occurs at least k times return -1.

Example 1:

Input :
n=3
intervals={{1,3},{4,6},{3,4}}
k=2
Output: 4
Explanation:
As we can see that 3 and 4 are the 2 integers 
that have 2 occurences(2>=k) so we have 4 
in this case as the Powerfull integer as it 
is the maximum element which satisfies the condition.
Example 2:

Input :
n=4
intervals={{1,4},{12,45},{3,8},{10,12}}
k=3
Output: -1
Explanation:
As we can see that no integer occurs 
3 times so in that case we have to 
return -1 (see Note).
Example 3:

Input :
n=5
intervals={{16,21},{5,8},{12,17}
           {17,29},{9,24}}
k=3
Output: 
21
Explanation:
As we can see in the given range 17 
occured 4 times while 16,18,19,20 & 21 occured 
3 times. So here we need 3 I.e K occurences 
so we can choose any but we will pick 21, 
because it is maximum.
Your Task:
You don't need to read input or print anything. Your task is to complete the function powerfullInteger() which takes an integer n, a 2d array intervals and an integer k respectively and you have to return powerful Integer if it exists else return -1.

Expected Time Complexity: O(NlogN)
Expected Space Complexity: O(N)

Constraints:
1<=n<=105
1<=intervals[i][0]<=intervals[i][1]<=109
1<=k<=105
The sum of n over all test cases won't exceed 106

 */



//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
            }
            int k=Integer.parseInt(in.readLine().trim());
            Solution ob=new Solution();
            out.println(ob.powerfullInteger(n,a,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int powerfullInteger(int n,int interval[][],int k)
    {
         int max = Integer.MIN_VALUE;
        for (int i=0; i < interval.length; i++) {
            max = Math.max(max, interval[i][1]);
        }
        int[] prefix = new int[max + 2];
        
        for (int i=0; i < interval.length; i++) {
            prefix[interval[i][0]]++;
            prefix[interval[i][1] + 1]--;
        }
        int ans = -1;
        
        for (int i=1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + prefix[i];
            
            if (prefix[i] >= k) {
                ans = i;
            }
        }
        return ans;
    }
}



