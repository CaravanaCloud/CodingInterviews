package cloud.caravana;

import java.util.*;
import org.junit.*;

import static org.junit.Assert.*;

public class PairSumTest {
    int[] xs = new int[]{3,5,-4,11,1,-1,6};
    int[] expected = new int[]{-1,11};

    int[] xxs = null;
    int xxs_size = 1000000;
    int xxs_target = 333;

    @Before
    public void setUp() {
        Random rand = new Random(0);
        xxs = new int[xxs_size];
        for (int i = 0; i < xxs_size ; i++) {
            xxs[i] = rand.nextInt();
        }
    }

    @Test
    public void testSimpleNaiveSum() {
        int[] simple = PairSum.naiveSum(xs,10);
        Arrays.sort(simple);
        assertArrayEquals(simple, expected);
    }

    @Test
    public void testHardNaiveSum() {
        int[] result = PairSum.naiveSum(xxs, xxs_target);
        assertEquals(result[0] + result[1], xxs_target);
    }

    @Test
    public void testSimpleMemoSum() {
        int[] simple = PairSum.memoSum(xs,10);
        Arrays.sort(simple);
        assertArrayEquals(simple, expected);
    }

    @Test
    public void testHardMemoSum() {
        int[] result = PairSum.memoSum(xxs, xxs_target);
        assertEquals(result[0] + result[1], xxs_target);
    }

    @Test
    public void testSimpleTunnelSum() {
        int[] simple = PairSum.tunnelSum(xs,10);
        Arrays.sort(simple);
        assertArrayEquals(simple, expected);
    }

    @Test
    public void testHardTunnelSum() {
        int[] result = PairSum.tunnelSum(xxs, xxs_target);
        assertEquals(result[0] + result[1], xxs_target);
    }



}
