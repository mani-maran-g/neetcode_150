import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(nums, 0, result);
        return result;
    }

    public static void permute(int[] nums, int ind, List<List<Integer>> res) {
        if (ind == nums.length) {
            List<Integer> ds = new ArrayList<Integer>();

            for (int n : nums) {
                ds.add(n);
            }

            res.add(ds);
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            swap(nums, ind, i);
            permute(nums, ind + 1, res);
            swap(nums, ind, i);
        }
    }

    static void swap(int[] arr, int ind1, int ind2) {
        int tmp = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = tmp;
    }

    public static void main(String[] args) {
        int[][] testCases = new int[][] {
                { 1, 2, 3 },
                { 2, 5, 5, 3 },
                { 7 }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(permute(testCases[i]).size());

        }
    }
}
