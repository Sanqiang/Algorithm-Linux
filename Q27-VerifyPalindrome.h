//
//  Q27-VerifyPalindrome.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/7/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q27_VerifyPalindrome__
#define __Algorithm_Linux__Q27_VerifyPalindrome__

#include <iostream>
#include "Entity.h"
bool isPalindrome(LinkedListElement<char> *head);
bool isPalindromeHelperWhole(LinkedListElement<char> *&left, LinkedListElement<char> *right, int &current, int length);
bool isPalindromeHelperHalf(LinkedListElement<char> *&left, LinkedListElement<char> *&right, int length);

bool isPalindromeWithWrapper(LinkedListElement<char> *head);
class PalindromeHelperWrapper
{
public:
    LinkedListElement<char> *Right;
    bool Result;
    PalindromeHelperWrapper(LinkedListElement<char> *right, bool result):Right(right),Result(result){}
};
PalindromeHelperWrapper * isPalindromeWithWrapperHelper(LinkedListElement<char> *left, int length);

#include <stack>
bool isPalindromeWithStack(LinkedListElement<char> *head);
#endif /* defined(__Algorithm_Linux__Q27_VerifyPalindrome__) */
