//
//  Q117-LongestIncreasingSequence.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 HtWt *list[] = {
 new HtWt(1, 1),
 new HtWt(2, 2),
 new HtWt(2, 1),
 new HtWt(2, 3),
 new HtWt(4, 4),
 };
 vector<HtWt*> v = findLongestSequence(list, 5, NULL);
 
 vector<HtWt*>::iterator it = v.begin();
 for (; it != v.end(); ++it) {
 (*it)->print();
 }
 cout<<"============="<<endl;
 vector<HtWt*> v2 = findLongestSequenceDP(list, 5);
 vector<HtWt*>::iterator it2 = v2.begin();
 for (; it2 != v2.end(); ++it2) {
 (*it2)->print();
 }
*/
#include "Q117-LongestIncreasingSequence.h"

vector<HtWt*> findLongestSequence(HtWt *list[], int length, HtWt *head)
{
    int i = 0;
    vector<HtWt*> longest;
    for (; i < length; ++i) {
        if (list[i]->isBefore(head)) {
            vector<HtWt*> v = findLongestSequence(list, length, list[i]);
            if (longest.size() < v.size()) {
                longest = v;
            }
        }
    }
    
    if (head) {
        longest.push_back(head);
    }
    
    return longest;
}

//DP:
vector<HtWt*> findLongestSequenceDP(HtWt *list[], int length)
{
    QuickSort(list, length, CompareHtwt);
    vector<HtWt*> *solutions = new vector<HtWt*>[length];
    LongestSubSequence(list, length, 0, solutions);
    
    vector<HtWt*> longest;
    for (int i = 0; i < length; ++i) {
        if (longest.size() < solutions[i].size()) {
            longest = solutions[i];
        }
    }
    return longest;
}

void LongestSubSequence(HtWt *list[], int length, int current_index, vector<HtWt*> solutions[])
{
    if (length == current_index) {
        return;
    }
    vector<HtWt*> longest;
    int i = 0;
    for (; i < current_index; ++i) {
        if (list[current_index]->isBefore(list[i]) && longest.size() < solutions[i].size()) {
            longest = solutions[i];
        }
    }
    vector<HtWt*> newsolution;
    for (i = 0; i < longest.size(); ++i) {
        newsolution.push_back(longest[i]);
    }
    newsolution.push_back(list[current_index]);
    solutions[current_index] = newsolution;
    
    LongestSubSequence(list, length, current_index+1, solutions);
}


int CompareHtwt(HtWt *a, HtWt *b)
{
    if (a->height > b->height) {
        return 1;
    }else if(a->height < b->height)
    {
        return -1;
    }else
    {
        if (a->weight > b->weight) {
            return 1;
        }else if(a->weight < b->weight)
        {
            return -1;
        }else
        {
            return 0;
        }
    }
}