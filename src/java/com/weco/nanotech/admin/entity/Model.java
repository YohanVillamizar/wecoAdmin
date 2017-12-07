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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "MODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Model.findAll", query = "SELECT m FROM Model m")
    , @NamedQuery(name = "Model.findByIdModel", query = "SELECT m FROM Model m WHERE m.idModel = :idModel")
    , @NamedQuery(name = "Model.findByName", query = "SELECT m FROM Model m WHERE m.name = :name")
    , @NamedQuery(name = "Model.findByStatus", query = "SELECT m FROM Model m WHERE m.status = :status")})
public class Model implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_MODEL")
    private BigDecimal idModel;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idModel")
    private List<Vehicle> vehicleList;
    @JoinColumn(name = "ID_MARK", referencedColumnName = "ID_MARK")
    @ManyToOne(optional = false)
    private Mark idMark;

    public Model() {
    }

    public Model(BigDecimal idModel) {
        this.idModel = idModel;
    }

    public Model(BigDecimal idModel, String name) {
        this.idModel = idModel;
        this.name = name;
    }

    public BigDecimal getIdModel() {
        return idModel;
    }

    public void setIdModel(BigDecimal idModel) {
        this.idModel = idModel;
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
    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    public Mark getIdMark() {
        return idMark;
    }

    public void setIdMark(Mark idMark) {
        this.idMark = idMark;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModel != null ? idModel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Model)) {
            return false;
        }
        Model other = (Model) object;
        if ((this.idModel == null && other.idModel != null) || (this.idModel != null && !this.idModel.equals(other.idModel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Model[ idModel=" + idModel + " ]";
    }
    
}
