class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, graph, visited);
    }
    private boolean dfs(int node, int dest, List<List<Integer>> graph, boolean[] visited) {
        if (node == dest) return true;
        visited[node] = true;
        for (int nei : graph.get(node)) {
            if (!visited[nei]) {
                if (dfs(nei, dest, graph, visited)) return true;
            }
        }
        return false;
    }
}