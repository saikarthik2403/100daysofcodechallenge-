//Permutation in String
//https://leetcode.com/problems/permutation-in-string/description/
/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        
        int[] s1Data = new int[26];
        int[] s2Data = new int[26];
        
        for(int i=0;i<s1.length();i++){
            s1Data[s1.charAt(i) - 'a']++;
            s2Data[s2.charAt(i) - 'a']++;
        }
        
        int windowStart = 0;
        int windowEnd = s1.length();
        
        while(windowEnd < s2.length()){
            if(matches(s1Data, s2Data)){
                return true;
            }
            
            s2Data[s2.charAt(windowEnd) - 'a']++;
            s2Data[s2.charAt(windowStart) - 'a']--;
            
            windowStart++;
            windowEnd++;
            
        }
        if(matches(s1Data, s2Data)){
                return true;
        }
        return false;
    }
    
    public boolean matches(int[] s1Data, int[] s2Data){
        for(int i = 0; i < 26; i++){
            if(s1Data[i] != s2Data[i]){
                return false;
            }
        }
        return true;
    }
}
