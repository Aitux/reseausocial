package rest;

import model.Commentaire;
import model.InBeforeBDD;
import model.Statut;
import model.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/commentaire")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class GestionCommentaireResource{

    @POST
    @Path("/{mail}")
    public Response addCommentaire(@PathParam("mail") String mail, Commentaire commentaire, Statut statut) {
        User me = InBeforeBDD.getInstance().getUser(mail);
        int i = me.getStatuts().indexOf(statut);
        me.getStatuts().get(i).addCommentaire(commentaire);
        return Response.ok().build();
    }


    @POST
    @Path("/{mail}")
    public Response deleteCommentaire(@PathParam("mail") String mail, Commentaire commentaire, Statut statut) {
        User me = InBeforeBDD.getInstance().getUser(mail);
        int i = me.getStatuts().indexOf(statut);
        me.getStatuts().get(i).deleteCommentaire(commentaire);
        return Response.ok().build();
    }

}
