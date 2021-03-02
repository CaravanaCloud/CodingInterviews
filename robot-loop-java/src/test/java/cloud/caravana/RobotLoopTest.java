package cloud.caravana;

import static cloud.caravana.RobotLoop.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class RobotLoopTest
{
    @Test
    public void testGR() {
        assertTrue(isLooping("GR"));
    }

    @Test
    public void testAllR() {
        assertTrue(isLooping("R"));
    }

    @Test
    public void testAllG() {
        assertFalse(isLooping("G"));
    }

}
