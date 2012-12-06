//
//  Q7-SetZeroOnMatrix.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/5/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int matrix[]={
 1,2,3,4,
 5,6,0,8,
 9,1,2,3,
 };
 
 printMatrix(matrix, 3, 4);
 setZero(matrix, 3, 4);
 printMatrix(matrix, 3, 4);
 setZero(matrix, 3, 4);
 printMatrix(matrix, 3, 4);
 */
#include "Q7-SetZeroOnMatrix.h"

void setZero(int matrix[], int height, int width)
{
    int i,j;
    bool *column = new bool[height];
    bool *row = new bool[width];
    memset(column, 0, height);
    memset(row, 0, width);
    for (i=0; i<height; ++i) {
        for (j=0; j<width; ++j) {
            if (matrix[i*width+j] == 0) {
                column[i]=true;
                row[j]=true;
            }
        }
    }
    
    for (i=0; i<height; ++i) {
        for (j=0; j<width; ++j) {
            if (column[i] || row[j]) {
                matrix[i*width+j]=0;
            }
        }
    }
    
}

void printMatrix(int matrix[], int height, int width)
{
    int i,j;
    for (i=0; i<height; ++i) {
        for (j=0; j<width; ++j) {
            std::cout<<matrix[i*width+j]<<" ";
        }
        std::cout<<std::endl;
    }
    std::cout<<"============="<<std::endl;
}