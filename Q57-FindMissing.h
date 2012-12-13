//
//  Q57-FindMissing.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q57_FindMissing__
#define __Algorithm_Linux__Q57_FindMissing__

#include <iostream>
#include <vector>
#include <iterator>
using namespace std;
int findMissingNumInArray(vector<int> arr, int b);
int findMissingNumInArray(int arr[], int length);
int findMissingNumInArrayBack(vector<int> arr, int b);
bool getBitOnArray(vector<int> arr, int i, int n);
bool getBitOnArray(int arr[], int i, int n);
#endif /* defined(__Algorithm_Linux__Q57_FindMissing__) */
