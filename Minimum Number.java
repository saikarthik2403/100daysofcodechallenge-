//Minimum Number
//https://practice.geeksforgeeks.org/problems/7d62c8606123a199720c9b6885249dc9ac651bb7/1
/*
You are given an array arr of n elements. In one operation you can pick two indices i and j, such that arr[i] >= arr[j] and replace the value of arr[i] with (arr[i] - arr[j]). You have to minimize the values of the array after performing any number of such operations.

Example 1:

Input:
n = 3
arr = {3,2,4}
Output:
1
Explanation:
1st Operation : We can pick 4 & 3, subtract 4-3 => {3,2,1}
2nd Opeartion : We can pick 3 & 2, subtarct 3-2 => {1,2,1}
3rd Operation : We can pick 1 & 2, subtract 2-1 => {1,1,1}
4th Opeartion : We can pick 1 & 1, subtract 1-1 => {1,0,1}
5th Operation : We can pick 1 & 1, subtract 1-1 => {0,0,1}
After this no operation can be performned, so maximum no is left in the array is 1, so the ans is 1.
Example 2:

Input:
n = 2
arr = {2,4}
Output:
2
Explanation:
1st Operation : We can pick 4 & 2, subtract 4-2 => {2,2}
2nd Operation : We can pick 2 & 2, subtract 2-2 => {0,2}
After this no operation can be performned, so maximum no is left in the array is 2, so the ans is 2.
Your Task:  
You don't need to read input or print anything. Your task is to complete the function minimumNumber() which takes an integer n and an array arr, as input parameters and returns the maximum number which is minimized after performing operations.

Expected Time Complexity: O(n)
Expected Space Complexity: O(1)

Constraints:
1 ≤ n ≤ 105
1 ≤ arr[i] ≤ 109
*/




//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minimumNumber(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int minimumNumber(int n, int[] arr) {
        // code here
        int gcd  = arr[0];
        for(int i=1; i<n; i++){
            gcd = GCD(gcd, arr[i]);
        }
        return gcd;
    }
    public static int GCD(int a, int b){
        if(a == 0) return b;
        return GCD(b%a, a);
    }
}
        
