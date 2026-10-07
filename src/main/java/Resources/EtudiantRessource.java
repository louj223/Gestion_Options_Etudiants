package Resources;

import entities.Etudiant;
import entities.Option;
import metiers.EtudiantBusiness;
import metiers.OptionBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/etudiants")
public class EtudiantRessource {

    EtudiantBusiness etudiantBusiness = new EtudiantBusiness();
    OptionBusiness optionBusiness = new OptionBusiness();
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean postByAdd(Etudiant etudiant) {
        return etudiantBusiness.addEtudiant(etudiant);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etudiant> getList() {
        return etudiantBusiness.getAllEtudiants();
    }
    @GET
    @Path("/{identifiant}")
    @Produces(MediaType.APPLICATION_JSON)
    public Etudiant getByIdentifiant(
            @PathParam("identifiant") String identifiant) {

        return etudiantBusiness.getEtudiantByIdentifiant(identifiant);
    }
    @DELETE
    @Path("/{identifiant}")
    @Produces(MediaType.APPLICATION_JSON)
    public boolean deleteByIdentifiant(
            @PathParam("identifiant") String identifiant) {

        return etudiantBusiness.deleteEtudiant(identifiant);
    }
    @PUT
    @Path("/{identifiant}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean putByEtudiant(
            @PathParam("identifiant") String identifiant,
            Etudiant updatedEtudiant) {

        return etudiantBusiness.updateEtudiant(
                identifiant,
                updatedEtudiant
        );
    }
    @GET
    @Path("/option")
    @Produces(MediaType.APPLICATION_XML)
    public List<Etudiant> getEtudiantsByOption(
            @QueryParam("codeOption") int codeOption) {

        Option option = optionBusiness.getOptionByCode(codeOption);

        return etudiantBusiness.getEtudiantsByOption(option);
    }
}