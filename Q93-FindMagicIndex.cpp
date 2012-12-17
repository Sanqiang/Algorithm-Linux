//
//  Q93-FindMagicIndex.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int arr[] = {-21,1,3,10,12,15,20};
 //cout<<FindMagicNumberWithoutOverlap(arr, 0, 6);
 int arr2[] = {-100,-100,2,2,2,2,9};
 cout<<FindMagicNumberWithOverlap(arr2,7, 0, 6);
*/
#include "Q93-FindMagicIndex.h"

int FindMagicNumberWithoutOverlap(int arr[], int s, int e)
{
    while (s <= e) {
        int m = (s + e) / 2;
        if (m == arr[m]) {
            return m;
        }else if(m > arr[m])
        {
            s = m + 1;
        }else
        {
            e = m - 1;
        }
    }
    return -1;
}

int FindMagicNumberWithOverlap(int arr[],int length, int s, int e)
{
    if (s > e || s < 0 || e >= length) {
        return -1;
    }
    int m = (s + e) / 2;
    int m_val = arr[m];
    if (m == m_val) {
        return m;
    }
    
    int left_index = min(m-1, m_val);
    int left = FindMagicNumberWithOverlap(arr,length, s, left_index);
    if (left >= 0) {
        return left;
    }
    
    int right_index = max(m+1,m_val);
    int right = FindMagicNumberWithOverlap(arr,length, right_index, e);
    //if (right >= 0) {
        return right;
    //}
    
    //return -1;
    
}