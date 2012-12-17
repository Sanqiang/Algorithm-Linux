//
//  Q116-SearchOnMatrix.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q116_SearchOnMatrix__
#define __Algorithm_Linux__Q116_SearchOnMatrix__

#include <iostream>

class Coordinate {
public:
    int col;
    int row;
    Coordinate(int _col, int _row):col(_col),row(_row){}
};
int Element(int matrix[], int width, int col, int row);
int Element(int matrix[], int width, Coordinate *coord);
Coordinate * findDiagnol(int matrix[], int length, int width, int target, Coordinate *s, Coordinate *e);
Coordinate * findElementOnMatrix(int matrix[], int length, int width, int target, Coordinate *s, Coordinate *e);
void findElementOnMatrix(int matrix[], int length, int width, int target);
void findElementOnMatrix2(int matrix[], int length, int width, int target);
#endif /* defined(__Algorithm_Linux__Q116_SearchOnMatrix__) */
