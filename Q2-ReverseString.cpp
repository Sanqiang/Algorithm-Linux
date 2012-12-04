//
//  Q2-ReverseString.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/3/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 char str[] = "aabbcc";
 reverseStr(str);
 std::cout<<str;
 */
#include "Q2-ReverseString.h"

void reverseStr(char *str)
{
    char *end = str;
    while (*end) {
        ++end;
    }
    --end;
    char temp;
    while (*str != *end) {
        temp = *str;
        *str = *end;
        *end = temp;
        ++str; --end;
    }
}