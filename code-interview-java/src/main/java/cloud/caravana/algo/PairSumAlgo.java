package cloud.caravana.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static cloud.caravana.Util.*;

/**
 * Pairs Sum
 * Given a list of numbers, find the first pair that sums up to a given target.
 *
 * https://www.algoexpert.io/questions/Two%20Number%20Sum
 */
public class PairSumAlgo {
    // O(nlog(n)) time? - O(1) space
    public static int[] tunnelPairSum(int[] xs, int targetSum) {
        Arrays.sort(xs); //Arrays.sort(x[]) is based on the TimSort algorithm, thus O(n log(n))
        int left = 0;
        int right = xs.length - 1;
        while (left < right){
            int sum = xs[left] + xs[right];
            if (sum < targetSum) left++;
            else if (sum > targetSum) right--;
            else return new int[]{ xs[left], xs[right]};
        }

        return new int[]{};
    }

    // O(n) time - O(n) space
    public static int[] memoPairSum(int[] xs, int targetSum) {
        Set<Integer> ms = new HashSet<>();
        for(int x:xs) {
            int target = targetSum - x;
            if(ms.contains(target)){
                return new int[] { target, x };
            }else ms.add(x);
        }
        return new int[]{};
    }

    // O(n^2) time - O(1) space
    public static int[] naivePairSum(int[] xs, int targetSum) {
        for (int i = 0; i < xs.length - 1; i++) {
            for (int j = i +1; j < xs.length; j++) {
                if (xs[i] + xs[j] == targetSum)
                    return new int[]{ xs[i], xs[j]};
            }
        }
        return new int[]{};
    }

    public static String naivePairSum(String input) {
        int targetSum = intFromLine(input, 0);
        int[] xs = intArrayStartingLine(input, 1);
        int[] result = naivePairSum(xs, targetSum);
        Arrays.sort(result);
        return arrayToLines(result);
    }

    public static String tunnelPairSum(String input) {
        int targetSum = intFromLine(input, 0);
        int[] xs = intArrayStartingLine(input, 1);
        int[] result = tunnelPairSum(xs, targetSum);
        Arrays.sort(result);
        return arrayToLines(result);
    }

    public static String memoPairSum(String input) {
        int targetSum = intFromLine(input, 0);
        int[] xs = intArrayStartingLine(input, 1);
        int[] result = memoPairSum(xs, targetSum);
        Arrays.sort(result);
        return arrayToLines(result);
    }
    
}
