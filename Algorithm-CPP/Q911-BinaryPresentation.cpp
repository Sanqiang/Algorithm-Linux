//
//  Q911-BinaryPresentation.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 string text="1^0|0|1";
 cout<<printBinaryPresentation(text, true, 0, text.length()-1);
*/
#include "Q911-BinaryPresentation.h"
hash_map<string, int> cache_binarypresentation;
int printBinaryPresentation(string text, bool result, int s, int e)
{
    string key = itoa(s) + itoa(e) + itoa(result);
    if (cache_binarypresentation.count(key) > 0) {
        return cache_binarypresentation[key];
    }
    int keys = 0;
    if (s == e) {
        char ch = text[s];
        if (result && ch == '1') {
            return 1;
        }
        else if(!result && ch == '0')
        {
            return 1;
        }
        return 0;
    }
    int i;
    if (result) {
        for (i = s+1; i <= e; i+=2) {
            char ch = text[i];
            switch (ch) {
                case '&':
                    keys += printBinaryPresentation(text, true, s, i-1) * printBinaryPresentation(text, true, i+1, e);
                    break;
                case '|':
                    keys += printBinaryPresentation(text, true, s, i-1) * printBinaryPresentation(text, false, i+1, e);
                    keys += printBinaryPresentation(text, false, s, i-1) * printBinaryPresentation(text, true, i+1, e);
                    keys += printBinaryPresentation(text, true, s, i-1) * printBinaryPresentation(text, true, i+1, e);
                    break;
                case '^':
                    keys += printBinaryPresentation(text, true, s, i-1) * printBinaryPresentation(text, true, i+1, e);
                    keys += printBinaryPresentation(text, false, s, i-1) * printBinaryPresentation(text, false, i+1, e);
                    break;
            }
        }
    }
    else
    {
        for (i = s+1; i <= e; i+=2) {
            char ch = text[i];
            switch (ch) {
                case '&':
                    keys += printBinaryPresentation(text, true, s, i-1) * printBinaryPresentation(text, false, i+1, e);
                    keys += printBinaryPresentation(text, false, s, i-1) * printBinaryPresentation(text, true, i+1, e);
                    keys += printBinaryPresentation(text, false, s, i-1) * printBinaryPresentation(text, false, i+1, e);
                    break;
                case '|':
                    keys += printBinaryPresentation(text, false, s, i-1) * printBinaryPresentation(text, false, i+1, e);
                    break;
                case '^':
                    keys += printBinaryPresentation(text, true, s, i-1) * printBinaryPresentation(text, false, i+1, e);
                    keys += printBinaryPresentation(text, true, s, i-1) * printBinaryPresentation(text, false, i+1, e);
                    break;
            }
        }
    }
    cache_binarypresentation[key] = keys;
    return keys;
}
