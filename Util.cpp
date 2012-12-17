//
//  Util.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Util.h"

void itoa(int n, char* s) {
	int i = 0;
	do {
	    s[i++] = n%10+'0';
	} while ((n/=10) > 0);
    s[i] = '\0';
}

string itoa(int n)
{
    string s = "";
	int i = 0;
	do {
        s+=n%10 + '0';
	    //s[i++] = n%10+'0';
	} while ((n/=10) > 0);
    //s[i] = '\0';
    return s;
}