package cloud.caravana;

import static org.junit.Assert.*;
import static cloud.caravana.App.*;

import org.junit.Test;

public class AppTest {
    @Test
    public void testSampleCase() {
        int[] price = new int[] {3, 5, 2, 1, 5, 4, 9, 9, 4, 1};
        int[] dist = new int[] {7, 10, 3, 3, 16, 9, 18, 17, 5, 4};
        int tankSize = 20;

        int totalPrice = calcCheapTrip(tankSize, price, dist);
        System.out.println(totalPrice);
        assertEquals(347, totalPrice );
    }
}
