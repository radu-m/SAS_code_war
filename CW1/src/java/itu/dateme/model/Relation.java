/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dateme.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author miul
 */
@Entity
@Table(name = "relation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Relation.findAll", query = "SELECT r FROM Relation r"),
    @NamedQuery(name = "Relation.findByPersonID1", query = "SELECT r FROM Relation r WHERE r.relationPK.personID1 = :personID1"),
    @NamedQuery(name = "Relation.findByPersonID2", query = "SELECT r FROM Relation r WHERE r.relationPK.personID2 = :personID2"),
    @NamedQuery(name = "Relation.findByRelation", query = "SELECT r FROM Relation r WHERE r.relation = :relation")})
public class Relation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RelationPK relationPK;
    @Column(name = "Relation")
    private String relation;

    public Relation() {
    }

    public Relation(RelationPK relationPK) {
        this.relationPK = relationPK;
    }

    public Relation(int personID1, int personID2) {
        this.relationPK = new RelationPK(personID1, personID2);
    }

    public RelationPK getRelationPK() {
        return relationPK;
    }

    public void setRelationPK(RelationPK relationPK) {
        this.relationPK = relationPK;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (relationPK != null ? relationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Relation)) {
            return false;
        }
        Relation other = (Relation) object;
        if ((this.relationPK == null && other.relationPK != null) || (this.relationPK != null && !this.relationPK.equals(other.relationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itu.dateme.model.Relation[ relationPK=" + relationPK + " ]";
    }
    
}
