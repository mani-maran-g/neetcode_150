import java.util.*;

public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        combinationSum(nums, 0, target, new ArrayList<>(), result);

        return result;
    }

    static void combinationSum(int[] nums, int i, int t, List<Integer> cns, List<List<Integer>> res) {
        if (t == 0) {
            res.add(new ArrayList<>(cns));
            return;
        }

        if (i == nums.length || t < 0)
            return;

        cns.add(nums[i]);
        combinationSum(nums, i, t - nums[i], cns, res);
        cns.remove(cns.size() - 1);
        combinationSum(nums, i + 1, t, cns, res);

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationSum2(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    static void combinationSum2(int[] nums, int ind, int t, List<Integer> cns, List<List<Integer>> res) {
        if (t == 0) {
            res.add(new ArrayList<>(cns));
            return;
        }

        for (int i = ind; i < nums.length; i++) {
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] > t)
                break;

            cns.add(nums[i]);
            combinationSum2(nums, i + 1, t - nums[i], cns, res);
            cns.remove(cns.size() - 1);

        }

    }

    public static void main(String[] args) {
        int[][] testCases = new int[][] {
                // {2,5,6,9} ,
                // {3,4,5},
                // {3},
                { 1, 2, 3, 4, 5 },
                { 2, 5, 2, 1, 2 }
        };

        int[] targets = { 7, 5 };

        for (int i = 0; i < testCases.length; i++) {
            // System.out.println(combinationSum(testCases[i], targets[i]));
            System.out.println(combinationSum2(testCases[i], targets[i]));

        }
    }
}