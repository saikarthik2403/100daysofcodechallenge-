//Last Stone Weight
//https://leetcode.com/problems/last-stone-weight/description/
/*
You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.

 

Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation: 
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:

Input: stones = [1]
Output: 1
 

Constraints:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
*/









class Solution {
    public int lastStoneWeight(int[] stones) {
    int n = stones.length;
    buildHeap(stones, n);
    while(n > 1){
        int a = stones[0];
        swap(stones, 0, n - 1);
        heapify(stones, 0, n - 1);
        int b = stones[0];
        swap(stones, 0, n - 2);
        heapify(stones, 0, n - 2);
        n -= 2;
        if(a != b){
            a -= b;
            stones[n++] = a;
            buildHeap(stones, n);
        }
    }
    return n == 0 ? 0 : stones[0];
}

void buildHeap(int[] arr, int n){
    for(int i = n / 2; i >= 0; i--){
        heapify(arr, i, n);
    }
}

void heapify(int[] arr, int i, int n){
    int l = i * 2 + 1;
    int r = i * 2 + 2;
    int max = i;
    if(r < n){
        if(arr[r] > arr[max]) max = r;
    }
    if(l < n){
        if(arr[l] > arr[max]) max = l;
    }
    if(max != i) {
        swap(arr, i, max);
        heapify(arr, max, n);
    }
}

void swap(int[] arr, int a, int b){
    int x = arr[a];
    arr[a] = arr[b];
    arr[b] = x;
}
}







