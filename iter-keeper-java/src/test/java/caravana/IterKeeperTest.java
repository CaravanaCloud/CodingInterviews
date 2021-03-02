package caravana;

import java.util.*;
import org.junit.*;

import static org.junit.Assert.*;

public class IterKeeperTest{
    @Test
    public void testIter(){
        List<Integer> xs = List.of(1,2,3);
        Iterator<Integer> orig = xs.iterator();
        Iterable<Integer> it = IterKeeper.iterOf(orig);
        Iterator<Integer> itA = it.iterator();
        Integer a1 = itA.next();
        Integer a2 = itA.next();
        Integer a3 = itA.next();
        Iterator<Integer> itB = it.iterator();
        Integer b1 = itB.next();
        Integer b2 = itB.next();
        assertEquals((Integer) a1,(Integer) 1);
        assertEquals((Integer) a2,(Integer) 2);
        assertEquals((Integer) a3,(Integer) 3);
        assertEquals((Integer) b1,(Integer) 1);
        assertEquals((Integer) b2,(Integer) 2);
    }
}