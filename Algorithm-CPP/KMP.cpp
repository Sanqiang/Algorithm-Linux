//
//  KMP.cpp
//  Algorithm-Linux
//
//  Created by SanQ11iang Zhao on 12/5/12.
//  Copyright (c) 2012 SanQ11iang Zhao. All rights reserved.
//
/*
 int n = KmpSearch("ababababaaabab", "abab");
 std::cout<<n;
 */

#include "KMP.h"


int KmpSearch(char * text, char * pattern)
{
    unsigned long length = strlen(text), pattern_length = strlen(pattern);
    int count = 0, pos,i=0;
    int * table = KmpNext(pattern);
    for (; i<length; ++i) {
        pos=0;
        while (i<length) {
            if (pattern[pos]==text[i]) {
                if (pos==pattern_length-1) {
                    ++count;
                    break;
                }
                ++pos;++i;
            }else{
                if (pos>0) {
                    pos = table[pos-1];
                }else
                {
                    pos=0;
                }
                ++i;
            }
        }
    }
    return count;
}

int * KmpNext(char * pattern)
{
    unsigned long length = strlen(pattern);
    int *table = (int *)malloc(sizeof(int) * length),i,pos=0;
    for (i=0; i<length; ++i) {
        table[i] = 0;
    }
    
    i=1;
    while (i<length) {
        if (pattern[i] == pattern[pos]) {
            ++pos;
            table[i]=pos;
            ++i;
        }else{
            if (pos>0) {
                --pos;
            }else{
                table[i]=pos;
                ++i;
            }
        }
    }
    return table;
}