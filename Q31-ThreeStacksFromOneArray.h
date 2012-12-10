//
//  Q31-ThreeStacksFromOneArray.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/9/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q31_ThreeStacksFromOneArray__
#define __Algorithm_Linux__Q31_ThreeStacksFromOneArray__

#define default_length_stack 2
#define num_stacks 3
#define length_array default_length_stack*num_stacks
#include <iostream>

class StackData {
public:
    int capacity;
    int start;
    int pointer;
    int size;
    StackData(int _start, int _capacity)
    {
        capacity = _capacity;
        start = _start;
        pointer = _start-1;
        size = 0;
    }
    
    bool isInStack(int n, int total_size)
    {
        if (n >= start && n < start+capacity) {
            return  true;
        }else if (total_size < start+capacity && (n < (start+capacity)%total_size || n>= start))
        {
            return true;
        }
        return false;
    }
};

template <typename Type>
class Stacks {
    Type buffer[length_array];
    StackData *collection[num_stacks];
public:
    Stacks();
    void push(int n, Type input);
    void expand(int n);
    void shift(int n);
    Type pop(int n);
    Type peek(int n);
    int nextElement(int n);
    int previousElement(int n);
    int getTotalSize();
    void test();
};

template <typename Type>
Stacks<Type>::Stacks()
{
    int i = 0;
    for (; i<num_stacks; ++i) {
        collection[i] = new StackData(i*default_length_stack, default_length_stack);
    }
}

template <typename Type>
void Stacks<Type>::push(int n, Type input) {
    StackData *sd = collection[n];
    if (sd->size >= sd->capacity) {
        if (getTotalSize() >= length_array) {
            std::cout<<"out of capacity!!!"<<std::endl;
            return;
        }else
        {
            expand(n);
        }
    }
    ++sd->size;
    sd->pointer = nextElement(sd->pointer);
    buffer[sd->pointer] = input;
    test();
}

template <typename Type>
void Stacks<Type>::expand(int n) {
    StackData *sd = collection[n];
    shift((n+1)%num_stacks);
    ++sd->capacity;
}

template <typename Type>
void Stacks<Type>::shift(int n) {
    StackData *sd = collection[n];
    if (sd->size >= sd->capacity) {
        shift((n+1)%num_stacks);
        ++sd->capacity;
    }
    int i = (sd->start + sd->capacity - 1) % length_array;
    for (; sd->isInStack(i, length_array); i = previousElement(i)) {
        buffer[i] = buffer[previousElement(i)];
    }
    buffer[sd->start] = 0;
    sd->start = nextElement(sd->start);
    sd->pointer = nextElement(sd->pointer);
    --sd->capacity;
}

template <typename Type>
Type Stacks<Type>::pop(int n) {
    StackData *sd = collection[n];
    if (sd->size <= 0) {
        std::cout<<"no element in stack!!!"<<std::endl;
        return -1;
    }
    int val = buffer[sd->pointer];
    buffer[sd->pointer] = 0;
    sd->pointer = previousElement(sd->pointer);
    --sd->size;
    test();
    return val;
}

template <typename Type>
Type Stacks<Type>::peek(int n) {
    StackData *sd = collection[n];
    int val = buffer[sd->pointer];
    return val;
}

template <typename Type>
int Stacks<Type>::nextElement(int n)
{
    if (n + 1 >= length_array) {
        return 0;
    }
    return n+1;
}

template <typename Type>
int Stacks<Type>::previousElement(int n)
{
    if (n-1 <= 0) {
        return length_array-1;
    }
    return n-1;
}

template <typename Type>
int Stacks<Type>::getTotalSize()
{
    int i = 0, size = 0;
    for (; i<num_stacks; ++i) {
        size+=collection[i]->size;
    }
    return size;
}

template <typename Type>
void Stacks<Type>::test()
{
    std::cout<<std::endl;
    int i = 0;
    for (; i< length_array; ++i) {
        std::cout<<buffer[i]<<" ";
    }
    std::cout<<std::endl;
}

#endif /* defined(__Algorithm_Linux__Q31_ThreeStacksFromOneArray__) */
