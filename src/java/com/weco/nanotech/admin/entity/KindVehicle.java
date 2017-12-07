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
@Table(name = "KIND_VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KindVehicle.findAll", query = "SELECT k FROM KindVehicle k")
    , @NamedQuery(name = "KindVehicle.findByIdKindVehicle", query = "SELECT k FROM KindVehicle k WHERE k.idKindVehicle = :idKindVehicle")
    , @NamedQuery(name = "KindVehicle.findByName", query = "SELECT k FROM KindVehicle k WHERE k.name = :name")
    , @NamedQuery(name = "KindVehicle.findByStatus", query = "SELECT k FROM KindVehicle k WHERE k.status = :status")})
public class KindVehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_KIND_VEHICLE")
    private BigDecimal idKindVehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKindVehicle")
    private List<Vehicle> vehicleList;

    public KindVehicle() {
    }

    public KindVehicle(BigDecimal idKindVehicle) {
        this.idKindVehicle = idKindVehicle;
    }

    public KindVehicle(BigDecimal idKindVehicle, String name) {
        this.idKindVehicle = idKindVehicle;
        this.name = name;
    }

    public BigDecimal getIdKindVehicle() {
        return idKindVehicle;
    }

    public void setIdKindVehicle(BigDecimal idKindVehicle) {
        this.idKindVehicle = idKindVehicle;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKindVehicle != null ? idKindVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KindVehicle)) {
            return false;
        }
        KindVehicle other = (KindVehicle) object;
        if ((this.idKindVehicle == null && other.idKindVehicle != null) || (this.idKindVehicle != null && !this.idKindVehicle.equals(other.idKindVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.KindVehicle[ idKindVehicle=" + idKindVehicle + " ]";
    }
    
}
