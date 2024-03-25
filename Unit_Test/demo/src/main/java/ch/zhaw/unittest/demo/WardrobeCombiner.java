package ch.zhaw.unittest.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WardrobeCombiner {

    private int targetSize;

    public WardrobeCombiner(int targetSize) {
        this.targetSize = targetSize;
    }

    public List<List<Integer>> findCombinations(int[] sizes) {
        List<List<Integer>> result = new ArrayList<>();
        findCombinationsRecursive(sizes, targetSize, new ArrayList<>(), result, 0);
        return result;
    }

    private void findCombinationsRecursive(int[] sizes, int target, List<Integer> current, List<List<Integer>> result, int start) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target size for the wardrobe (in cm): ");
        int targetSize = scanner.nextInt();

        WardrobeCombiner wardrobeCombiner = new WardrobeCombiner(targetSize);
        int[] sizes = {50, 75, 100, 120};
        List<List<Integer>> combinations = wardrobeCombiner.findCombinations(sizes);

        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }

        scanner.close();
    }
}

