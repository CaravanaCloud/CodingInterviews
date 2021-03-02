package cloud.caravana;
import java.util.*;

class PairSum {

    // O(nlog(n)) time? - O(1) space
    public static int[] tunnelSum(int[] xs, int targetSum) {
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
    public static int[] memoSum(int[] xs, int targetSum) {
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
    public static int[] naiveSum(int[] xs, int targetSum) {
        for (int i = 0; i < xs.length - 1; i++) {
            for (int j = i +1; j < xs.length; j++) {
                if (xs[i] + xs[j] == targetSum)
                    return new int[]{ xs[i], xs[j]};
            }
        }
        return new int[]{};
    }
}
