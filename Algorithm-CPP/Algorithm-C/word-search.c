//
//  word-search.c
//
//
//  Created by Sanqiang Zhao on 11/25/15.
//
//

#include "word-search.h"
bool existRecursive(char** board, int boardRowSize, int boardColSize, char* word, int idx, int nword,int row, int col){
    if (board[row][col] == word[idx]) {
        char temp =board[row][col];
        board[row][col] = '*';
        if (idx == nword-1) {
            return true;
        }else if((row +1 < boardRowSize && board[row+1][col]!='*' && existRecursive(board,boardRowSize,boardColSize,word,idx+1,nword,row+1,col))  ||(row -1 >=0 && board[row-1][col]!='*' && existRecursive(board,boardRowSize,boardColSize,word,idx+1,nword,row-1,col)) ||(col +1 < boardColSize && board[row][col+1]!='*' && existRecursive(board,boardRowSize,boardColSize,word,idx+1,nword,row,col+1))  ||(col -1 >=0 && board[row][col-1]!='*' && existRecursive(board,boardRowSize,boardColSize,word,idx+1,nword,row,col-1))){
            return true;
        }
        board[row][col] =temp;
    }
    return false;
}


bool exist(char** board, int boardRowSize, int boardColSize, char* word) {
    unsigned long nword = strlen(word);
    
    for (int row = 0; row < boardRowSize; ++row) {
        for (int col = 0; col < boardColSize ; ++col) {
            if(word[0] == board[row][col] && existRecursive(board,boardRowSize,boardColSize,word,0,nword,row,col)){
                return true;
            }
        }
    }
    return false;
}