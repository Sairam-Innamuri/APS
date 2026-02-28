class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        // Step 1: Add all rotten oranges to queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int minutes = 0;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        // Step 2: BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottenThisMinute = false;
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                for (int[] d : directions) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        fresh--;
                        rottenThisMinute = true;
                    }
                }
            }
            if (rottenThisMinute) minutes++;
        }
        return fresh == 0 ? minutes : -1;
    }
}