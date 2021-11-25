package cloud.caravana;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
public class RootResource {
     @GET
     public String getRoot() {
         return "This will not get called as index.html has precedence";
     }
}
