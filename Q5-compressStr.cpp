//
//  Q5-compressStr.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/4/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q5-compressStr.h"


char * compressStr(char *str)
{
    int length = getLength(str);
    if (length>strlen(str)) {
        return str;
    }
    char *result = new char[length];
    char *runner =result;
    ++str;
    int num = 0;
    while (*str) {
        if (*str == *(str+1)) {
            ++num;
        }else
        {
            //concat(runner, (str-1), num);
            *runner= *(str-1); ++runner;
            while (num>0) {
                *runner = '0' + num % 10;
                num /= 10;
                ++runner;
            }
            num =0;
        }
        ++str;
    }
    //*str = '\0';
    return result;
}

int getLength(char *str)
{
    char * runner = str;
    ++runner;
    int num_length = 0,length =0;
    while (*runner) {
        if (*runner == *(runner+1)) {
            ++num_length;
        }else
        {
            length+=1+getDigit(num_length);
            num_length =0;
        }
        ++runner;
    }
    return length;
}

int getDigit(int num)
{
    int length = 0;
    while (num >0) {
        ++length;
        num = num / 10;
    }
    return length;
}

void concat(char *str, char *ch, int num)
{
    *str= *ch; ++str;
    while (num>0) {
        *str = '9';// + num % 10;
        num /= 10;
        ++str;
    }
}