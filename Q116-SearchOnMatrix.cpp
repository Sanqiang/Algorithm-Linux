//
//  Q116-SearchOnMatrix.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int matrix[] =
 {
 15,20,40,85,
 20,35,80,95,
 30,55,95,105,
 40,80,100,120
 };
 
 findElementOnMatrix(matrix, 16, 4, 15);
 
 findElementOnMatrix2(matrix, 16, 4, 120);
*/
#include "Q116-SearchOnMatrix.h"

void findElementOnMatrix(int matrix[], int length, int width, int target)
{
    Coordinate *solution = findElementOnMatrix(matrix, length, width, target, new Coordinate(0,0), new Coordinate(width-1,length/width-1));
    if (solution) {
        std::cout<<"Col:"<<solution->col<<" Row:"<<solution->row<<std::endl;
    }else
    {
        std::cout<<"Not Find!!!"<<std::endl;
    }
}


Coordinate * findElementOnMatrix(int matrix[], int length, int width, int target, Coordinate *s, Coordinate *e)
{
    if (s->row > e->row || s->col > e->col) {
        return NULL;
    }
    Coordinate *pivot = findDiagnol(matrix, length, width, target, s, e);
    if (Element(matrix, width, pivot->col, pivot->row) == target) {
        return pivot;
    }else
    {
        Coordinate *lb = findElementOnMatrix(matrix, length, width, target, new Coordinate(s->col,(pivot->row)), new Coordinate((pivot->col-1),e->row));
        if (lb) {
            return lb;
        }else
        {
            return findElementOnMatrix(matrix, length, width, target, new Coordinate((pivot->col),s->row), new Coordinate(e->col,(pivot->row-1)));
        }
    }
    return NULL;
}

Coordinate * findDiagnol(int matrix[], int length, int width, int target, Coordinate *s, Coordinate *e)
{
    int height = length / width;
    int runner_col = s->col, runner_row = s->row;
    while (runner_col < width && runner_row < height) {
        if (Element(matrix, width, runner_col, runner_row) > target) {
            --runner_col;--runner_row;
            break;
        }else if(Element(matrix, width, runner_col, runner_row) == target)
        {
            break;
        }
        ++runner_col; ++runner_row;
    }
    Coordinate * runner = new Coordinate(runner_col,runner_row);
    return runner;
}

int Element(int matrix[], int width, int col, int row)
{
    return matrix[row*width + col];
}

int Element(int matrix[], int width, Coordinate *coord)
{
    
    return matrix[coord->row*width + coord->col];
}

void findElementOnMatrix2(int matrix[], int length, int width, int target)
{
    int height = length/width;
    int col = width - 1, row = 0;
    while (col>=0 && row<height) {
        if (Element(matrix, width, col, row) == target) {
            std::cout<<"Col:"<<col<<" Row:"<<row<<std::endl;
            return;
        }else if(Element(matrix, width, col, row) > target)
        {
            --col;
        }else
        {
            ++row;
        }
    }
    std::cout<<"Not find!!!"<<std::endl;
}