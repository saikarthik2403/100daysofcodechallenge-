// Longest Consecutive Sequence
// https://leetcode.com/problems/longest-consecutive-sequence/description/
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
*/

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            if(!map.containsKey(n)){
                map.put(n, map.containsKey(n - 1) ? n - 1 : n);
                if(map.containsKey(n + 1))
                    map.put(n + 1, n);
            }
        }
        int result = 0;
        int count = 1;
        for(Integer i : map.keySet()){
            int num = i;
            while(map.get(num) != num){
                num = map.get(num);
                count++;
            }
            result = Math.max(result, count);
            count = 1;
        }
        return result;
    }
}

