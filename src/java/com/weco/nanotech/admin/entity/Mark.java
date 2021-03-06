/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YohanVillamizar
 */
@Entity
@Table(name = "MARK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mark.findAll", query = "SELECT m FROM Mark m")
    , @NamedQuery(name = "Mark.findByIdMark", query = "SELECT m FROM Mark m WHERE m.idMark = :idMark")
    , @NamedQuery(name = "Mark.findByName", query = "SELECT m FROM Mark m WHERE m.name = :name")
    , @NamedQuery(name = "Mark.findByStatus", query = "SELECT m FROM Mark m WHERE m.status = :status")})
public class Mark implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MARK")
    private BigDecimal idMark;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMark")
    private List<Model> modelList;

    public Mark() {
    }

    public Mark(BigDecimal idMark) {
        this.idMark = idMark;
    }

    public Mark(BigDecimal idMark, String name) {
        this.idMark = idMark;
        this.name = name;
    }

    public BigDecimal getIdMark() {
        return idMark;
    }

    public void setIdMark(BigDecimal idMark) {
        this.idMark = idMark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public List<Model> getModelList() {
        return modelList;
    }

    public void setModelList(List<Model> modelList) {
        this.modelList = modelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMark != null ? idMark.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mark)) {
            return false;
        }
        Mark other = (Mark) object;
        if ((this.idMark == null && other.idMark != null) || (this.idMark != null && !this.idMark.equals(other.idMark))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Mark[ idMark=" + idMark + " ]";
    }
    
}
