import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        // Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();

        Arrays.sort(nums);
        subsetsWithDup(nums, 0, new ArrayList<>(), list);
        return list;
    }

    public static void subsetsWithDup(int[] nums, int ind, List<Integer> ds, List<List<Integer>> res) {
        res.add(new ArrayList<>(ds));

        for (int i = ind; i < nums.length; i++) {
            if (i != ind && nums[i] == nums[i - 1])
                continue;

            ds.add(nums[i]);
            subsetsWithDup(nums, i + 1, ds, res);
            ds.remove(ds.size() - 1);

        }
    }

    public static void main(String[] args) {
        int[][] testCases = new int[][] {
                { 1, 2, 1 },
                { 7, 7 },
                { 3, 4, 3 }
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println(subsetsWithDup(testCases[i]));

        }
    }
}
