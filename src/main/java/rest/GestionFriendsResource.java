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
    public Response addFriend(@PathParam("mail") String mail, User newFriend) {
        User me = InBeforeBDD.getInstance().getUser(mail);
        me.getFriends().add(InBeforeBDD.getInstance().getUser(newFriend.getEmail()));
        return Response.ok().build();
    }

    @GET
    @Path("/{mail}")
    public Response all(@PathParam("mail") String mail) {
        User u = InBeforeBDD.getInstance().getUser(mail);
        GenericEntity<List<User>> entity = new GenericEntity<List<User>>(u.getFriends()) {
        };
        return Response.ok(entity).build();
    }

    @DELETE
    @Path("/{mail}")
    public Response removeFriend(@PathParam("mail") String mail, User u) {
        User us = InBeforeBDD.getInstance().getUser(mail);
        us.getFriends().remove(InBeforeBDD.getInstance().getUser(u.getEmail()));
        return Response.ok().build();
    }
}
