/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dateme.model.service;

import itu.dateme.model.Hasinterest;
import itu.dateme.model.HasinterestPK;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.PathSegment;

/**
 *
 * @author miul
 */
//@javax.ejb.Stateless
@Path("itu.dateme.model.hasinterest")
public class HasinterestFacadeREST extends AbstractFacade<Hasinterest> {
    @PersistenceContext(unitName = "CW1PU")
    private EntityManager em;

    private HasinterestPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;personID=personIDValue;interestname=interestnameValue'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        itu.dateme.model.HasinterestPK key = new itu.dateme.model.HasinterestPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> personID = map.get("personID");
        if (personID != null && !personID.isEmpty()) {
            key.setPersonID(new java.lang.Integer(personID.get(0)));
        }
        java.util.List<String> interestname = map.get("interestname");
        if (interestname != null && !interestname.isEmpty()) {
            key.setInterestname(interestname.get(0));
        }
        return key;
    }

    public HasinterestFacadeREST() {
        super(Hasinterest.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Hasinterest entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Hasinterest entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        itu.dateme.model.HasinterestPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Hasinterest find(@PathParam("id") PathSegment id) {
        itu.dateme.model.HasinterestPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Hasinterest> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Hasinterest> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
