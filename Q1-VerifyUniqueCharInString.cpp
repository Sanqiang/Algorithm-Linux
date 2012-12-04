//
//  Q1-VerifyUniqueCharInString.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/3/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 string str = "daa";
 std::cout<<(isUniqueChar(str))<<std::endl;
 std::cout<<(isUniqueCharLessSpace(str))<<std::endl;
*/ 
#include "Q1-VerifyUniqueCharInString.h"

bool isUniqueChar(string str)
{
    unsigned long length=str.length();
    int i;
    bool * tab = new bool[0xff];
    if (length > 0xff) {
        return false;
    }
    for (i=0; i<0xff; ++i) {
        tab[i]=false;
    }
    for (i=0; i<length;++i) {
        if (tab[str[i]]) {
            return false;
        }
        tab[str[i]]=true;
    }
    return true;
}

bool isUniqueCharLessSpace(string str)
{
    unsigned long length=str.length();
    int i;
    if (length > 0xff) {
        return false;
    }
    unsigned int checker = 0;//32 bit, we only need 26 bit
    for (i=0; i<length; ++i) {
        if (checker & (1<<(str[i] - 'a'))) {
            return false;
        }
        checker |= (1<<(str[i] - 'a'));
    }
    return true;
}