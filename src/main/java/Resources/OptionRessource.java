package Resources;

import entities.Option;
import metiers.OptionBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/options")
public class OptionRessource {

    OptionBusiness optionBusiness = new OptionBusiness();
    @GET
    @Path("/List")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Option> getList() {
        return optionBusiness.getListeOptions();
    }
    @GET
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    public Option getByCode(
            @PathParam("param") int code) {

        return optionBusiness.getOptionByCode(code);
    }
    @GET
    @Path("/Domaine/{subject}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Option> getByDomaine(
            @PathParam("subject") String domaine) {

        return optionBusiness.getOptionsByDomaine(domaine);
    }
    @DELETE
    @Path("/{param}")
    public boolean deleteByCode(
            @PathParam("param") int code) {

        return optionBusiness.deleteOption(code);
    }
    @PUT
    @Path("/{param}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean putByOption(
            @PathParam("param") int code,
            Option updatedOption) {

        return optionBusiness.updateOption(
                code,
                updatedOption
        );
    }
}