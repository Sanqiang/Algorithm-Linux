package Lintcode.Base.Ladders.SearchRecursionLadder;

import java.util.ArrayList;

public class TopSort {
	/**
	 * @param graph:
	 *            A list of Directed graph node
	 * @return: Any topological order for the given graph.
	 */
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
		int[] indegree = new int[graph.size()];

		for (DirectedGraphNode node : graph) {
			for (DirectedGraphNode out_degree_node : node.neighbors) {
				++indegree[out_degree_node.label];
			}
		}

		ArrayList<DirectedGraphNode> result = new ArrayList<>();
		for (int i = 0; i < indegree.length; ++i) {
			int idx = updateZeroIndgree(indegree, graph);
			result.add(graph.get(idx));
		}

		return result;
	}

	int updateZeroIndgree(int[] indegree, ArrayList<DirectedGraphNode> graph) {
		for (int i = 0; i < indegree.length; ++i) {
			if (indegree[i] == 0) {
				// update indegree
				for (DirectedGraphNode out_degree_node : graph.get(i).neighbors) {
					--indegree[out_degree_node.label];
				}
				indegree[i] = -1;
				return i;
			}
		}
		return -1;
	}
}