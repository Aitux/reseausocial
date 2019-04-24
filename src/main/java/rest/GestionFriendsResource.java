package rest;

import model.InBeforeBDD;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/friend")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class GestionFriendsResource {

    @POST
    @Path("/{mail}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addFriend(@PathParam("mail") String mail, User u) {
        User me = InBeforeBDD.getInstance().getUser(mail);
        User newFriend = InBeforeBDD.getInstance().getUser(u.getEmail());
        if (!me.getFriends().contains(newFriend)) {
            me.getFriends().add(newFriend);
            return Response.ok().build();
        }
        return Response.notModified().build();
    }

    @GET
    @Path("/{mail}")
    public Response all(@PathParam("mail") String mail) {
        User u = InBeforeBDD.getInstance().getUser(mail);
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(u.getFriends()) {
        };
        return Response.ok(entity).build();
    }

    @POST
    @Path("/delete/{mail}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response removeFriend(@PathParam("mail") String mail, User u) {
        User me = InBeforeBDD.getInstance().getUser(mail);
        User futureExFriend = InBeforeBDD.getInstance().getUser(u.getEmail());
        if (me.getFriends().contains(futureExFriend)) {
            me.getFriends().remove(futureExFriend);
            return Response.ok().build();
        }
        return Response.notModified().build();
    }
}
