package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class CloneGraph {
	/**
	 * @param node:
	 *            A undirected graph node
	 * @return: A undirected graph node
	 */
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) {
			return null;
		}
		UndirectedGraphNode nnode = new UndirectedGraphNode(node.label);
		HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		
		q.add(node);
		map.put(node, nnode);
		while (!q.isEmpty()) {
			UndirectedGraphNode temp = q.poll();
			if(!map.containsKey(temp)){
				map.put(temp, new UndirectedGraphNode(temp.label));
			}
			UndirectedGraphNode ntemp = map.get(temp);
			
			for(UndirectedGraphNode temp_loop : temp.neighbors){
				if(!map.containsKey(temp_loop)){
					map.put(temp_loop, new UndirectedGraphNode(temp_loop.label));
					q.add(temp_loop);
				}
				UndirectedGraphNode ntemp_loop = map.get(temp_loop);
				ntemp.neighbors.add(ntemp_loop);
			}
		}

		return nnode;
	}
}
