//
//  Q42-FindRouteBFS.cpp
//  Algorithm-Linux
//
//  Created by Sanqiang Zhao on 12/11/12.
//  Copyright (c) 2012 Sanqiang Zhao. All rights reserved.
//

#include "Q42-FindRouteBFS.h"
/*
 GraphNode<int> *graph = new GraphNode<int>(5);
 graph->AddNode(10);
 graph->AddNode(20);
 
 GraphNode<int> *g1 = graph->getNode(0);
 g1->AddNode(30);
 g1->AddNode(40);
 g1->Nodes.push_back(graph);
 
 GraphNode<int> *remoter = new GraphNode<int>(1);
 g1->Nodes.push_back(remoter);
 
 cout<<isLinkedByBFS(graph, remoter);
*/
bool isLinkedByBFS(GraphNode<int> *left, GraphNode<int> *right)
{
    queue<GraphNode<int>*> q;
    q.push(left);
    while (q.size() > 0) {
        GraphNode<int> *pending = q.front();q.pop();
        if (pending == right) {
            return true;
        }
        pending->state = 1;
        
        int i = 0; unsigned long length = pending->Nodes.size();
        for (; i < length; ++i) {
            if (pending->getNode(i)->state != 1) {
                q.push(pending->getNode(i));
            }
        }
    }
    
    return false;
}