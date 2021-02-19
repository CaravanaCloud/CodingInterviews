package cloud.caravana;

import java.util.*;
import org.junit.*;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

public class TrioSumTest {
    int[] xs = new int[]{12, 3, 1, 2, -6, 5, -8, 6};
    int xs_target = 0;

    Integer[] e0 = new Integer[]{-8, 2, 6};
    Integer[] e1 = new Integer[]{-8, 3, 5};
    Integer[] e2 = new Integer[]{-6, 1, 5};

    int xxs_target = 42;

    @Test
    public void testSimpleFastSum() {
        List<Integer[]> result = TrioSum.fastSum(xs.clone(),xs_target);
        assertArrayEquals(result.get(0), e0);
        assertArrayEquals(result.get(1), e1);
        assertArrayEquals(result.get(2), e2);
    }

    @Test
    public void testHardFastSum() {
        List<Integer[]> result = TrioSum.fastSum(randomArray(0,333),xxs_target);
        assertEquals(6911, result.size());
    }

    @Test
    public void testSimpleNaiveSum() {
        List<Integer[]> result = TrioSum.naiveSum(xs.clone(),xs_target);
        assertArrayEquals(result.get(0), e0);
        assertArrayEquals(result.get(1), e1);
        assertArrayEquals(result.get(2), e2);
    }

    @Test
    public void testHardNaiveSum() {
        List<Integer[]> result = TrioSum.naiveSum(randomArray(0,333),xxs_target);
        assertEquals(6911, result.size());
    }

    private static int[] randomArray(int seed, int size){
        int[] xxs = null;
        Random rand = new Random(seed);
        xxs = new int[size];
        for (int i = 0; i < size ; i++) {
            xxs[i] = (rand.nextBoolean() ? 1 : -1) * rand.nextInt(size);
        }
        return xxs;
    }

    private void print(List<Integer[]> xxs) {
        for (Integer[] xs: xxs) {
            for (int i = 0; i < xs.length ; i++) {
                System.out.print(xs[i]);
                System.out.print(" ");
            }
            System.out.println("");
        }
    }

}
