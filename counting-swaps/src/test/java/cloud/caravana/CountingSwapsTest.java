package cloud.caravana;

import static org.junit.Assert.*;

import org.junit.*;
import java.util.*;

import static cloud.caravana.CountingSwaps.*;

public class CountingSwapsTest
{

    @Test(timeout = 10000L)
    public void test50K() {
        List<Integer> xs = new ArrayList<>();
        Random rand = new Random(0);
        for (int i = 0; i < 50000 ; i++) {
            xs.add(rand.nextInt());
        }
        Integer count = countSwaps(xs);
        assertEquals((Integer) 624138870, count);
    }

    @Test
    public void testSeveral() {
        List<Integer> xs = new ArrayList<>();
        xs.add(6); xs.add(5);
        xs.add(5); xs.add(3);
        xs.add(4); xs.add(1);
        xs.add(3); xs.add(0);
        xs.add(2); xs.add(9);
        xs.add(1); xs.add(7);
        Integer count = countSwaps(xs);
        assertEquals((Integer) 29, count);
    }

    @Test
    public void testSimple() {
        List<Integer> xs = new ArrayList<>();
        xs.add(6);
        xs.add(5);
        xs.add(4);
        xs.add(3);
        xs.add(2);
        xs.add(1);
        Integer count = countSwaps(xs);
        assertEquals((Integer) 15, count);
    }

    @Test
    public void testSingle() {
        List<Integer> xs = new ArrayList<>();
        xs.add(2);
        xs.add(1);
        Integer count = countSwaps(xs);
        assertEquals((Integer) 1, count);
    }

    @Test
    public void testAlreadySorted() {
        Integer count = countSwaps(List.of(1, 2, 3));
        assertEquals((Integer) 0, count);
    }

    @Test
    public void testEmpty() {
        Integer count = countSwaps(List.of());
        assertEquals((Integer) 0, count);
    }

    @Test
    public void testNull() {
        Integer count = countSwaps(null);
        assertEquals((Integer) 0, count);
    }
}
