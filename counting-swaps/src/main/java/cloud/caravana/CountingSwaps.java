package cloud.caravana;

import java.util.*;

public class CountingSwaps {
    public static Integer countSwaps(List<Integer> xs){
        return naiveSwaps(xs);
    }

    public static Integer naiveSwaps(List<Integer> xs){
        if (xs == null) return 0;
        Integer count = 0;
        for (int i = 0; i < xs.size() - 1 ; i++) {
            for (int j = i+1; j < xs.size() ; j++) {
                if ( xs.get(j) < xs.get(i) ){
                    Integer aux = xs.get(i);
                    xs.set(i, xs.get(j));
                    xs.set(j, aux);
                    count += 1;
                }
            }
        }
        return count;
    }
}
