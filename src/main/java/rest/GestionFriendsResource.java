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
        System.out.println(mail);
        System.out.println(u.getEmail());
        System.out.println(me.getEmail());
        System.out.println(newFriend.getEmail());
        if (!me.getFriends().contains(newFriend)) {
            me.getFriends().add(newFriend);
            return Response.notModified().build();
        }
        System.out.println("===== Friends de " + me.getFirstname() + " ====");
        me.getFriends().forEach(System.out::println);
        System.out.println("==================");
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
