//
//  Q57-FindMissing.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int arr[] = {0,1,2,3,4,5,6,8,9};
 cout<<findMissingNumInArray(arr, 9);
*/
#include "Q57-FindMissing.h"
/*
 byte screen[] =
 {
 49,50,51,52,53,54,55,49,
 51,52,53,54,55,56,57,58,
 59,60,61,62,58,48,58,58
 };
 printGraph(screen, 24, 64);
 drawHorizontalLine(screen, 64, 1, 5, 0);
 cout<<"=========="<<endl;
 printGraph(screen, 24, 64);
*/
bool getBitOnArray(int arr[], int i, int n)
{
    int num = arr[i];
    return ((num >> n) & 1) > 0;
}

bool getBitOnArray(vector<int> arr, int i, int n)
{
    int num = arr[i];
    return ((num >> n) & 1) > 0;
}

int findMissingNumInArray(int arr[], int length)
{
    int i = 0;
    vector<int> s;
    for (; i < length; ++i) {
        s.push_back(arr[i]);
    }
    return findMissingNumInArray(s, 0);
    //return findMissingNumInArrayBack(s, 6);
}

int findMissingNumInArray(vector<int> arr, int b)
{
    vector<int> odd,even;
    vector<int>::iterator it = arr.begin();
    int index = 0;
    for (; it != arr.end(); ++it) {
        if (getBitOnArray(arr, index, b)) {
            odd.push_back(*it);
        }else
        {
            even.push_back(*it);
        }
        ++index;
    }
    if (b == 31) {
        return 0;
    }
    
    if (odd.size() >= even.size()) {
        int r = (findMissingNumInArray(even, b+1) << 1) | 0;
        return r;
    }else
    {
        int r = (findMissingNumInArray(odd, b+1) << 1) | 1;
        return r;
    }
}
//Wrong
int findMissingNumInArrayBack(vector<int> arr, int b)
{
    if (b < 0) {
        return 0;
    }
    vector<int> odd,even;
    vector<int>::iterator it = arr.begin();
    int index = 0;
    for (; it != arr.end(); ++it) {
        if (getBitOnArray(arr, index, b)) {
            odd.push_back(*it);
        }else
        {
            even.push_back(*it);
        }
        ++index;
    }
    
    if (odd.size() >= even.size()) {
        int r = (findMissingNumInArray(even, b-1) << 1) | 0;
        return r;
    }else
    {
        int r = (findMissingNumInArray(odd, b-1) << 1) | 1;
        return r;
    }
}