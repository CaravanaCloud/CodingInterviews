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


    int[] xxs = null;
    int xxs_size = 333;
    int xxs_target = 42;


    @Test
    public void testSimpleNaiveSum() {
        List<Integer[]> result = TrioSum.naiveSum(xs,xs_target);
        Integer[] r0 = result.get(0);
        Integer[] r1 = result.get(1);
        Integer[] r2 = result.get(2);
        assertArrayEquals(r0, e0);
        assertArrayEquals(r1, e1);
        assertArrayEquals(r2, e2);
    }

    @Test
    public void testHardNaiveSum() {
        Random rand = new Random(0);
        xxs = new int[xxs_size];
        for (int i = 0; i < xxs_size ; i++) {
            xxs[i] = (rand.nextBoolean() ? 1 : -1) * rand.nextInt(xxs_size);
        }
        List<Integer[]> result = TrioSum.naiveSum(xxs,xxs_target);
        assertEquals(6911, result.size());
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
