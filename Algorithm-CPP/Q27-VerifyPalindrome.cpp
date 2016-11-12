//
//  Q27-VerifyPalindrome.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/7/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 LinkedListElement<char> *l1 = new LinkedListElement<char>('a');
 LinkedListElement<char> *l2 = new LinkedListElement<char>('b');
 LinkedListElement<char> *l3 = new LinkedListElement<char>('c');
 LinkedListElement<char> *l4 = new LinkedListElement<char>('b');
 LinkedListElement<char> *l5 = new LinkedListElement<char>('a');
 //LinkedListElement<char> *l6 = new LinkedListElement<char>('a');
 l1->setNext(l2); l2->setNext(l3);l3->setNext(l4);
 l4->setNext(l5); //l5->setNext(l6);
 cout<<isPalindrome(l1)<<isPalindromeWithWrapper(l1)<<isPalindromeWithStack(l1);
 */
#include "Q27-VerifyPalindrome.h"

bool isPalindrome(LinkedListElement<char> *head)
{
    
    int length = head->getLength();
    //int current = 0;
    //return isPalindromeHelperWhole(head, head, current, length);
    return isPalindromeHelperHalf(head, head, length);
}
//Whole Loop
bool isPalindromeHelperWhole(LinkedListElement<char> *&left, LinkedListElement<char> *right, int &current, int length)
{
    if (!right) {
        return true;
    }
    bool result = isPalindromeHelperWhole(left, right->Next, current, length);
    
    if (current >= length-1) {
        return result;
    }
    
    if (left->Data != right->Data) {
        result &= false;
    }
    
    left = left->Next;
    current+=2;
    
    return result;
}
//Half Loop
bool isPalindromeHelperHalf(LinkedListElement<char> *&left, LinkedListElement<char> *&right, int length)
{
    if (length == 2) {
        right = left->Next->Next;
        return left->Data == left->Next->Data;
    }else if(length == 1)
    {
        right = left->Next;
        return true;
    }else if(length == 0)
    {
        return true;
    }
    
    bool result = isPalindromeHelperHalf(left->Next, right, length-2);
    
    if (left->Data != right->Data) {
        result &= false;
    }
    right = right->Next;
    
    return result;
}

bool isPalindromeWithWrapper(LinkedListElement<char> *head)
{
    int length = head->getLength();
    return isPalindromeWithWrapperHelper(head, length)->Result;
}

PalindromeHelperWrapper * isPalindromeWithWrapperHelper(LinkedListElement<char> *left, int length)
{
    if (length == 2) {
        return new PalindromeHelperWrapper(left->Next->Next, left->Data == left->Next->Data);
    }else if(length == 1)
    {
        return new PalindromeHelperWrapper(left->Next, true);
    }else if(length == 0)
    {
        return new PalindromeHelperWrapper(NULL, true);
    }
    
    PalindromeHelperWrapper *result = isPalindromeWithWrapperHelper(left->Next, length-2);
    
    if (!result->Right || !result->Result) {
        return result;
    }else{
    
        result->Result = left->Data == result->Right->Data;
        result->Right = result->Right->Next;

        return result;
    }
}

bool isPalindromeWithStack(LinkedListElement<char> *head)
{
    LinkedListElement<char> *slower = head;
    LinkedListElement<char> *faster = head;
    std::stack<char> stack;
    while (faster && faster->Next) {
        stack.push(slower->Data);
        slower = slower->Next;
        faster = faster->Next->Next;
    }
    
    if (faster) {
        slower=slower->Next;
    }
    
    while (slower) {
        if (slower->Data != stack.top()) {
            return false;
        }
        slower=slower->Next;
        stack.pop();
    }
    
    return true;
}
