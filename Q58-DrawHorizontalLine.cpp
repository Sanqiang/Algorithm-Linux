//
//  Q58-DrawHorizontalLine.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/12/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q58-DrawHorizontalLine.h"

void drawHorizontalLine(byte screen[], int width, int x1, int x2, int y)
{
    int full_x1 = x1 / 8;
    int offset_x1 = x1 % 8;
    if (offset_x1 != 0) {
        ++full_x1;
    }
    
    int full_x2 = x2 / 8;
    int offset_x2 = x2 % 8;
    if (offset_x2 != 7) {
        --full_x2;
    }
    
    int i = full_x1;
    for (; i <= full_x2; ++i) {
        screen[y*width/8 + i] = 0xff;
    }
    
    int mask_x1 = (0xff) >> offset_x1;
    int mask_x2 = ~((0xff) >> (offset_x2 + 1));
    if (offset_x1 != 0 || offset_x2 != 7) {
        if (x1/8 == x2/8) {
            int mask = mask_x1 & mask_x2;
            screen[y*width/8 + x1/8] |= mask;
        }else if (offset_x1 != 0) {
            screen[y*width/8 + (full_x1-1)] |= mask_x1;
        }else if (offset_x2 != 7) {
            screen[y*width/8 + (full_x2+1)] |= mask_x2;
        }
    }
}

void printGraph(byte screen[], int length, int width)
{
    int i = 0;
    for (; i < length; ++i) {
        if (printBinary(screen[i]).length() < 8) {
            for (int c = 0; c < 8-printBinary(screen[i]).length(); ++c) {
                std::cout<<"0";
            }
            std::cout<<printBinary(screen[i]);
        }else
        {
            std::cout<<printBinary(screen[i]);
        }
        std::cout<<" ";
        if (i % (width/8) == (width/8 - 1)) {
            std::cout<<std::endl;
        }
        
    }
}