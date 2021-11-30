package cloud.caravana;

import java.util.Arrays;

public class Util {
    public static final String[] linesToArray(String lines) {
        return lines.split("\n");
    }

    public static void main(String[] args) {
        var input = """
        one
        two
        three
        """;
        String[] lines = linesToArray(input);
        System.out.println(Arrays.toString(lines));
    }
    
}
