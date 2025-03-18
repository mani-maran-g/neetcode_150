import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {

        if (board.length == 1 && board[0].length == 1)
            return Character.toString(board[0][0]).equals(word);

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char letter = board[row][col];

                if (letter != word.charAt(0))
                    continue;

                List<Integer> path = new ArrayList<>();
                path.add(row);
                path.add(col);

                if (searchWord(board, path, word, 0, new HashSet<>()))
                    return true;
            }
        }

        return false;
    }

    static boolean searchWord(char[][] board, List<Integer> path, String word, int ind, Set<List<Integer>> prevPaths) {

        if (ind == word.length())
            return true;

        int row = path.get(0);
        int col = path.get(1);

        if (row >= board.length || row < 0)
            return false;

        if (col >= board[row].length || col < 0)
            return false;

        char letter = board[row][col];

        if (letter != word.charAt(ind))
            return false;

        List<Integer> top = new ArrayList<>();
        top.add(row - 1);
        top.add(col);

        List<Integer> left = new ArrayList<>();
        left.add(row);
        left.add(col - 1);

        List<Integer> right = new ArrayList<>();
        right.add(row);
        right.add(col + 1);

        List<Integer> bottom = new ArrayList<>();
        bottom.add(row + 1);
        bottom.add(col);

        @SuppressWarnings("unchecked")
        List<Integer>[] paths = (List<Integer>[]) new List[] { top, left, right, bottom };

        for (List<Integer> cPath : paths) {
            if (prevPaths.contains(cPath))
                continue;

            prevPaths.add(path);
            boolean wordFound = searchWord(board, cPath, word, ind + 1, prevPaths);
            prevPaths.remove(path);

            if (wordFound)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {

        char[][][] testCases = {
                {
                        { 'A', 'B', 'C', 'D' },
                        { 'S', 'A', 'A', 'T' },
                        { 'A', 'C', 'A', 'E' }
                },

                {
                        { 'A', 'B', 'C', 'D' },
                        { 'S', 'A', 'A', 'T' },
                        { 'A', 'C', 'A', 'E' }
                },

                {
                        { 'a', 'a' }
                },

                { { 'a', 'a', 'a', 'a' }, { 'a', 'a', 'a', 'a' }, { 'a', 'a', 'a', 'a' } },

        };

        String[] words = { "CAT", "BAT", "aa", "aaaaaaaaaaaaa" };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(exist(testCases[i], words[i]));
        }

    }
}
