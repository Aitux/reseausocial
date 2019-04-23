package rest;

import model.Commentaire;
import model.InBeforeBDD;
import model.Status;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/commentaire")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class GestionStatusResource {
    @POST
    @Path("/{mail}")
    public Response addStatus(@PathParam("mail") String mail, Status status) {
        User me = InBeforeBDD.getInstance().getUser(mail);
        me.addStatus(status);
        return Response.ok().build();
    }


    @POST
    @Path("/{mail}")
    public Response deleteStatus(@PathParam("mail") String mail, Status status){
        User me = InBeforeBDD.getInstance().getUser(mail);
        me.deleteStatus(status);
        return Response.ok().build();
    }

}
