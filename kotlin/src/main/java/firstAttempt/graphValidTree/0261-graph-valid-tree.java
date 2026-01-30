package firstAttempt.graphValidTree;

import java.util.*;

record JPair<A, B>(A first, B second) {}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        var graph = buildGraph(n, edges);

        var visited = new HashSet<Integer>();
        var hasCycle = hasCycle(0, graph, visited);

        return !hasCycle && visited.size() == n;
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] edges) {
        var graph = new HashMap<Integer, List<Integer>>();

        for (var edge : edges) {
            var from = edge[0];
            var to = edge[1];

            var fromNodes = graph.getOrDefault(from, new ArrayList<>());
            fromNodes.add(to);
            graph.put(from, fromNodes);

            var toNodes = graph.getOrDefault(to, new ArrayList<>());
            toNodes.add(from);
            graph.put(to, toNodes);
        }

        return graph;
    }

    private boolean hasCycle(int startNode,
                             Map<Integer, List<Integer>> graph,
                             Set<Integer> visited) {
        var stack = new LinkedList<JPair<Integer, Integer>>();
        stack.add(new JPair<>(null, startNode));

        var nodeToPreviousNode = new HashMap<Integer, Integer>();

        while (!stack.isEmpty()) {
            var pair = stack.pop();
            var from = pair.first();
            var node = pair.second();

            var previousFrom = nodeToPreviousNode.get(node);
            if (nodeToPreviousNode.containsKey(node) && !Objects.equals(previousFrom, from)) {
                return true;
            }

            if (visited.contains(node)) {
                continue;
            }

            if (from != null) nodeToPreviousNode.put(node, from);
            visited.add(node);

            var neighboringNodes = graph.getOrDefault(node, List.of());
            for (var neighbourNode : neighboringNodes) {
                if (neighbourNode.equals(node)) {
                    return true;
                }

                if (!visited.contains(neighbourNode)) {
                    stack.push(new JPair<>(node, neighbourNode));
                }
            }
        }

        return false;
    }
}