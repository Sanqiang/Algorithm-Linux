//
//  Q112-SortString.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q112-SortString.h"

void sortString(string arr[], int length)
{
    QuickSort(arr, length, StringCompare);
}

int StringCompare(string a, string b)
{
    unsigned long al = a.length();
    unsigned long bl = b.length();
    unsigned long length = min(al,bl);
    for (int i = 0; i < length; ++i) {
        if (a[i] < b[i]) {
            return -1;
        }else if(a[i] > b[i])
        {
            return 1;
        }
    }
    if (al < bl) {
        return -1;
    }else if(al > bl)
    {
        return 1;
    }else{
        return 0;
    }
}

void sortStringBucket(string arr[], int length)
{
    hash_map<string, int> bucket;
    
}


