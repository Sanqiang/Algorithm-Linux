//
//  Q111-MergeSortedArray.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q111_MergeSortedArray__
#define __Algorithm_Linux__Q111_MergeSortedArray__

#include <iostream>
void mergeSortedArray(int large[], int large_length, int small[], int small_length);

template <typename T>
void printArray(T array[], int length) {
    for (int i = 0; i < length; ++i) {
        std::cout<<array[i]<<" ";
    }
    std::cout<<std::endl;
}
#endif /* defined(__Algorithm_Linux__Q111_MergeSortedArray__) */
