package cloud.caravana;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ProgramTest {

    @Test
    public void caseA(){
        Integer[] expected = {1, 3, 4, 2, 2, 2, 2, 2};
        Integer[] input = {2, 1, 2, 2, 2, 3, 4, 2};
        var array = new ArrayList<>(Arrays.asList(input));
        var toMove = 2;
        var list = Program.moveElementToEnd(array, toMove);
        var result = list.toArray();
        assertArrayEquals(expected, result);
    }

}