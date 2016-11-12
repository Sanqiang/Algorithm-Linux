//
//  Q34-TowersOfHanoi.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/10/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q34_TowersOfHanoi__
#define __Algorithm_Linux__Q34_TowersOfHanoi__

#include <iostream>
#include "Entity.h"

template <typename Type>
class Hanoi {
public:
    Stack<int> *towers[3];

    Hanoi(int n)
    {
        towers[0] = new Stack<int>();
        towers[1] = new Stack<int>();
        towers[2] = new Stack<int>();
        int i = n;
        for (; i >= 1; --i) {
            towers[0]->push(i);
        }
    }
    
    void move()
    {
        int n = towers[0]->size;
        move(3, 0, 2, 1);
    }
    
    void move(int n, int _origin, int _destination, int _cushion)
    {
        if (n == 0) {
            return;
        }
        move(n-1, _origin, _cushion, _destination);
        Type val = towers[_origin]->pop();
        towers[_destination]->push(val);
        print();
        move(n-1, _cushion, _destination, _origin);
    }
    
    void print()
    {
        std::cout<<"T1:";
        towers[0]->print();
        std::cout<<std::endl;
        std::cout<<"T2:";
        towers[1]->print();
        std::cout<<std::endl;
        std::cout<<"T3:";
        towers[2]->print();
        std::cout<<std::endl;
        std::cout<<"-------------"<<std::endl;
    }
};

#endif /* defined(__Algorithm_Linux__Q34_TowersOfHanoi__) */
