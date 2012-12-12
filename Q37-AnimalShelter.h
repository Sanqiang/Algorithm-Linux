//
//  Q37-AnimalShelter.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/10/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q37_AnimalShelter__
#define __Algorithm_Linux__Q37_AnimalShelter__

#include <iostream>
#include "Entity.h"

virtual class IAnimal {
protected:
    int Order = 0;
public:
    int getOrder()
    {
        return Order;
    }
    
    void setOrder(int val)
    {
        Order = val;
    }
};


class Dog : IAnimal {
public:
    
};

class Cat : IAnimal {
public:
    
};

class AnimalQueue {
private:
    DoublyLinkedList<Dog> *Dogs;
    DoublyLinkedList<Cat> *Cats;
public:
    AnimalQueue()
    {
        Dogs = new DoublyLinkedList<Dog>();
        Cats = new DoublyLinkedList<Cat>();
    }
    
    void enqueue(IAnimal *ani)
    {
        if (typeid(ani) == typeid(Dog)) {
            //Dogs->addToHead(*ani);
        }else
        {
            //Cats->addToHead(ani);
        }
    }

};

#endif /* defined(__Algorithm_Linux__Q37_AnimalShelter__) */
