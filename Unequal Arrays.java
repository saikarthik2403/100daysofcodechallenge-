//Unequal Arrays
//https://practice.geeksforgeeks.org/problems/4db2fcd97400456c4914d5a3e8ad932cc21e3e9d/1
/*
You are given two arrays A and B each of length N. You can perform the following operation on array A zero or more times. 

Select any two indices i and j, 1 <= i , j <= N and i != j
Set A[i] = A[i] + 2 and A[j] = A[j]-2
Find the minimum number of operations required to make A and B equal.

Note :

Two arrays are said to be equal if the frequency of each element is equal in both of them.
Arrays may contain duplicate elements.
Example 1:

Input:
N = 3
A[] = {2, 5, 6}
B[] = {1, 2, 10}
Output: 2
Explanation: 
Select i = 3, j = 2, A[3] = 6 + 2 = 8 and A[2] = 5 - 2 = 3
Select i = 3, j = 2, A[3] = 8 + 2 = 10 and A[2] = 3 - 2 = 1
Now A = {2, 1, 10} and B = {1, 2, 10}
Example 2:

Input:
N = 2
A[] = {3, 3}
B[] = {9, 8}
Output: -1
Explanation: 
It can be shown that A cannot be made equal to B.
Your Task: 
You don't need to read input or print anything. Your task is to complete the function solve() which takes the 2 arrays A[], B[] and their size N as input parameters and returns the minimum number of moves to make A and B equal if possible else return -1.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

Constraints:
1 <= N <= 105
-109 <= A[i] <= 109
-109 <= B[i] <= 109

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
            
            int N;
            N = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, N);
            
            
            int[] B = IntArray.input(br, N);
            
            Solution obj = new Solution();
            long res = obj.solve(N, A, B);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static long solve(int N, int[] A, int[] B) {
        // code here
        Arrays.sort(A);
        Arrays.sort(B);
        ArrayList<Integer> Aeven = new ArrayList<>();
        ArrayList<Integer> Aodd = new ArrayList<>();
        ArrayList<Integer> Beven = new ArrayList<>();
        ArrayList<Integer> Bodd = new ArrayList<>();
        int sum1 =0, sum2 = 0;
        for(int i=0; i<A.length; i++){
            sum1 += A[i];
            sum2 += B[i];
            if(A[i]%2 == 0) {
                Aeven.add(A[i]);
            }
            else {
                Aodd.add(A[i]);
            }
            
            if(B[i]%2 == 0){
                Beven.add(B[i]);
            }
            else {
                Bodd.add(B[i]);
            }
        }
        long ans =0;
        if(sum1 != sum2 || Aeven.size() != Beven.size()) {
            return -1;
        }
        for(int i=0; i< Aodd.size(); i++) {
            ans += Math.abs(Aodd.get(i) - Bodd.get(i));
        }
        for(int i=0; i< Aeven.size(); i++) {
            ans += Math.abs(Aeven.get(i) - Beven.get(i));
        }
        return ans/4;
    }
}





