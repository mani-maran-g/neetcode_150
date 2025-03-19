public class MaxAreaOfIsLand {

    public static int maxAreaOfIsland(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int maxArea = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (visited[row][col] || grid[row][col] == '0')
                    continue;

                maxArea = Math.max(maxArea, dfs(grid, visited, new Cell(row, col), new int[1]));
            }
        }

        return maxArea;

    }

    static int dfs(char[][] grid, boolean[][] visited, Cell currCell, int[] nodeCount) {
        int n = grid.length;
        int m = grid[0].length;
        if (currCell.row < 0 || currCell.row >= n || currCell.col < 0 || currCell.col >= m
                || grid[currCell.row][currCell.col] != '1' || visited[currCell.row][currCell.col])
            return nodeCount[0];

        visited[currCell.row][currCell.col] = true;
        nodeCount[0]++;

        int[] dRow = new int[] { -1, 0, 1, 0 };
        int[] dCol = new int[] { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            dfs(grid, visited, new Cell(currCell.row + dRow[i], currCell.col + dCol[i]), nodeCount);
        }

        return nodeCount[0];

    }

    public static void main(String[] args) {
        char[][][] testCases = new char[][][] {
                {
                        { '0', '1', '1', '1', '0' },
                        { '0', '1', '0', '1', '0' },
                        { '1', '1', '0', '0', '0' },
                        { '0', '0', '0', '0', '0' }
                },

                {
                        { '1', '1', '0', '0', '1' },
                        { '1', '1', '0', '0', '1' },
                        { '0', '0', '1', '0', '0' },
                        { '0', '0', '0', '1', '1' }
                },
                {
                        { '0', '1', '1', '0', '1' },
                        { '1', '0', '1', '0', '1' },
                        { '0', '1', '1', '0', '1' },
                        { '0', '1', '0', '0', '1' }
                },
        };

        for (char[][] tc : testCases) {
            System.out.println(maxAreaOfIsland(tc));
        }
    }
}
