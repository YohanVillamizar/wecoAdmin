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
@Table(name = "VEHICLE_CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "VehicleClient.findAll", query = "SELECT v FROM VehicleClient v")
    , @NamedQuery(name = "VehicleClient.findByIdVehicleClient", query = "SELECT v FROM VehicleClient v WHERE v.idVehicleClient = :idVehicleClient")
    , @NamedQuery(name = "VehicleClient.findByDescription", query = "SELECT v FROM VehicleClient v WHERE v.description = :description")
    , @NamedQuery(name = "VehicleClient.findByStatus", query = "SELECT v FROM VehicleClient v WHERE v.status = :status")})
public class VehicleClient implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_VEHICLE_CLIENT")
    private BigDecimal idVehicleClient;
    @Size(max = 250)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private UserWeco idUser;
    @JoinColumn(name = "ID_VEHICLE", referencedColumnName = "ID_VEHICLE")
    @ManyToOne(optional = false)
    private Vehicle idVehicle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVehicleClient")
    private List<OrderService> orderServiceList;

    public VehicleClient() {
    }

    public VehicleClient(BigDecimal idVehicleClient) {
        this.idVehicleClient = idVehicleClient;
    }

    public BigDecimal getIdVehicleClient() {
        return idVehicleClient;
    }

    public void setIdVehicleClient(BigDecimal idVehicleClient) {
        this.idVehicleClient = idVehicleClient;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        hash += (idVehicleClient != null ? idVehicleClient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehicleClient)) {
            return false;
        }
        VehicleClient other = (VehicleClient) object;
        if ((this.idVehicleClient == null && other.idVehicleClient != null) || (this.idVehicleClient != null && !this.idVehicleClient.equals(other.idVehicleClient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.VehicleClient[ idVehicleClient=" + idVehicleClient + " ]";
    }
    
}
