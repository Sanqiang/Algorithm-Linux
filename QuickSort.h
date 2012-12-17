//
//  QuickSort.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__QuickSort__
#define __Algorithm_Linux__QuickSort__

#include <iostream>



template <typename T>
int Partition(T arr[], int s, int e, int(*compare)(T a, T b))
{
    if (s >= e) {
        return s;
    }
    T pivot_val = arr[s];
    while (s < e) {
        for (; s < e && compare(pivot_val,arr[e])<=0; --e);
        arr[s] = arr[e];
        for (; s < e && compare(arr[s],pivot_val)<0; ++s);
        arr[e] = arr[s];
    }
    arr[s] = pivot_val;
    return s;
}

template <typename T>
void Split(T arr[], int s, int e, int(*compare)(T a, T b))
{
    if (s >= e) {
        return;
    }
    int pivot = Partition(arr, s, e, *compare);
    Split(arr, s, pivot-1, *compare);
    Split(arr, pivot+1, e, *compare);
}

template <typename T>
void QuickSort(T arr[], int length, int(*compare)(T a, T b))
{
    Split(arr, 0, length - 1,*compare);
}



#endif /* defined(__Algorithm_Linux__QuickSort__) */
