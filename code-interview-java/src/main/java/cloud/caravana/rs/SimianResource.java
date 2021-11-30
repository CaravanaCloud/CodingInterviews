package cloud.caravana.rs;

import java.util.Arrays;
import java.util.stream.Stream;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cloud.caravana.algo.SimianAlgo;
import io.vertx.core.json.JsonObject;

@Path("/simian")
public class SimianResource {

    

    // ab -p body.txt -T text/plain -c 10 -n 200 http://v2111261625.ap-northeast-1.elasticbeanstalk.com/simian

    // export URL='http://localhost:8080/simian'
    // export URL='http://v2111261625.ap-northeast-1.elasticbeanstalk.com/simian'
    // export TEXT_BODY='{"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}'
    // curl -v -d "$TEXT_BODY" -H "Content-Type: text/plain" -X POST $URL
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response isSimian(String input) {
        JsonObject obj = new JsonObject(input);
        Stream<String> objs = obj.getJsonArray("dna").getList().stream().map(o -> o.toString());
        //TODO: Cast array without copying
        String[] dna = objs.toArray(String[]::new);
        var isSimian = SimianAlgo.isSimian(dna);
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
}