package cloud.caravana.algo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestPairSumAlgo {
    public void testSimpleSum(Function<String, String> algo){
        String input = """
            10
            3
            5
            12
            11
            1
            -1
            6
        """;
        var expected = """
            -1    
            11   
        """;
        var output = algo.apply(input);
        assertEquals(expected, output);
    }

    @Test
    public void testSimpleNaiveSum() {
        testSimpleSum(PairSumAlgo::naivePairSum);
    }

    @Test
    public void testSimpleTunnelSum() {
        testSimpleSum(PairSumAlgo::tunnelPairSum);
    }

    @Test
    public void testSimpleMemoSum() {
        testSimpleSum(PairSumAlgo::naivePairSum);
    }
}
