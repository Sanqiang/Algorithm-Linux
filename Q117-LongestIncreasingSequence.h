//
//  Q117-LongestIncreasingSequence.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/16/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q117_LongestIncreasingSequence__
#define __Algorithm_Linux__Q117_LongestIncreasingSequence__
using namespace std;
#include <iostream>
#include <vector>
class HtWt {
public:
    int height;
    int weight;
    HtWt():height(-1),weight(-1){}
    HtWt(int _height, int _weight):height(_height),weight(_weight)
    {
        
    }
    
    bool isBefore(HtWt * another)
    {
        if (!another) {
            return true;
        }
        return weight>another->weight && height>another->height;
    }

    void print()
    {
        std::cout<<"Weight:"<<weight<<" Height:"<<height<<std::endl;
    }
};
vector<HtWt*> findLongestSequence(HtWt *list[], int length, HtWt *head);

//DP:
#include "QuickSort.h"
#include <ext/hash_map>
using namespace __gnu_cxx;
int CompareHtwt(HtWt *a, HtWt *b);
vector<HtWt*> findLongestSequenceDP(HtWt *list[], int length);
void LongestSubSequence(HtWt *list[], int length, int current_index, vector<HtWt*> solutions[]);
#endif /* defined(__Algorithm_Linux__Q117_LongestIncreasingSequence__) */
