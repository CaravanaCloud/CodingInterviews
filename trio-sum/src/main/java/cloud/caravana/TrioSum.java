package cloud.caravana;
import java.util.*;

class TrioSum {

    // O (n log(n)) time - O(n) space
    public static List<Integer[]> fastSum( int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> result = new ArrayList<>();
        for (int i= 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int currentSum = array[i] + array[left] + array[right];
                if (currentSum == targetSum) {
                    result.add(new Integer[]{array[i], array[left], array[right]});
                    left++;
                    right--;
                } else if (currentSum < targetSum)
                    left++;
                else right--;
            }
        }
        return  result;
    }

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
