//
//  Q33-SetOfStacks.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/10/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q33_SetOfStacks__
#define __Algorithm_Linux__Q33_SetOfStacks__

using namespace std;
#include <iostream>
#include <vector>
#include <stack>
#include "Entity.h"

#define capacity_stack 3

template <typename Type>
class SetOfStacks {
    vector<stack<char>*> *stack_list;
public:
    SetOfStacks()
    {
        stack_list = new vector<stack<Type>*>();
    }
    
    stack<Type> * getLastStack()
    {
        if (stack_list->size() == 0) {
            return NULL;
        }
        stack<Type> *LastStack = stack_list->operator[](stack_list->size()-1);
        return LastStack;
    }
    
    void push(Type input)
    {
        stack<Type> *LastStack = getLastStack();
        if (NULL == LastStack || LastStack->size() == capacity_stack) {
            stack<Type> *s = new stack<Type>();
            s->push(input);
            stack_list->push_back(s);
        }else{
            LastStack->push(input);
        }
    }
    
    Type pop()
    {
        stack<Type> *LastStack = getLastStack();
        char pending = LastStack->top();
        LastStack->pop();
        if (LastStack->size() == 0) {
            stack_list->pop_back();
        }
        return pending;
    }
    
    Type popAt(int n)
    {
        //See the second Implementation
        return 0;
    }
    
    
    void print()
    {
        unsigned long stack_list_length = stack_list->size(); int i = 0;
        std::cout<<"Report:"<<std::endl;
        for (; i < stack_list_length; ++i) {
            stack<char> *Stack = stack_list->operator[](i);
            int j = 0; unsigned long stack_item_length = Stack->size();
            for (; j < stack_item_length; ++j) {
                std::cout<<Stack->top();
            }
            std::cout<<std::endl;
        }
        std::cout<<"End Report"<<std::endl;
    }
};

template <typename Type>
class SetOfStacks2 {
private:
    vector<Stack<Type>*> *stack_list;
public:
    SetOfStacks2()
    {
        stack_list = new vector<Stack<Type>*>();
    }
    
    void push(Type input)
    {
        Stack<Type> *LastStack = getLastStack();
        if (LastStack == NULL || LastStack->size == capacity_stack) {
            Stack<Type> *s = new Stack<Type>();
            s->push(input);
            stack_list->push_back(s);
        }else{
            LastStack->push(input);
        }
    }
    
    Type pop()
    {
        Stack<Type> *LastStack = getLastStack();
        Type pending = LastStack->pop();
        if (LastStack->size == 0) {
            stack_list->pop_back();
        }
        return pending;
    }
    
    Type popAt(int n)
    {
        Stack<Type> *CurrentStack = stack_list->operator[](n);
        Type pending = CurrentStack->pop();
        if (n != stack_list->size()-1) {
            shift(n);            
        }
        return pending;
    }
    
    void shift(int n)
    {
        Stack<Type> *CurrentStack = stack_list->operator[](n);
        if (n == stack_list->size()-1) {
            return;
        }
        Stack<Type> *NextStack = stack_list->operator[](1+n);
        CurrentStack->push(NextStack->popAtBottom());
        shift(n + 1);
    }
    
    Type popAt2(int n)
    {
        return LeftShift(n, true);
    }
    
    Type LeftShift(int n, bool top)
    {
        Stack<Type> *CurrentStack = stack_list->operator[](n);
        if (n < stack_list->size()-1) {
            Type val  = LeftShift(n+1, false);
            CurrentStack->push(val);
        }
        Type t;
        if (top) {
            t = CurrentStack->pop();
        }else{
            t = CurrentStack->popAtBottom();
        }
        return t;
    }
    
    Stack<Type> * getLastStack()
    {
        if (stack_list->size() == 0) {
            return NULL;
        }
        Stack<Type> *LastStack = stack_list->operator[](stack_list->size()-1);
        return LastStack;
    }
    
    void print()
    {
        int i = 0; unsigned long length = stack_list->size();
        for (; i<length; ++i) {
            stack_list->operator[](i)->print();
        }
    }
};

#endif /* defined(__Algorithm_Linux__Q33_SetOfStacks__) */
