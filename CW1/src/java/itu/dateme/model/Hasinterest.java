/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dateme.model;

import java.io.Serializable;
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
@Table(name = "hasinterest")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Hasinterest.findAll", query = "SELECT h FROM Hasinterest h"),
    @NamedQuery(name = "Hasinterest.findByPersonID", query = "SELECT h FROM Hasinterest h WHERE h.hasinterestPK.personID = :personID"),
    @NamedQuery(name = "Hasinterest.findByInterestname", query = "SELECT h FROM Hasinterest h WHERE h.hasinterestPK.interestname = :interestname")})
public class Hasinterest implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HasinterestPK hasinterestPK;

    public Hasinterest() {
    }

    public Hasinterest(HasinterestPK hasinterestPK) {
        this.hasinterestPK = hasinterestPK;
    }

    public Hasinterest(int personID, String interestname) {
        this.hasinterestPK = new HasinterestPK(personID, interestname);
    }

    public HasinterestPK getHasinterestPK() {
        return hasinterestPK;
    }

    public void setHasinterestPK(HasinterestPK hasinterestPK) {
        this.hasinterestPK = hasinterestPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hasinterestPK != null ? hasinterestPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Hasinterest)) {
            return false;
        }
        Hasinterest other = (Hasinterest) object;
        if ((this.hasinterestPK == null && other.hasinterestPK != null) || (this.hasinterestPK != null && !this.hasinterestPK.equals(other.hasinterestPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itu.dateme.model.Hasinterest[ hasinterestPK=" + hasinterestPK + " ]";
    }
    
}
