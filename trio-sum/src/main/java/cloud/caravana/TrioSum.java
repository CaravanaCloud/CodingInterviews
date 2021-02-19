package cloud.caravana;
import java.util.*;

class TrioSum {
    // O(n^3) time - O(n) space
    public static List<Integer[]> naiveSum(int[] xs, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(xs);
        for (int i = 0; i < xs.length - 2; i++) {
            for (int j = i +1; j < xs.length -1; j++) {
                for (int z = j +1; z < xs.length; z++) {
                    if (xs[i] + xs[j] + xs[z]  == targetSum){
                        result.add(new Integer[]{xs[i], xs[j], xs[z]});
                    }
                }
            }
        }
        return result;
    }
}
