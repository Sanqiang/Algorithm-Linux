//
//  Q114-encodeUrl.cpp
//  Algorithm-Linux
//
//  Created by SanQ11iang Zhao on 12/3/12.
//  Copyright (c) 2012 SanQ11iang Zhao. All rights reserved.
//
/*
 char * str = "a b c";
 std::cout<<encodeUrl(str);
 */
#include "Q14-encodeUrl.h"

char * encodeUrl(char *url)
{
    unsigned long length = strlen(url);
    while (*url) {
        if (*url == ' ') {
            length+=2;
        }
        ++url;
    }
    
    char *result = new char[length];
    while (*result) ++result;
    --result;--url;
    while (*url) {
        if(*url == ' ')
        {
            *result='0';
            --result;
            *result='2';
            --result;
            *result='%';
            --result;
        }
        else
        {
            *result=*url;
            --result;
        }
        --url;
    }

    ++result;
    return result;
}