/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package itu.dateme.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author miul
 */
@Embeddable
public class HasinterestPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PersonID")
    private int personID;
    @Basic(optional = false)
    @Column(name = "Interestname")
    private String interestname;

    public HasinterestPK() {
    }

    public HasinterestPK(int personID, String interestname) {
        this.personID = personID;
        this.interestname = interestname;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getInterestname() {
        return interestname;
    }

    public void setInterestname(String interestname) {
        this.interestname = interestname;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personID;
        hash += (interestname != null ? interestname.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HasinterestPK)) {
            return false;
        }
        HasinterestPK other = (HasinterestPK) object;
        if (this.personID != other.personID) {
            return false;
        }
        if ((this.interestname == null && other.interestname != null) || (this.interestname != null && !this.interestname.equals(other.interestname))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itu.dateme.model.HasinterestPK[ personID=" + personID + ", interestname=" + interestname + " ]";
    }
    
}
