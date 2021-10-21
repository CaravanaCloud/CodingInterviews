package cloud.caravana;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CIGPerf {
    public static List<Integer> componentsInGraph(List<List<Integer>> edges) {
        var components = new HashMap<Integer /*Node*/, Integer /*Component*/>();
        var sizes = new HashMap<Integer /*Component*/, Integer/*Size*/>();

        for (List<Integer> edge: edges){
            var a = edge.get(0);
            var b = edge.get(1);
            edge(components, sizes, a, b);
        }

        Integer min = null;
        Integer max = null;
        for(Integer size: sizes.values()) {
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

    private static void edge(HashMap<Integer, Integer> components, HashMap<Integer, Integer> sizes, Integer a, Integer b) {
        if (a.equals(b)) return;
        var compA = components.getOrDefault(a, a);
        var compB = components.getOrDefault(b, b);
        components.put(b,compA);
        components.put(a,compA);
        sizes.clear();
        for(Map.Entry<Integer, Integer> entry:components.entrySet()) {
            if (entry.getValue().equals(compB))
                entry.setValue(compA);
            var component = entry.getValue();
            var size = sizes.getOrDefault(component, 0);
            size += 1;
            sizes.put(component, size);
        }



    }

}
