//Valid Parentheses
//https://leetcode.com/problems/valid-parentheses/description/
/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
 

Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/



class Solution {
    public boolean isValid(String s) {
                Stack<Character> bracket = new Stack<>();
        for (char c : s.toCharArray()) {
             switch (c) {
                case '(':
                    bracket.push(c);
                    break;
                case '{': 
                    bracket.push(c); 
                    break;
                case '[': 
                    bracket.push(c); 
                    break;
                case ')': 
                    if (bracket.empty() || bracket.peek()!='(')
                        return false;
                    else 
                        bracket.pop(); break;
                case '}': 
                    if (bracket.empty() || bracket.peek()!='{') 
                        return false; 
                    else 
                        bracket.pop(); 
                        break;
                case ']': 
                    if (bracket.empty() || bracket.peek()!='[') 
                        return false; 
                    else 
                        bracket.pop(); 
                        break;
                default: ; 
            }
        }
        return bracket.isEmpty();
    }
}
