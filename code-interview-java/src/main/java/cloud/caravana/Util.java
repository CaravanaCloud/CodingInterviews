package cloud.caravana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

public class Util {
    public static final String[] linesToArray(String lines) {
        return lines.split("\n");
    }

    public static final String arrayToLines(int[] array) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            sb.append("\n");            
        }
        return sb.toString();
    }

    public static int intFromLine(String input, int lineNumber) {
        var text = linesToArray(input)[lineNumber];
        var result = Integer.parseInt(text.trim());
        return result;
    }

    public static int[] intArrayStartingLine(String input, int lineNumber) {
        var lines = Arrays.asList(linesToArray(input));
        var resultList = lines.subList(lineNumber, lines.size());
        var result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            var text = resultList.get(i).trim();
            result[i] = Integer.parseInt(text);
        }
        return result;
    }
    
}
