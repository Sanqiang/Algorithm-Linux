//
//  Q94-Subsets.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 //printSubset("abc");
 printSubset2("abc", 0);
*/
#include "Q94-Subsets.h"

void printSubset(string str)
{
    unsigned long length = str.length();
    int count = 1 << length, i = 0;
    
    for (; i < count; ++i) {
        string temp = "";
        int b = 0;
        for (; b < length; ++b) {
            if(((i >> b) & 1) > 0)
            {
                temp+=str[b];
            }
        }
        std::cout<<temp<<std::endl;
    }
}

vector<string> list;
void printSubset2(string str, int n)
{
    if (n == str.length()) {
        for (int i = 0; i < list.size(); ++i) {
            std::cout<<list[i]<<std::endl;
        }
        return;
    }
    if (n == 0) {
        list.push_back("");
        string temp = str.substr(n,1);
        list.push_back(temp);
    }else{
        vector<string> temp;
        unsigned long length = list.size();
        int i = 0;
        for (; i < length; ++i) {
            //list.push_back(list[i] + str[n]);
            temp.push_back(list[i] + str[n]);
        }
        for (i = 0; i < temp.size(); ++i) {
            list.push_back(temp[i]);
        }
    }
    printSubset2(str, n+1);
}