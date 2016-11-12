//
//  Q111-MergeSortedArray.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int large[] = {1,2,3,0,0,0};
 int small[] = {7,8,9};
 mergeSortedArray(large, 6, small, 3);
 //printArray(large, 6);
 */
#include "Q111-MergeSortedArray.h"

void mergeSortedArray(int large[], int large_length, int small[], int small_length)
{
    int l = large_length - small_length - 1;
    int s = small_length - 1;
    int o = large_length - 1;

    while (1) {
        if (l < 0) {
            while (s >= 0) {
                large[o--] = small[s--];
            }
        }
        if (s < 0) {
            break;
        }
        
        if (large[l] >= small[s]) {
            large[o--] = large[l--];
        }else
        {
            large[o--] = small[s--];
        }
        
    }
}

