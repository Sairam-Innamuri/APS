class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] e : redEdges) {
            graph[e[0]].add(new int[]{e[1], 0});
        }
        for (int[] e : blueEdges) {
            graph[e[0]].add(new int[]{e[1], 1});
        }

        int[] result = new int[n];
        Arrays.fill(result, -1);
        boolean[][] visited = new boolean[n][2];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); 
        queue.offer(new int[]{0, 1}); 
        visited[0][0] = true;
        visited[0][1] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int node = curr[0];
                int color = curr[1];

                if (result[node] == -1) {
                    result[node] = steps;
                }

                for (int[] nei : graph[node]) {
                    int nextNode = nei[0];
                    int nextColor = nei[1];
                    if (nextColor != color && !visited[nextNode][nextColor]) {
                        visited[nextNode][nextColor] = true;
                        queue.offer(new int[]{nextNode, nextColor});
                    }
                }
            }

            steps++;
        }

        return result;
    }
}