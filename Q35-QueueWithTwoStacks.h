//
//  Q35-QueueWithTwoStacks.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/10/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q35_QueueWithTwoStacks__
#define __Algorithm_Linux__Q35_QueueWithTwoStacks__

#include <iostream>
#include "Entity.h"

template <typename Type>
class Myqueue {
    Stack<Type> *Left;
    Stack<Type> *Right;
public:
    Myqueue()
    {
        Left = new Stack<Type>();
        Right = new Stack<Type>();
    }
    
    void enqueue(Type input)
    {
        Left->push(input);
    }
    
    Type dequeue()
    {
        if (Right->size <= 0) {
            while (Left->size > 0) {
                Right->push(Left->pop());
            }
        }
        return Right->pop();
    }
    
    void print()
    {
        std::cout<<"S1:";
        Left->print();
        std::cout<<std::endl;
        std::cout<<"S2:";
        Right->print();
        std::cout<<std::endl;
    }
    
};

#endif /* defined(__Algorithm_Linux__Q35_QueueWithTwoStacks__) */
