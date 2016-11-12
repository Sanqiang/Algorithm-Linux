//
//  Q96-ValidParenthesis.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 printParenthesis(4, 4, 0, new char[8], 8);
 cout<<"====="<<endl;
 std::__1::set<string> s = printParenthesisBad(4);
 std::__1::set<string>::iterator it = s.begin();
 for (; it != s.end(); ++it) {
 cout<<*it<<endl;
 }
*/
#include "Q96-ValidParenthesis.h"

void printParenthesis(int left, int right, int index, char pos[], int length)
{
    if (left == 0 && right == 0) {
        for (int i = 0; i < length; ++i) {
            std::cout<<pos[i];
        }
        std::cout<<std::endl;
    }
    
    if (left > 0) {
        pos[index] = '(';
        printParenthesis(left - 1, right, index + 1, pos, length);
    }
    
    if (right > left) {
        pos[index] = ')';
        printParenthesis(left, right - 1, index + 1, pos, length);
    }
}

set<string> printParenthesisBad(int pair)
{
    set<string> s;
    if (pair == 0) {
        s.insert("");
        return s;
    }
    set<string> last = printParenthesisBad(pair - 1);
    set<string>::iterator it = last.begin();
    for (; it != last.end(); ++it) {
        string temp_str = *it;
        for (int b = 0; b <= temp_str.length(); ++b) {
            string left = temp_str.substr(0,b);
            string right = temp_str.substr(b);
            s.insert(left + "()" + right);
        }
    }
    return s;
}

