//
//  Q92-RobotMovement.h
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/14/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#ifndef __Algorithm_Linux__Q92_RobotMovement__
#define __Algorithm_Linux__Q92_RobotMovement__

#include <iostream>
#include <ext/hash_map>
#include <string>
using namespace __gnu_cxx;
bool countPathsForRobot(int x, int y, char path[], int length);
bool isFree(int x, int y);

class Point {
public:
    int x;
    int y;
    Point(int _x, int _y)
    {
        x = _x;
        y = _y;
    }
};
bool findPathsForRobot(int x, int y, char path[], int length);
#endif /* defined(__Algorithm_Linux__Q92_RobotMovement__) */
