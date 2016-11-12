//
//  Q113-FindInRotatedArr.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int arr[] = {6,6,6,6,6,6,6,6,1,2,3,4,5,6};
 cout<<findElementInRotatedArray(arr, 14, 0, 13, 3)<<" "<<findElementInRotatedArray(arr, 14, 0, 13, 1);
*/
#include "Q113-FindInRotatedArr.h"

int findElementInRotatedArray(int arr[], int length, int s, int e, int target)
{
    if (s > e) {
        return -1;
    }
    int m = (s + e) / 2;
    if (arr[m] == target) {
        return m;
    }
    if (arr[s] < arr[m])
    {
        if (target > arr[s] && target < arr[m]) {
            return findElementInRotatedArray(arr, length, s, m-1, target);
        }else
        {
            return findElementInRotatedArray(arr, length, m+1, e, target);
        }
        
    }
    else if(arr[s] > arr[m])
    {
        if (target > arr[m] && target < arr[e]) {
            return findElementInRotatedArray(arr, length, m+1, e, target);
        }else
        {
            return findElementInRotatedArray(arr, length, s, m-1, target);
        }
    }else
    {
        if (arr[m] != arr[e]) {
            return findElementInRotatedArray(arr, length, m+1, e, target);
        }else
        {
            int index = findElementInRotatedArray(arr, length, m+1, e, target);
            if (index == -1) {
                return findElementInRotatedArray(arr, length, s, m-1, target);
            }else
            {
                return index;
            }
        }
    }
}