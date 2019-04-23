import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/friend")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GestionFriendsResource {

    @POST
    public Response addFriend(User me, User newFriend) {
        me.getFriends().add(newFriend);
        return Response.ok().build();
    }

    @GET
    @Path("/{mail}")
    public List<User> getFriends(@PathParam("mail") String mail) {

    }
}
