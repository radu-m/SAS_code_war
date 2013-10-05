/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dateme.model.service;

import itu.dateme.model.Relation;
import itu.dateme.model.RelationPK;
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
@javax.ejb.Stateless
@Path("itu.dateme.model.relation")
public class RelationFacadeREST extends AbstractFacade<Relation> {
    @PersistenceContext(unitName = "CW1PU")
    private EntityManager em;

    private RelationPK getPrimaryKey(PathSegment pathSegment) {
        /*
         * pathSemgent represents a URI path segment and any associated matrix parameters.
         * URI path part is supposed to be in form of 'somePath;personID1=personID1Value;personID2=personID2Value'.
         * Here 'somePath' is a result of getPath() method invocation and
         * it is ignored in the following code.
         * Matrix parameters are used as field names to build a primary key instance.
         */
        itu.dateme.model.RelationPK key = new itu.dateme.model.RelationPK();
        javax.ws.rs.core.MultivaluedMap<String, String> map = pathSegment.getMatrixParameters();
        java.util.List<String> personID1 = map.get("personID1");
        if (personID1 != null && !personID1.isEmpty()) {
            key.setPersonID1(new java.lang.Integer(personID1.get(0)));
        }
        java.util.List<String> personID2 = map.get("personID2");
        if (personID2 != null && !personID2.isEmpty()) {
            key.setPersonID2(new java.lang.Integer(personID2.get(0)));
        }
        return key;
    }

    public RelationFacadeREST() {
        super(Relation.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Relation entity) {
        super.create(entity);
    }

    @PUT
    @Override
    @Consumes({"application/xml", "application/json"})
    public void edit(Relation entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") PathSegment id) {
        itu.dateme.model.RelationPK key = getPrimaryKey(id);
        super.remove(super.find(key));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Relation find(@PathParam("id") PathSegment id) {
        itu.dateme.model.RelationPK key = getPrimaryKey(id);
        return super.find(key);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Relation> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Relation> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
