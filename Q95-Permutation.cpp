//
//  Q95-Permutation.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 vector<string> temp;
 printPermutation("abc", 0, temp);
 vector<string> list_permutation = printPermutation2("abc");
 for (int i = 0; i < list_permutation.size(); ++i) {
 cout<<list_permutation[i]<<endl;
 }
*/
#include "Q95-Permutation.h"
void printPermutation(string str, int b, vector<string> permutation_list)
{
    if (b == str.length()) {
        for (int i = 0; i < permutation_list.size(); ++i) {
            std::cout<<permutation_list[i]<<std::endl;
        }
        return;
    }
    
    string c = str.substr(b, 1);
    if (b == 0) {
        permutation_list.push_back(c);
        printPermutation(str, b+1, permutation_list);
    }
    else
    {
        vector<string> temp;
        int i = 0;
        for (; i < permutation_list.size(); ++i) {
            string temp_str = permutation_list[i];
            for (int bb = 0; bb <= temp_str.length(); ++bb) {
                temp.push_back(injection(temp_str, c, bb));
            }
        }
        printPermutation(str, b + 1, temp);
    }
    
    
}

string injection(string text, string ch, int i)
{
    string left = text.substr(0, i);
    string right = text.substr(i);
    return left + ch + right;
}

vector<string> printPermutation2(string str)
{
    vector<string> current_list;
    if (str.length() == 0) {
        vector<string> list;
        list.push_back("");
        return list;
    }
    string c = str.substr(0, 1);
    string remainder = str.substr(1);
    vector<string> list = printPermutation2(remainder);
    for (int i = 0; i < list.size(); ++i) {
        string temp_str = list[i];
        for (int b = 0; b <= temp_str.length(); ++b) {
            current_list.push_back(injection(list[i], c, b));
        }
    }
    return current_list;
}