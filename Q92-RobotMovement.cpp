//
//  Q92-RobotMovement.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/14/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//
/*
 countPathsForRobot(2, 2, new char[4], 4);
 cout<<"====="<<endl;
 char * path = new char[4];
 cout<<findPathsForRobot(2, 2, path, 4)<<endl;
 for (int i = 0; i < 4; ++i) {
 cout<<path[i];
 }
*/
#include "Q92-RobotMovement.h"

bool countPathsForRobot(int x, int y, char path[], int length)
{
    if (x == 0 && y == 0) {
        int i = 0;
        for (; i < length; ++i) {
            std::cout<<path[i]<<" ";
        }
        std::cout<<std::endl;
        return true;
    }
    bool result = false;
    if (x > 0 && isFree(x - 1, y)) {
        path[x+y-1] = 'R';
        result = countPathsForRobot(x - 1, y, path, length);
    }
    //path[x+y-1]= ' ';
    
    if (y > 0 && isFree(x, y - 1)) {
        path[x+y-1] = 'D';
        result = countPathsForRobot(x, y - 1, path, length);
    }
    //path[x+y-1]= ' ';
    return result;
}

bool isFree(int x, int y)
{
    if (x == 1 && y == 1) {
        return false;
    }
    return true;
}
hash_map<Point*, bool> cache;
bool findPathsForRobot(int x, int y, char path[], int length)
{
    Point *p = new Point(x,y);
    if (cache[p] != 0) {
        return cache[p] == 2?true:false;
    }
    if (x == 0 && y == 0) {
        return true;
    }
    bool success = false;
    
    if (x > 0 && isFree(x - 1, y)) {
        path[x+y-1] = 'R';
        success = findPathsForRobot(x - 1, y, path, length);
    }
    
    if (y > 0 && isFree(x, y - 1)) {
        path[x+y-1] = 'D';
        success = findPathsForRobot(x, y - 1, path, length);
    }
    
    if (!success) {
        path[x+y-1] = '0';
    }
    
    cache[p] = success?2:1; //success 2 fail 1
    return success;
}

