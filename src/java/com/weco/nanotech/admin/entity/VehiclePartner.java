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
@Table(name = "VEHICLE_PARTNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehiclePartner.findAll", query = "SELECT v FROM VehiclePartner v")
    , @NamedQuery(name = "VehiclePartner.findByIdVehiclePartner", query = "SELECT v FROM VehiclePartner v WHERE v.idVehiclePartner = :idVehiclePartner")
    , @NamedQuery(name = "VehiclePartner.findByInsurance", query = "SELECT v FROM VehiclePartner v WHERE v.insurance = :insurance")
    , @NamedQuery(name = "VehiclePartner.findByOwnershipTittle", query = "SELECT v FROM VehiclePartner v WHERE v.ownershipTittle = :ownershipTittle")
    , @NamedQuery(name = "VehiclePartner.findByRegistration", query = "SELECT v FROM VehiclePartner v WHERE v.registration = :registration")
    , @NamedQuery(name = "VehiclePartner.findByStatus", query = "SELECT v FROM VehiclePartner v WHERE v.status = :status")})
public class VehiclePartner implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VEHICLE_PARTNER")
    private BigDecimal idVehiclePartner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "INSURANCE")
    private String insurance;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "OWNERSHIP_TITTLE")
    private String ownershipTittle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "REGISTRATION")
    private String registration;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private UserWeco idUser;
    @JoinColumn(name = "ID_VEHICLE", referencedColumnName = "ID_VEHICLE")
    @ManyToOne(optional = false)
    private Vehicle idVehicle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehiclePartner")
    private List<OrderService> orderServiceList;

    public VehiclePartner() {
    }

    public VehiclePartner(BigDecimal idVehiclePartner) {
        this.idVehiclePartner = idVehiclePartner;
    }

    public VehiclePartner(BigDecimal idVehiclePartner, String insurance, String ownershipTittle, String registration) {
        this.idVehiclePartner = idVehiclePartner;
        this.insurance = insurance;
        this.ownershipTittle = ownershipTittle;
        this.registration = registration;
    }

    public BigDecimal getIdVehiclePartner() {
        return idVehiclePartner;
    }

    public void setIdVehiclePartner(BigDecimal idVehiclePartner) {
        this.idVehiclePartner = idVehiclePartner;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getOwnershipTittle() {
        return ownershipTittle;
    }

    public void setOwnershipTittle(String ownershipTittle) {
        this.ownershipTittle = ownershipTittle;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public UserWeco getIdUser() {
        return idUser;
    }

    public void setIdUser(UserWeco idUser) {
        this.idUser = idUser;
    }

    public Vehicle getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Vehicle idVehicle) {
        this.idVehicle = idVehicle;
    }

    @XmlTransient
    public List<OrderService> getOrderServiceList() {
        return orderServiceList;
    }

    public void setOrderServiceList(List<OrderService> orderServiceList) {
        this.orderServiceList = orderServiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehiclePartner != null ? idVehiclePartner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiclePartner)) {
            return false;
        }
        VehiclePartner other = (VehiclePartner) object;
        if ((this.idVehiclePartner == null && other.idVehiclePartner != null) || (this.idVehiclePartner != null && !this.idVehiclePartner.equals(other.idVehiclePartner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.VehiclePartner[ idVehiclePartner=" + idVehiclePartner + " ]";
    }
    
}
