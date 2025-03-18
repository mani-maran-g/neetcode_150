import java.util.ArrayList;
import java.util.List;

public class NQueens {

    static StringBuilder rowBuilder = new StringBuilder();

    public static List<List<String>> solveNQueens(int n) {
        List<String> board = createBoard(n);

        List<List<String>> solvedQueens = new ArrayList<>();

        solveNQueens(board, 0, solvedQueens);

        return solvedQueens;
    }

    static void solveNQueens(List<String> board, int row, List<List<String>> solutionList) {
        if (row == board.size()) {
            solutionList.add(new ArrayList<>(board));
            return;
        }

        for (int col = 0; col < board.size(); col++) {
            if (!isValidBox(board, row, col))
                continue;

            StringBuilder placeQueen = new StringBuilder(board.get(row));
            placeQueen.setCharAt(col, 'Q');
            board.set(row, placeQueen.toString());

            solveNQueens(board, row + 1, solutionList);

            board.set(row, rowBuilder.toString());

        }
    }

    static boolean isValidBox(List<String> board, int row, int col) {

        // rowvise

        for (int i = 0; i < board.size(); i++) {
            if (board.get(row).charAt(i) == 'Q')
                return false;
        }

        // colwise
        for (int j = 0; j < board.size(); j++) {
            if (board.get(j).charAt(col) == 'Q')
                return false;
        }

        int i = row;
        int j = col;

        while (i >= 0 && j >= 0) {
            if (board.get(i--).charAt(j--) == 'Q')
                return false;
        }

        i = row + 1;
        j = col + 1;

        while (i < board.size() && j < board.size()) {
            if (board.get(i++).charAt(j++) == 'Q')
                return false;
        }

        i = row;
        j = col;

        while (i >= 0 && j < board.size()) {
            if (board.get(i--).charAt(j++) == 'Q')
                return false;
        }

        i = row + 1;
        j = col - 1;

        while (i < board.size() && j >= 0) {
            if (board.get(i++).charAt(j--) == 'Q')
                return false;
        }

        return true;
    }

    static List<String> createBoard(int n) {

        List<String> board = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            rowBuilder.append('.');
        }

        for (int i = 1; i <= n; i++) {
            board.add(rowBuilder.toString());
        }

        return board;
    }

    public static void main(String[] args) {
        int testCase = 4;

        System.out.println(solveNQueens(testCase));
    }
}
