//
//  Q118-TrackBinarySearchTree.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/17/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q118_TrackBinarySearchTree__
#define __Algorithm_Linux__Q118_TrackBinarySearchTree__

#include <iostream>

class RankNode {
protected:
    int left_size = 0;
public:
    RankNode *Left;
    RankNode *Right;
    int Data;
    RankNode(int _data):Data(_data),Left(NULL),Right(NULL){}
    void Insert(int val)
    {
        if (val < Data) {
            ++left_size;
            if (Left) {
                Left->Insert(val);
            }else{
                RankNode *rn = new RankNode(val);
                Left = rn;
            }
        }else if(val > Data)
        {
            if (Right) {
                Right->Insert(val);
            }else
            {
                RankNode *rn = new RankNode(val);
                Right = rn;
            }
        }
    }
    int getRank(int val)
    {
        if (val < Data) {
            if(!Left) return -1;
            else return Left->getRank(val);
        }else if(val > Data)
        {
            if(!Right) return -1;
            else return 1 + left_size + Right->getRank(val);
        }else
        {
            return left_size;
        }
    }
};

#endif /* defined(__Algorithm_Linux__Q118_TrackBinarySearchTree__) */
