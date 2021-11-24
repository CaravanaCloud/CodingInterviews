package cloud.caravana;

import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.vertx.core.json.JsonObject;

@Path("/simian")
public class SimianResource {

    

    // export TEXT_BODY='{"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}'
    // curl -v -d "$TEXT_BODY" -H "Content-Type: text/plain" -X POST http://localhost:8080/simian
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response isSimian(String input) {
        JsonObject obj = new JsonObject(input);
        Object[] objs = obj.getJsonArray("dna").getList().toArray();
        //TODO: Cast array without copying
        String[] dna = Arrays.stream(objs).toArray(String[]::new);
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