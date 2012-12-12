//
//  Q36-SortStack.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/10/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 Stack<int> *st = new Stack<int>();
 st->push(3);
 st->push(2);
 st->push(1);
 st->push(4);
 st->push(5);
 st->print();
 
 Stack<int> *result = sortStack2(st);
 result->print();
 
 //sortStack(st);
 //st->print();
*/
#include "Q36-SortStack.h"

void sortStack(Stack<int> *&s)
{
    Stack<int> *helper = new Stack<int>();
    while (1) {
        int val = s->pop();
        while (s->size > 0 && s->peek() <= val) {
            helper->push(s->pop());
        }
        s->push(val);
        if (helper->size == 0) {
            return;
        }
        while (helper->size > 0) {
            s->push(helper->pop());
        }
    }
}

Stack<int> * sortStack2(Stack<int> *s)
{
    Stack<int> *helper = new Stack<int>();
    while (s->size > 0) {
        int val = s->pop();
        while (helper->size > 0 && helper->peek() <= val) {
            s->push(helper->pop());
        }
        helper->push(val);
    }
    
    return helper;
}