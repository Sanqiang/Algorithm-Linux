//
//  Q52-PrintBinary.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q52-PrintBinary.h"
/*
 double num = 10.625;
 cout<<printBinary(num);
*/
string printBinary(double num)
{
    string binary = "";
    int integ = (int)num;
    double decimal = num - (double)integ;
    while (integ > 0) {
        if (integ % 2 > 0) {
            binary.insert(0, "1");
        }else{
            binary.insert(0, "0");
        }
        integ >>= 1;
    }
    if (decimal > 0) {
        binary.append(".");
    }
    int precision = 0;
    while (decimal != 0 && precision++ < precision_limit) {
        decimal *= 2;
        if (decimal >= 1)
        {
            binary.append("1");
            decimal -= 1;//(int)decimal;
        }
        else
        {
            binary.append("0");
        }
    }
    return binary;
}