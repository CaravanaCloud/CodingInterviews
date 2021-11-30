package cloud.caravana.algo;

import io.quarkus.test.junit.QuarkusTest;

import static cloud.caravana.algo.SimianAlgo.isSimian;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

@QuarkusTest
public class TestSimianAlgo {
    @Test
    public void testPositiveRight(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTGC", 
            "TTATGT", 
            "TACCCA", 
            "CCCCTA", 
            "TCACTG"};
        assertTrue(isSimian(dna));
    }

    @Test
    public void testPositiveDown(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTGC", 
            "TTATGT", 
            "TACCGA", 
            "CCCCGA", 
            "TCACTG"};
        assertTrue(isSimian(dna));
    }

    @Test
    public void testPositiveDownLeft(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTCC", 
            "TTACGT", 
            "TACCGA", 
            "CCCGGA", 
            "TCACTG"};
        assertTrue(isSimian(dna));
    }

    @Test
    public void testPositiveDownRight(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTCC", 
            "TTACGT", 
            "TACAGA", 
            "CCCAGA", 
            "TCACTG"};
        assertTrue(isSimian(dna));
    }

    @Test
    public void testNegative(){
        var dna = new String[]{
            "ATGCGA", 
            "CAGTTC", 
            "TTTCGT", 
            "TACGGA", 
            "CCCAGA", 
            "TCACTG"};
        assertFalse(isSimian(dna));
    }

    @Test
    public void testNull(){
        var dna = (String[]) null;
        assertFalse(isSimian(dna));
    }

    @Test
    public void testEmpty(){
        var dna = new String[]{};
        assertFalse(isSimian(dna));
    }

    @Test
    public void testEmptier(){
        var dna = new String[]{""};
        assertFalse(isSimian(dna));
    }

    @Test
    public void testInvalidChars(){
        var dna = new String[]{
            "ATGCGX", 
            "CAGTTX", 
            "TTTCGX", 
            "YYYYYX", 
            "CCCAGX", 
            "TCACTX"};
        assertFalse(isSimian(dna));
    }

    @Test
    public void testInvalidMatrix(){
        var dna = new String[]{
            "ATGCGX", 
            "CAGT", 
            "TGX", 
            "", 
            null, 
            "TCACTX"};
        assertFalse(isSimian(dna));
    }


    @Test
    public void testPositiveLong(){
        var dna = new String[]{
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "ATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGA", 
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGC",
            "GTCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGATGCGTC",
            "CAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCAGTGCACCCC"
        };
        assertTrue(isSimian(dna));
    }

    @Test
    public void testStringInterface(){
        var dna = """
                AAAAGX
                CAGTTX
                TTTCGX
                YYYYYX
                CCCAGX
                TCACTX
                """;
        assertTrue(Boolean.valueOf(isSimian(dna)));
    }
}