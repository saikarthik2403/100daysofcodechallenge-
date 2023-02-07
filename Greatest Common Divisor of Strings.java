//Greatest Common Divisor of Strings
//https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
/*
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 

Constraints:

1 <= str1.length, str2.length <= 1000
str1 and str2 consist of English uppercase letters.
*/


class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        if (str1.equals(str2)) {
            return str1;
        }
        for (int i = str2.length(); i >= 1; i--) {
            if (str2.length() % i != 0) {
                continue;
            }
            String curr = str2.substring(0, i);
            if (check(curr, str2) && check(curr, str1)) {
                return curr;
            }
        }
        return "";
    }
    
    private boolean check(String curr, String str) {
        int len = curr.length();
        for (int i = 0; i < str.length(); i += len) {
            if (!str.startsWith(curr, i)) {
                return false;
            }
        }
        return true;
    }
}
