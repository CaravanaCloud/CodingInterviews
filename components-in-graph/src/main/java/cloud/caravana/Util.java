package cloud.caravana;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Util {
    static final List<List<Integer>> parseInput(String file) {
        try {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            // The class loader that loaded the class
            InputStream in = cl.getResourceAsStream(file);

            // the stream holding the file content
            if (in == null) {
                throw new IllegalArgumentException("file not found! " + file);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> gb = new ArrayList<>();

            IntStream.range(0, n).forEach(i -> {
                try {
                    gb.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                    .map(Integer::parseInt)
                                    .collect(toList())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
            return gb;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
