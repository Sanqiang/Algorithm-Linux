//
//  Q6-rotateMatrix.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/5/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int matrix[] ={
 1,2,3,
 4,5,6,
 7,8,9
 };
 printMatrixSimple(matrix, 3);
 rotateMatrixSimple(matrix, 3);
 printMatrixSimple(matrix, 3);
 */
#include "Q6-rotateMatrix.h"

template <class T>
void rotateMatrix(T matrix[][], int edge)
{
    int i,j;
    for (i = 0; i < edge/2; ++i) {
        for (j =0; j < edge-1; ++j) {
            T temp = matrix[i][j];
            matrix[i][j]=matrix[edge-1-j][i];
            matrix[edge-1-j][i]=matrix[edge-1-i][edge-1-j];
            matrix[edge-1-i][edge-1-j]=matrix[j][edge-1-i];
            matrix[j][edge-1-i] = temp;
        }
    }
}

template <class T>
void printMatrix(T matrix[][], int edge)
{
    int i,j;
    for (i=0; i<edge; ++i) {
        for (j=0; j<edge; ++j) {
        std:cout<<matrix[i][j]<<" ";
        }
        std::cout<<std::endl;
    }
}

void rotateMatrixSimple(int matrix[], int edge)
{
    int i,j;
    for (i = 0; i < edge/2; ++i) {
        for (j =0; j < edge-1; ++j) {
            int temp = matrix[i*edge+j];
            matrix[i*edge+ j]=matrix[(edge-1-j) * edge+i];
            matrix[(edge-1-j)*edge+i]=matrix[(edge-1-i) *edge+( edge-1-j)];
            matrix[(edge-1-i) * edge +edge-1-j]=matrix[j *edge+ edge-1-i];
            matrix[j * edge+ edge-1-i] = temp;
        }
    }
}

void printMatrixSimple(int matrix[], int edge)
{
    int i,j;
    for (i=0; i<edge; ++i) {
        for (j=0; j<edge; ++j) {
        std:cout<<matrix[i * edge + j]<<" ";
        }
        std::cout<<std::endl;
    }
}
