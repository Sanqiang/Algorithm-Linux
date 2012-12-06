//
//  Q8-VerifyRotation.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/5/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 cout<<isRotation("abcd", "dabc"); 
 */
#include "Q8-VerifyRotation.h"

bool isSubstring(char *text, char *pattern)
{
    return KmpSearch(text, pattern)>0;
}

bool isRotation(char *left, char *right)
{
    unsigned long length =strlen(left);
    char * copy =(char *) malloc(sizeof(char)*length*2);
    strcpy(copy, left);
    strcat(copy, left);
    return isSubstring(copy, right);
}