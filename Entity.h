//
//  Entity.h
//  Algorithm-Linux
//
//  Created by SanQ11iang Zhao on 12/6/12.
//  Copyright (c) 2012 SanQ11iang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Entity__
#define __Algorithm_Linux__Entity__

#include <iostream>
//LinkedList Node
template <class Type>
class LinkedListElement {
public:
    LinkedListElement(const Type &value):Data(value),Next(NULL){}
    LinkedListElement(){}
    
    void setNext(LinkedListElement * elem)
    {
        Next=elem;
    }
    void setData(Type value)
    {
        Data=value;
    }
    Type getData()
    {
        return Data;
    }
    LinkedListElement * getNext()
    {
        return Next;
    }
    void print()
    {
        LinkedListElement<Type> *runner = this;
        while (runner) {
            std::cout<<runner->Data<<"";
            runner=runner->getNext();
        }
        std::cout<<std::endl;
    }
    int getLength(){
        int count=0;
        LinkedListElement<Type> *runner = this;
        while (runner) {
            ++count;
            runner=runner->getNext();
        }
        return count;
    }
//private:
    Type Data;
    LinkedListElement * Next;
};
#endif /* defined(__Algorithm_Linux__Entity__) */
