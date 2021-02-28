package cloud.caravana;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        testCheapTrip();
    }

    public static void testCheapTrip() {
        int[] price = new int[] {3, 5, 2, 1, 5, 4, 9, 9, 4, 1};
        int[] dist = new int[] {7, 10, 3, 3, 16, 9, 18, 17, 5, 4};
        int tankSize = 20;

        int totalPrice = calcCheapTrip(tankSize, price, dist);
        System.out.println(totalPrice);
    }

    public static int calcCheapTrip(int tankSize, int[] prices, int[] dists) {
        int[] thePrices = ArrayUtils.add(prices, 0, 9999);
        int[] theDists =  ArrayUtils.add(dists, 0, 0);
        return calcCheapTrip(tankSize, tankSize, 0, thePrices, theDists);
    }

    public static int calcCheapTrip(int tankSize, int combLeft, int i, int[] prices, int[] dists) {
        int lastNode = (dists.length - 1);
        if (i >= lastNode) {
            return 0;
        }
        int bestPrice = prices[i];
        int bestLoc = i;
        int distToTravel = 0;
        int bestDist = 0;
        int lastBestLoc = -1;
        int lastBestPrice = 99999;
        int lastBestDist = 0;
        int x = i + 1;
        for (; x < lastNode; ++x) {
            if ((distToTravel + dists[x]) > tankSize) {
                break;
            }
            distToTravel += dists[x];
            if (prices[x] < bestPrice) {
                bestPrice = prices[x];
                bestLoc = x;
                bestDist = distToTravel;
            } else if (prices[x] < lastBestPrice) {
                lastBestPrice = prices[x];
                lastBestLoc = x;
                lastBestDist = distToTravel;
            }
        }

        if (x == lastNode) {
            int combNeeded = Integer.max(distToTravel + dists[x] - combLeft, 0);
            return combNeeded * prices[i];
        }

        if (bestLoc != i) {
            int combNeeded = Integer.max(bestDist - combLeft, 0);
            int price = combNeeded * prices[i];
            return price + calcCheapTrip(tankSize, combLeft + combNeeded - bestDist, bestLoc, prices, dists);
        }

        int combNeeded = Integer.max(20 - combLeft, 0);
        int price = combNeeded * prices[i];
        return price + calcCheapTrip(tankSize, combLeft + combNeeded - lastBestDist, lastBestLoc, prices, dists);
    }
}
