//Cake Distribution Problem
//https://practice.geeksforgeeks.org/problems/0a7c7f1089932257071f9fa076f25d353f91e0fd/1
/*
Geek is organizing a birthday party, so his friends brought a cake for him. The cake consists of N chunks, whose individual sweetness is represented by the sweetness array. Now at the time of distribution, Geek cuts the cake into K + 1 pieces to distribute among his K friends. One piece he took for himself. Each piece consists of some consecutive chunks. He is very kind, so he left the piece with minimum sweetness for him.

You need to find the maximum sweetness that the Geek can get if he distributes the cake optimally.

Example 1:

Input:
N  = 6, K = 2
sweetness[] = {6, 3, 2, 8, 7, 5}
Output:
9
Explanation:
Geek can divide the cake to [6, 3], [2, 8], [7, 5] 
with sweetness level 9, 10 and 12 respectively.
Example 2:

Input:
N  = 7, K = 3
sweetness[] = {1, 2, 4, 7, 3, 6, 9}
Output:
7
Explanation:
Geek can divide the cake to [1, 2, 4], [7], [3, 6], [9] 
with sweetness level 7, 7, 9 and 9 respectively.
Your Task:
You need to complete the maxSweetness() function which takes an integer array of sweetness, an integer N and an integer K as the input parameters and returns an integer denoting the maximum sweetness that the Geek can get.

Expected Time Complexity: O(NlogM), where M is the sum of elements in the array.
Expected Space Complexity: O(1)

Constraints:
1 <= N <= 105
0 <= K < N
1 <= sweetness[i] <= 109
*/









//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int k = Integer.parseInt(str[1]);
			int [] sweetness = new int[n];
			str = br.readLine().trim().split(" ");
			int i = 0;
			for(String s: str) {
				sweetness[i++] = Integer.parseInt(s);
			}
			Solution obj = new Solution();
			System.out.println(obj.maxSweetness(sweetness, n, k));
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxSweetness(int [] sweetness, int N, int K) {
	    // Write your code here.
	    int low = 1;
        int high = Arrays.stream(sweetness).sum() / (K + 1);
        
        while (low < high) {
            int mid = (low + high + 1) / 2;
            
            int count = 0;
            int sum = 0;
            
            for (int s : sweetness) {
                sum += s;
                if (sum >= mid) {
                    sum = 0;
                    count++;
                    if (count > K) {
                        break;
                    }
                }
            }
            
            if (count > K) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
	}
}









