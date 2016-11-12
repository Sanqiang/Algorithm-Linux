//
//  Q32-StackWithMin.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/9/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q32_StackWithMin__
#define __Algorithm_Linux__Q32_StackWithMin__

#include <iostream>

#define length_stack 5

template <typename Type>
class StacksWithMin {
    Type buffer[length_stack];
    Type min_buffer[length_stack];
    int pointer = -1, min_pointer = -1;
public:
    void push(Type input)
    {
        if (pointer >= length_stack) {
            return;
        }
        if (min_pointer == -1 || min() >= input) {
            min_buffer[++min_pointer]=input;
        }
        buffer[++pointer]=input;
    }
    
    Type pop()
    {
        if (pointer == -1) {
            std::cout<<"No Data!!!"<<std::endl;
            return 0;
        }
        Type pending = buffer[pointer];
        if (pending == min()) {
            min_buffer[min_pointer] = 0;
            --min_pointer;
        }
        buffer[pointer] = 0;
        --pointer;
        return pending;
    }
    
    Type peek()
    {
        if (pointer == -1) {
            std::cout<<"No Data!!!"<<std::endl;
            return 0;
        }
        return buffer[pointer];
    }
    
    Type min()
    {
        if (min_pointer == -1) {
            std::cout<<"No Data!!!"<<std::endl;
            return 0;
        }
        return min_buffer[min_pointer];
    }
};

#endif /* defined(__Algorithm_Linux__Q32_StackWithMin__) */
