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
@Table(name = "VEHICLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehicle.findAll", query = "SELECT v FROM Vehicle v")
    , @NamedQuery(name = "Vehicle.findByIdVehicle", query = "SELECT v FROM Vehicle v WHERE v.idVehicle = :idVehicle")
    , @NamedQuery(name = "Vehicle.findByVehicleLicencePlate", query = "SELECT v FROM Vehicle v WHERE v.vehicleLicencePlate = :vehicleLicencePlate")
    , @NamedQuery(name = "Vehicle.findByColor", query = "SELECT v FROM Vehicle v WHERE v.color = :color")
    , @NamedQuery(name = "Vehicle.findByYear", query = "SELECT v FROM Vehicle v WHERE v.year = :year")
    , @NamedQuery(name = "Vehicle.findByStatus", query = "SELECT v FROM Vehicle v WHERE v.status = :status")})
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VEHICLE")
    private BigDecimal idVehicle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "VEHICLE_LICENCE_PLATE")
    private String vehicleLicencePlate;
    @Size(max = 20)
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "YEAR")
    private String year;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehicle")
    private List<VehiclePartner> vehiclePartnerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehicle")
    private List<VehicleClient> vehicleClientList;
    @JoinColumn(name = "ID_KIND_VEHICLE", referencedColumnName = "ID_KIND_VEHICLE")
    @ManyToOne(optional = false)
    private KindVehicle idKindVehicle;
    @JoinColumn(name = "ID_MODEL", referencedColumnName = "ID_MODEL")
    @ManyToOne(optional = false)
    private Model idModel;

    public Vehicle() {
    }

    public Vehicle(BigDecimal idVehicle) {
        this.idVehicle = idVehicle;
    }

    public Vehicle(BigDecimal idVehicle, String vehicleLicencePlate, String year) {
        this.idVehicle = idVehicle;
        this.vehicleLicencePlate = vehicleLicencePlate;
        this.year = year;
    }

    public BigDecimal getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(BigDecimal idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getVehicleLicencePlate() {
        return vehicleLicencePlate;
    }

    public void setVehicleLicencePlate(String vehicleLicencePlate) {
        this.vehicleLicencePlate = vehicleLicencePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public List<VehiclePartner> getVehiclePartnerList() {
        return vehiclePartnerList;
    }

    public void setVehiclePartnerList(List<VehiclePartner> vehiclePartnerList) {
        this.vehiclePartnerList = vehiclePartnerList;
    }

    @XmlTransient
    public List<VehicleClient> getVehicleClientList() {
        return vehicleClientList;
    }

    public void setVehicleClientList(List<VehicleClient> vehicleClientList) {
        this.vehicleClientList = vehicleClientList;
    }

    public KindVehicle getIdKindVehicle() {
        return idKindVehicle;
    }

    public void setIdKindVehicle(KindVehicle idKindVehicle) {
        this.idKindVehicle = idKindVehicle;
    }

    public Model getIdModel() {
        return idModel;
    }

    public void setIdModel(Model idModel) {
        this.idModel = idModel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVehicle != null ? idVehicle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehicle)) {
            return false;
        }
        Vehicle other = (Vehicle) object;
        if ((this.idVehicle == null && other.idVehicle != null) || (this.idVehicle != null && !this.idVehicle.equals(other.idVehicle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Vehicle[ idVehicle=" + idVehicle + " ]";
    }
    
}
