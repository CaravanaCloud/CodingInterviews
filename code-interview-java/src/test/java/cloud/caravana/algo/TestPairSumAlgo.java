package cloud.caravana.algo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.function.Function;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestPairSumAlgo {
    static String longInput;

    @BeforeAll
    public static void beforeAll(){
        var input = new StringBuilder();
        input.append("1\n");
        for (int i = 0; i < 99_999_999; i++) {
            input.append("0\n");
        }
        input.append("1\n");
        longInput = input.toString();
    }

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
        var expected = "-1\n11\n";
        var output = algo.apply(input);
        assertEquals(expected, output);
    }

    public void testLongSum(Function<String, String> algo){
        var expected = "0\n1\n";
        var output = algo.apply(longInput);
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

    @Test
    public void testLongNaiveSum() {
        testLongSum(PairSumAlgo::naivePairSum);
    }

    @Test
    public void testLongTunnelSum() {
        testLongSum(PairSumAlgo::tunnelPairSum);
    }

    @Test
    public void testLongMemoSum() {
        testLongSum(PairSumAlgo::memoPairSum);
    }
}
