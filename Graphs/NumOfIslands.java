class NumOfIslands {

    public static int numIslands(char[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int isLandsCount = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (visited[row][col] || grid[row][col] == '0')
                    continue;

                isLandsCount++;
                dfs(grid, visited, new Cell(row, col));
            }
        }

        return isLandsCount;

    }

    static void dfs(char[][] grid, boolean[][] visited, Cell currCell) {
        int n = grid.length;
        int m = grid[0].length;
        if (currCell.row < 0 || currCell.row >= n || currCell.col < 0 || currCell.col >= m
                || grid[currCell.row][currCell.col] != '1' || visited[currCell.row][currCell.col])
            return;

        visited[currCell.row][currCell.col] = true;

        int[] dRow = new int[] { -1, 0, 1, 0 };
        int[] dCol = new int[] { 0, 1, 0, -1 };

        for (int i = 0; i < 4; i++) {
            dfs(grid, visited, new Cell(currCell.row + dRow[i], currCell.col + dCol[i]));
        }

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
        };

        for (char[][] tc : testCases) {
            System.out.println(numIslands(tc));
        }
    }
}