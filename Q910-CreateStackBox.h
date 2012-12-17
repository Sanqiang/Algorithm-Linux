//
//  Q910-CreateStackBox.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q910_CreateStackBox__
#define __Algorithm_Linux__Q910_CreateStackBox__

#include <iostream>
using namespace std;
#include <set>
#include <ext/hash_map>
using namespace __gnu_cxx;
class Box {
public:
    int width;
    int depth;
    int height;
    Box(int w,int d,int h):width(w),depth(d),height(h)
    {
        
    }
    
    bool isLarger(Box *another){
        if (!another) {
            return true;
        }
        return width > another->width && height > another->height && depth > another->depth;
    }
    
    void print()
    {
        std::cout<<"Width:"<<width<<" Depth:"<<depth<<" Height:"<<height<<std::endl;
    }
};
set<Box*> createStackBox(Box *list[], int length, Box *bottom);
#endif /* defined(__Algorithm_Linux__Q910_CreateStackBox__) */
