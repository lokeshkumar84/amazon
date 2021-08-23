package com.leetcode.amazon.medium;

public class WordSearch_79 {
    public boolean exist(char[][] board, String word) {

        for(int i=0; i<board.length; i++) {
            for(int j=0 ; j<board[0].length ; j++) {

                if(word.charAt(0) == board[i][j]) {
                    if(helper(board, word, i, j, 0)){
                        return true;
                    }
                }

            }
        }

        return false;

    }

    private boolean helper(char[][] board, String word, int i, int j, int index) {

        if(word.length() == index) {
            return true;
        }

        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length-1 || word.charAt(index) != board[i][j]){
            return false;
        }

        char c = board[i][j];
        board[i][j] = '*';

        if( helper(board, word, i+1, j, index+1) ||
                helper(board, word, i, j+1, index+1) ||
                helper(board, word, i-1, j, index+1) ||
                helper(board, word, i, j-1, index+1) ) {

            return true;
        }

        board[i][j] = c;
        return false;

    }

}


/*

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.


Follow up: Could you use search pruning to make your solution faster with a larger board?
 */