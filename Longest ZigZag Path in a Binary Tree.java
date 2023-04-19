//Longest ZigZag Path in a Binary Tree
//https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
/*
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follow:

Choose any node in the binary tree and a direction (right or left).
If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
Change the direction from right to left or from left to right.
Repeat the second and third steps until you can't move in the tree.
Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).

Return the longest ZigZag path contained in that tree.

 

Example 1:


Input: root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1,null,1]
Output: 3
Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
Example 2:


Input: root = [1,1,1,null,1,null,null,1,1,null,1]
Output: 4
Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
Example 3:

Input: root = [1]
Output: 0
 

Constraints:

The number of nodes in the tree is in the range [1, 5 * 104].
1 <= Node.val <= 100
*/



class Solution {
    int maxZigZag = 0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root, true, 0); 
        dfs(root, false, 0);
        return maxZigZag;
    }
    
    private void dfs(TreeNode node, boolean direction, int length) {
        if (node == null) {
            return;
        }
        
        // update maxZigZag if current length is greater
        maxZigZag = Math.max(maxZigZag, length);
        
        if (direction) { 
            dfs(node.right, false, length + 1);
            dfs(node.left, true, 1); 
        } else { 
            dfs(node.left, true, length + 1);
            dfs(node.right, false, 1);
        }
    }
}
