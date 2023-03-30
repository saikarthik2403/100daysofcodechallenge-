//Reverse String
//https://leetcode.com/problems/reverse-string/description/
/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 

Constraints:

1 <= s.length <= 105
s[i] is a printable ascii character.
*/





class Solution {
    public void reverseString(char[] s) {
        int first = 0;
        char temp ;
        int last = s.length-1;
        while (first < last) {
            temp = s[last];
            s[last] = s[first];
            s[first] = temp;
            first++;
            last--;
        }
        for (int i = 0; i<s.length; i++) {
            System.out.print (s[i]);
        }
    }
}
