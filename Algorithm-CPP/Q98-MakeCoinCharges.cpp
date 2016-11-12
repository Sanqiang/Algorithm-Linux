//
//  Q98-MakeCoinCharges.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 int ways = makeCoinCharges(10000, 25);
 cout<<ways;
*/
#include "Q98-MakeCoinCharges.h"

int makeCoinCharges(int charge, int current_coin)
{
    int next_coin = 0;
    switch (current_coin) {
        case 25:
            next_coin = 10;
            break;
        case 10:
            next_coin = 5;
            break;
        case 5:
            next_coin = 1;
            break;
        case 1:
            return 1;
            break;
    }
    int ways = 0;
    for (int num = 0; charge - num * current_coin >= 0; ++num) {
        int next_charge = charge - num * current_coin;
        ways += makeCoinCharges(next_charge,next_coin);
    }
    return ways;
}