package cloud.caravana;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class CIGNaive {
    /* Notes
     * - undirected graph
     * - there is at least one connected component (size 2)
     */

    // mark connections:
    //      edge(a,b) => component(a) == component(b)
    // for each component
    // get size of component
    // compare with min and max
    public static List<Integer> componentsInGraph(List<List<Integer>> edges) {
        var components = new HashMap<Integer /*Node*/, Integer /*Component*/>();
        for (List<Integer> edge: edges){
            var a = edge.get(0);
            var b = edge.get(1);
            edge(components, a, b);
        }

        var sizes = new HashMap<Integer /*Component*/, Integer/*Size*/>();
        for(Map.Entry<Integer, Integer> entry:components.entrySet()) {
            var component = entry.getValue();
            var size = sizes.getOrDefault(component, 0);
            size += 1;
            sizes.put(component, size);
        }

        Integer min = null;
        Integer max = null;
        for(Map.Entry<Integer, Integer> entry:sizes.entrySet()) {
            var size = entry.getValue();
            if (max == null || size > max) max = size;
            if (min == null || size < min) min = size;
        }
        return List.of(min,max);
    }

    private static void print(HashMap<Integer, Integer> components, HashMap<Integer, Integer> sizes, int min, int max) {
        System.out.println("COMPONENTS ---");
        components.forEach((key, value) -> System.out.println(key + " : "+ value));
        System.out.println("SIZES ---");
        components.forEach((key, value) -> System.out.println(key + " : "+ value));
        System.out.println("MIN - " + min);
        System.out.println("MIN - " + max);
    }

    private static void edge(HashMap<Integer, Integer> components, Integer a, Integer b) {
        if (a.equals(b)) return;
        var compA = components.getOrDefault(a, a);
        var compB = components.getOrDefault(b, b);
        for(Map.Entry<Integer, Integer> entry:components.entrySet()) {
            if (entry.getValue().equals(compB))
                entry.setValue(compA);
        }
        components.put(b,compA);
        components.put(a,compA);
    }

    public static void main(String[] args) throws IOException {
        String file = "input19.txt";
        var gb = Util.parseInput(file);
        List<Integer> result = CIGPerf.componentsInGraph(gb);
        System.out.println(result);
    }

}