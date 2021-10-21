package cloud.caravana;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.*;

class CIGPerfTest {
    static List<List<Integer>> input19 = null;

    @BeforeAll
    public static void setup(){
        input19 = Util.parseInput("input19.txt");
    }
    @Test
    public void testCaseA(){
        var a = List.of(1,5);
        var b = List.of(1,6);
        var c = List.of(2,4);
        var bg = List.of(a,b,c);
        var result = CIGPerf.componentsInGraph(bg);
        assertIterableEquals(List.of(2,3), result);
    }

    @Test
    public void testCaseB(){
        var bg = List.of(
                List.of(1,6),
                List.of(2,7),
                List.of(3,8),
                List.of(4,9),
                List.of(2,6));
        var result = CIGPerf.componentsInGraph(bg);
        assertIterableEquals(List.of(2,4), result);
    }

    @Test
    public void testCase0(){
        var bg = of(
                of(1, 17),
                of(5, 13),
                of(7, 12),
                of(5, 17),
                of(5, 12),
                of(2, 17),
                of(1, 18),
                of(8, 13),
                of(2, 15),
                of(5, 20));
        var result = CIGPerf.componentsInGraph(bg);
        assertIterableEquals(of(11,11), result);
    }

    @Test
    //@Timeout(3)
    public void testCase19(){
        var result = CIGPerf.componentsInGraph(input19);
        assertIterableEquals(of(2,866), result);
    }
}