package firstAttempt.numberOfConnectedComponentsInUndirectedGraph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

// https://neetcode.io/problems/count-connected-components?list=blind75
class Solution {
    public int countComponents(int n, int[][] edges) {
        var nodeToConnectionsMap = new HashMap<Integer, Set<Integer>>();

        //n=3
        //[0,1], [1,2], [2,3], [4,5]
        // 0 -> 1 -> 2 -> 3
        // 4 -> 5

        // 0: 1,
        // 1: 0, 1
        // 2: 1, 3
        // 3: 2
        //

        for (var edge : edges) {
            var first = edge[0];
            var second = edge[1];

            var firstConnections = nodeToConnectionsMap.getOrDefault(first, new HashSet<>());
            var secondConnections = nodeToConnectionsMap.getOrDefault(second, new HashSet<>());

            firstConnections.add(second);
            secondConnections.add(first);

            nodeToConnectionsMap.put(first, firstConnections);
            nodeToConnectionsMap.put(second, secondConnections);
        }

        var networksCount = 0;
        var visited = new HashSet<Integer>();
        for (var node = 0; node < n; node++) {
            if (!visited.contains(node)) {
                markConnected(visited, nodeToConnectionsMap, node);

                networksCount++;
            }
        }

        return networksCount;
    }

    private void markConnected(Set<Integer> visited,
                               Map<Integer, Set<Integer>> nodeToConnectionsMap,
                               int node) {
        var nextNodes = new LinkedList<Integer>();
        nextNodes.add(node);

        while (!nextNodes.isEmpty()) {
            var nextNode = nextNodes.removeFirst();

            if (visited.contains(nextNode)) {
                continue;
            } else {
                visited.add(nextNode);
            }

            var connections = nodeToConnectionsMap.getOrDefault(nextNode, new HashSet<>());
            nextNodes.addAll(connections);
        }
    }
}