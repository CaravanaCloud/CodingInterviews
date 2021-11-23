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

    boolean isSimian (String[] dna){
        //TODO (Mentoria de Sexta): Implement this method
        var rand = new java.util.Random().nextInt();
        return rand % 2 == 0;
    }

    // export JSON_BODY='{"dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]}'
    // curl -v -d "$JSON_BODY" -H "Content-Type: application/json" -X POST http://localhost:8080/simian
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response isSimian(JsonObject obj) {
        Object[] objs = obj.getJsonArray("dna").getList().toArray();
        //TODO: Cast array without copying
        String[] dna = Arrays.stream(objs).toArray(String[]::new);
        var dnaStr = Arrays.toString(dna); 
        var isSimian = isSimian(dna);
        if (isSimian)  {
            return Response
                .status(Response.Status.OK)
                .entity(dnaStr)
                .build();
        } else {
            return Response
                .status(Response.Status.FORBIDDEN)
                .entity(dnaStr)
                .build();
        }
    }
}