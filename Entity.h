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
#include <vector>
using namespace std;
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

template <typename Type>
class DoublyLinkedListElement {
public:
    Type Data;
    DoublyLinkedListElement * Next;
    DoublyLinkedListElement * Previous;
    DoublyLinkedListElement(const Type value):Data(value),Next(NULL),Previous(NULL){}
};

template <typename Type>
class DoublyLinkedList {
    DoublyLinkedListElement<Type> *head;
    DoublyLinkedListElement<Type> *tail;
public:
    DoublyLinkedListElement<Type> * getHead()
    {
        return head;
    }
    
    DoublyLinkedListElement<Type> * getTail()
    {
        return tail;
    }
    
    void addToHead(Type input)
    {
        DoublyLinkedListElement<Type> *dlle = new DoublyLinkedListElement<Type>(input);
        if (!head && !tail) {
            head = dlle;
            tail = dlle;
        }else
        {
            dlle->Next = head;
            head->Previous = dlle;
            head = dlle;
        }
    }
    
    void addToTail(Type input)
    {
        DoublyLinkedListElement<Type> *dlle = new DoublyLinkedListElement<Type>(input);
        if (!head && !tail) {
            head = dlle;
            tail = dlle;
        }else
        {
            dlle->Previous = tail;
            tail->Next = dlle;
            tail = dlle;
        }
    }
    
    Type popAtHead()
    {
        DoublyLinkedListElement<Type> *pending = head;
        Type val = pending->Data;
        
        head = head->Next;
        head->Previous = NULL;
        delete pending;
        
        return val;
    }
    
    Type popAtTail()
    {
        DoublyLinkedListElement<Type> *pending = tail;
        Type val = pending->Data;
        
        pending = pending->Previous;
        pending->Next = NULL;
        delete pending;
        
        return val;
    }
};


/*
 Stack<char> *sta = new Stack<char>();
 sta->push('a');
 sta->push('b');
 sta->print();
 sta->pop();
 sta->print();
*/
template <typename Type>
class Stack {
private:
    DoublyLinkedListElement<Type> *Top, *Bottom;
public:
    int size = 0;
    
    void push(Type input)
    {
        DoublyLinkedListElement<Type> *node = new DoublyLinkedListElement<Type>(input);
        if (!Top && !Bottom) {
            Top = node;
            Bottom = node;
        }else
        {
            join(node, Top);
            Top = node;
        }
        ++size;
    }
    
    Type pop()
    {
        DoublyLinkedListElement<Type> *pending = Top;
        Top = Top->Next;
        Type val = pending->Data;
        delete pending;
        --size;
        return val;
    }
    
    Type peek()
    {
        return Top->Data;
    }
    
    void join(DoublyLinkedListElement<Type> *_top, DoublyLinkedListElement<Type> *_bottom)
    {
        if (_top) {
            _top->Next = _bottom;
        }
        if (_bottom) {
            _bottom->Previous = _top;
        }
    }
    
    void print()
    {
        DoublyLinkedListElement<Type> *runner = Top;
        while (runner) {
            std::cout<<runner->Data<<" ";
            runner = runner->Next;
        }
        std::cout<<std::endl;
    }
    
    Type popAtBottom()
    {
        DoublyLinkedListElement<char> *pending = Bottom;
        Type val = pending->Data;
        Bottom = Bottom->Previous;
        if (Bottom) {
            Bottom->Next = NULL;
        }
        if (Top == pending) {
            Top = Bottom;
        }
        --size;
        delete pending;
        return val;
    }
};

template <typename Type>
class BinaryTreeNode {
public:
    Type Data;
    BinaryTreeNode<Type> *LeftChild;
    BinaryTreeNode<Type> *RightChild;
    BinaryTreeNode<Type> *Parent; //Optional
    BinaryTreeNode(Type val):Data(val),LeftChild(NULL),RightChild(NULL),Parent(NULL)
    {
        
    }
BinaryTreeNode(Type val, BinaryTreeNode<Type> *&l, BinaryTreeNode<Type> *&r):Data(val),LeftChild(l),RightChild(r)
    {
        l->Parent = this;
        r->Parent = this;
    }
};

template <typename Type>
class GraphNode {
public:
    Type Data;
    short state = 0;
    vector<GraphNode*> Nodes;
    GraphNode(Type val):Data(val)
    {
    }
    
    void AddNode(Type input)
    {
        GraphNode *gn = new GraphNode(input);
        Nodes.push_back(gn);
    }
    
    GraphNode * getNode(int index)
    {
        return Nodes[index % Nodes.size()];
    }
};

#endif /* defined(__Algorithm_Linux__Entity__) */
