//
//  Q99-PlaceQueen.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q99_PlaceQueen__
#define __Algorithm_Linux__Q99_PlaceQueen__
using namespace std;
#include <iostream>
#include <math.h>
#include <vector>
vector<int*> placeQueen(int edge, int row);
bool checkQueen(int check[], int row, int col, int edge);
void printQueen(int arr[], int length, int edge);
#endif /* defined(__Algorithm_Linux__Q99_PlaceQueen__) */
