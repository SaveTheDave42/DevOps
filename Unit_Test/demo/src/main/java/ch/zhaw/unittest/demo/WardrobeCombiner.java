package ch.zhaw.unittest.demo;

import java.util.ArrayList;
import java.util.List;

public class WardrobeCombiner {

    public static void main(String[] args) {
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> combinations = findCombinations(sizes, 250);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }

    public static List<List<Integer>> findCombinations(int[] sizes, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsRecursive(sizes, target, new ArrayList<>(), result, 0);
        return result;
    }

    private static void findCombinationsRecursive(int[] sizes, int target, List<Integer> current, List<List<Integer>> result, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < sizes.length; i++) {
            if (sizes[i] <= target) {
                current.add(sizes[i]);
                findCombinationsRecursive(sizes, target - sizes[i], current, result, i); // not i + 1 because we can reuse wardrobe elements
                current.remove(current.size() - 1);
            }
        }
    }
}