class Solution {
    private int[][] directions = {{1, 0}, {-1, 0},
                                  {0, 1}, {0, -1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();

        int rows = heights.length;
        int cols = heights[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                boolean reachesPacific = canFlow(
                    heights,
                    r,
                    c,
                    new boolean[rows][cols],
                    true
                );

                boolean reachesAtlantic = canFlow(
                    heights,
                    r,
                    c,
                    new boolean[rows][cols],
                    false
                );

                if (reachesPacific && reachesAtlantic) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;    
    }

    public boolean canFlow(int[][] heights, int r, int c, boolean[][] visited, boolean pacific) {
        int rows = heights.length;
        int cols = heights[0].length;

        if (pacific && (r == 0 || c == 0)) {
            return true;
        }

        if (!pacific && (r == rows - 1 || c == cols - 1)) {
            return true;
        }

        if (visited[r][c]) {
            return false;
        }

        visited[r][c] = true;

        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];

            if (
                nr >= 0 && nr < rows &&
                nc >= 0 && nc < cols &&
                heights[nr][nc] <= heights[r][c]
            ) {
                if (canFlow(heights, nr, nc, visited, pacific)) {
                    return true;
                }
            }
        }

        return false;
    }
}
