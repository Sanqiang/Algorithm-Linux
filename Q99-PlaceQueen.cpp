//
//  Q99-PlaceQueen.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 vector<int*> so = placeQueen(8, 0);
 for (int i = 0; i < so.size(); ++i) {
 printQueen(so[i], 8, 8);
 cout<<"======"<<endl;
 }
*/
#include "Q99-PlaceQueen.h"
vector<int*> solutions;
int * check;
vector<int*> placeQueen(int edge, int row)
{
    if (row == edge) {
        //printQueen(check, edge, edge);
        int * clone = new int[edge];
        for (int c = 0; c < edge; ++c) {
            clone[c] = check[c];
        }
        solutions.push_back(clone);
        return solutions;
    }
    
    if (row == 0) {
        check = new int[edge];
    }
    int i = 0;
    for (; i < edge; ++i) {
        if (checkQueen(check, row, i, edge)) {
            check[row] = i;
            placeQueen(edge, row+1);
        }
    }
    
    return solutions;
}

bool checkQueen(int check[], int row, int col, int edge)
{
    int r = 0;
    for (; r < row; ++r) {
        if (check[r] == col || abs(r - row) == abs(check[r] - col)) {
            return false;
        }
    }
    return true;
}


void printQueen(int arr[], int length, int edge)
{
    int i = 0;
    for (; i < length; ++i) {
        int pos = arr[i];
        int j = 0;
        for (; j < pos; ++j) {
            std::cout<<"0";
        }
        std::cout<<"1";
        for (j = j + 1; j < edge; ++j) {
            std::cout<<"0";
        }
        std::cout<<std::endl;
    }

}