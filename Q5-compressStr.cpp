//
//  Q5-compressStr.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/4/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 std::cout<<compressStr("aaabbccddeeeee")<<std::endl;
 std::cout<<compressStr("amp")<<std::endl;
 */
#include "Q5-compressStr.h"


char * compressStr(char *str)
{
    int length = getLength(str),i;
    if (length>strlen(str)) {
        return str;
    }
    char *result = new char[length];

    char *runner =result;
    ++str;
    int num = 1;
    while (*str) {
        if (*str == *(str-1)) {
            ++num;
        }else
        {
            concat(runner, (str-1), num);
            num =1;

        }
        ++str;
    }
    if (num>0) {
        concat(runner, (str-1), num);
    }
    *runner='\0';
    return result;
}

int getLength(char *str)
{
    char * runner = str;
    ++runner;
    int num_length = 1,length =0;
    while (*runner) {
        if (*runner == *(runner-1)) {
            ++num_length;
        }else
        {
            length+=1+getDigit(num_length);
            num_length =0;
        }
        ++runner;
    }
    if (num_length>0) {
        length += 1+getDigit(num_length);
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
    if (length == 0) {
        return 1;
    }
    return length;
}

void concat(char * &str, char *ch, int num)
{
    *str= *ch; ++str;
    while (num>0) {
        *str = '0' + num % 10;
        num /= 10;
        ++str;
    }
}

//useless
void itoa(int n, char* s) {
	int i = 0;
	do {
	    s[i++] = n%10+'0';
	} while ((n/=10) > 0);
    s[i] = '\0';
}