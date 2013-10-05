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
public class RelationPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "PersonID1")
    private int personID1;
    @Basic(optional = false)
    @Column(name = "PersonID2")
    private int personID2;

    public RelationPK() {
    }

    public RelationPK(int personID1, int personID2) {
        this.personID1 = personID1;
        this.personID2 = personID2;
    }

    public int getPersonID1() {
        return personID1;
    }

    public void setPersonID1(int personID1) {
        this.personID1 = personID1;
    }

    public int getPersonID2() {
        return personID2;
    }

    public void setPersonID2(int personID2) {
        this.personID2 = personID2;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) personID1;
        hash += (int) personID2;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RelationPK)) {
            return false;
        }
        RelationPK other = (RelationPK) object;
        if (this.personID1 != other.personID1) {
            return false;
        }
        if (this.personID2 != other.personID2) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "itu.dateme.model.RelationPK[ personID1=" + personID1 + ", personID2=" + personID2 + " ]";
    }
    
}
