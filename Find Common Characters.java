//Find Common Characters
//https://leetcode.com/problems/find-common-characters/description/
/*
Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). 
You may return the answer in any order.

Example 1:
Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

Example 2:
Input: words = ["cool","lock","cook"]
Output: ["c","o"]

Constraints:
1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.
*/

class Solution {
    public List<String> commonChars(String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : words[0].toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i = 1; i < words.length; i++) {
            HashMap<Character, Integer> tempMap = new HashMap<>();
            for(char c : words[i].toCharArray()) {
                if(map.containsKey(c)) {
                    tempMap.put(c, Math.min(map.get(c), tempMap.getOrDefault(c, 0) + 1));
                }
            }
            map = tempMap;
        }
        
        List<String> ans = new ArrayList<>();
        for(HashMap.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            while(count > 0) {
                ans.add(c + "");
                count--;
            }
        }
        return ans;
    }
}
