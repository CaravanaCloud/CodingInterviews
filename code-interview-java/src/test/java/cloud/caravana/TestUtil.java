package cloud.caravana;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import static cloud.caravana.Util.*;

@QuarkusTest
public class TestUtil {
    
    
    @Test
    public void testIntArrayStartingLines(){
        String lines = """
        1
        2
        3
        """;
        int[] xs = intArrayStartingLine(lines, 1);
        int[] ys = new int[]{2, 3};
        assertArrayEquals(ys, xs);
    }
    
    @Test
    public void testArrayToLines(){
        String lines = arrayToLines(new int[]{1, 2, 3});
        String ys = "1\n2\n3\n";
        assertEquals(ys, lines);
    }

    
}
