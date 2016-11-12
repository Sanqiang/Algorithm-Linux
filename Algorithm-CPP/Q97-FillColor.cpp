//
//  Q97-FillColor.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/15/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q97-FillColor.h"
/*
 int screen[] = {
 0,0,0,0,1,0,0,0,
 0,0,0,1,1,0,0,0,
 1,1,1,1,0,0,0,0,
 0,0,0,0,0,0,0,0,
 0,0,0,0,0,0,0,0,
 0,0,0,0,0,0,0,0,
 0,0,0,0,0,0,0,0,
 };
 printScreen(screen, 56);
 
 fillNewColor(screen, 56, 0, 0, 1);
 
 printScreen(screen, 56);
*/
void fillNewColor(int screen[], int length, int x, int y, int new_color)
{
    if (x <0 || x>screen_width || y < 0 || y > length/screen_width) {
        return;
    }
    int current_pixel = screen[y*screen_width + x];
    if (current_pixel != new_color) {
        screen[y*screen_width + x] = new_color;
        fillNewColor(screen, length, x - 1, y, new_color);
        fillNewColor(screen, length, x + 1, y, new_color);
        fillNewColor(screen, length, x, y - 1, new_color);
        fillNewColor(screen, length, x, y + 1, new_color);
    }
}

void printScreen(int screen[], int length)
{
    for (int i = 0; i < length; ++i) {
        std::cout<<screen[i];
        if (i % screen_width == screen_width - 1 ) {
            std::cout<<std::endl;
        }
    }
}