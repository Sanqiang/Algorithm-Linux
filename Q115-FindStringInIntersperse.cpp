//
//  Q115-FindStringInIntersperse.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 string arr[] = {"","abc","","bbd","","","","","ea","ee"};
 cout<<findStringInInterSperse(arr, 10, 0, 9, "ea");
*/
#include "Q115-FindStringInIntersperse.h"

int findStringInInterSperse(string arr[], int length, int s, int e, string target)
{
    int m = (s+e)/2;
    if (arr[m].size() == 0) {
        int l = m-1; int r = m+1;
        while (1) {
            if (l >= s && arr[l].size() != 0) {
                m = l;
                break;
            }else if(r <= e && arr[r].size() != 0)
            {
                m = r;
                break;
            }else if(l < s || r > e)
            {
                return -1;
            }
            --l;++r;
        }
    }
    
    int compare = arr[m].compare(target);
    if (compare > 0) {
        return findStringInInterSperse(arr, length, s, m-1, target);
    }else if(compare < 0)
    {
        return findStringInInterSperse(arr, length, m+1, e, target);
    }else
    {
        return m;
    }
}