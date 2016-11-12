//
//  Q910-CreateStackBox.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 Box * b[] = {
 new Box(1,1,1),
 new Box(2,1,1),
 new Box(1,2,1),
 new Box(2,2,2),
 new Box(3,3,3),
 new Box(4,4,4),
 };
 set<Box*> s = createStackBox(b, 6, NULL);
 cout<<s.size()<<endl;
 set<Box*>::iterator it;
 for (it = s.begin(); it != s.end(); ++it) {
 (*it)->print();
 }
*/
#include "Q910-CreateStackBox.h"
hash_map<Box*, set<Box*>> cache_stackbox;
set<Box*> createStackBox(Box *list[], int length, Box *bottom)
{
    if (bottom && cache_stackbox.count(bottom) > 0) {
        return cache_stackbox[bottom];
    }
    
    int i = 0;
    set<Box*> tallest;
    for (; i < length; ++i) {
        if (list[i]->isLarger(bottom)) {
            set<Box*> s = createStackBox(list, length, list[i]);
            if (s.size() > tallest.size()) {
                tallest = s;
            }
        }
    }
    if (bottom != NULL) {
        tallest.insert(bottom);
    }
    cache_stackbox[bottom] = tallest;
    return tallest;
}