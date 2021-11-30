package cloud.caravana.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import io.vertx.core.cli.Option;

public class Algos {
    private static final Map<String, Function<String, String>> algos = new HashMap<>() {
        {
            put("simian", SimianAlgo::isSimian);
        }
    };

    private static final String apply(String algoName, String input) {
        var algo = algos.get(algoName);
        if (algo == null) return null;
        var output = algo.apply(input);
        return output;
    }

    private static final Optional<String> applyOpt(String algoName, String input) {
        return Optional
                .ofNullable(algos.get(algoName))
                .map(algo -> algo.apply(input));
    }

    

    public static void main(String[] args) {
        var input = """
                CAAAAG
                CAGTTX
                TTTCGX
                YYYYYX
                CCCAGX
                TCACTX
                """;
        applyOpt("simian", input)
            .ifPresent(System.out::println);
    }

}
