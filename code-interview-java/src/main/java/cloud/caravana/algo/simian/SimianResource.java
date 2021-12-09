package cloud.caravana.algo.simian;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cloud.caravana.service.SimianService;
import io.vertx.core.json.*;

@Path("/simian")
public class SimianResource {

    @Inject
    SimianService simians;

    static final List<String> dnaChars = new ArrayList<>(){{
        add("C");
        add("T");
        add("A");
        add("G");
    }};

    
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response randomSimian() {
        var rand = new Random();
        var size = 1 + rand.nextInt(1000);
        var json = new JsonObject();
        var dna = new JsonArray();
        for (var i = 0; i < size; i++) {
            var line = new StringBuilder();
            for (int j = 0; j < size; j++) {
                var charac = dnaChars.get(rand.nextInt(dnaChars.size()));
                line.append(charac);
            }
            dna.add(line.toString());
        }
        json.put("dna", dna);
        json.put("simian", SimianAlgo.isSimian(json.toString()));
        return Response.ok(json).build();
    }

    // ab -p body.txt -T text/plain -c 10 -n 200 http://v2111261625.ap-northeast-1.elasticbeanstalk.com/simian
    // export URL='http://localhost:8080/simian'
    // export URL='http://v2111261625.ap-northeast-1.elasticbeanstalk.com/simian'
    // export TEXT_BODY='{"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}'
    // curl -v -d "$TEXT_BODY" -H "Content-Type: text/plain" -X POST $URL
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response isSimian(String input) {
        JsonObject obj = new JsonObject(input);
        @SuppressWarnings("unchecked")
        Stream<String> objs = obj.getJsonArray("dna").getList().stream().map(o -> o.toString());
        String[] dna = objs.toArray(String[]::new);
        var isSimian = simians.isSimian(dna);
        var output = "" + isSimian +"\n";
        if (isSimian)  {
            return Response
                .status(Response.Status.OK)
                .entity(output)
                .build();
        } else {
            return Response
                .status(Response.Status.FORBIDDEN)
                .entity(output)
                .build();
        }
    }

    @Path("/stats")
    @GET
    public JsonObject getStats(){
        var json = new JsonObject();
        var stats = simians.getStats();
        var simians = stats.get(Boolean.TRUE);
        var not_simians = stats.get(Boolean.FALSE);
        json.put("simian", simians);
        json.put("not_simian", not_simians);
        if (simians == null || simians + not_simians == 0)
            return json;
        var ratio = (double) simians / (simians + not_simians);
        json.put("ratio", ratio);
        return json;
    }
}