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
@Table(name = "LOCATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l")
    , @NamedQuery(name = "Location.findByIdLocation", query = "SELECT l FROM Location l WHERE l.idLocation = :idLocation")
    , @NamedQuery(name = "Location.findByName", query = "SELECT l FROM Location l WHERE l.name = :name")
    , @NamedQuery(name = "Location.findByLatitude", query = "SELECT l FROM Location l WHERE l.latitude = :latitude")
    , @NamedQuery(name = "Location.findByLongitude", query = "SELECT l FROM Location l WHERE l.longitude = :longitude")
    , @NamedQuery(name = "Location.findByDirection", query = "SELECT l FROM Location l WHERE l.direction = :direction")
    , @NamedQuery(name = "Location.findByZipcode", query = "SELECT l FROM Location l WHERE l.zipcode = :zipcode")
    , @NamedQuery(name = "Location.findByStatus", query = "SELECT l FROM Location l WHERE l.status = :status")})
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_LOCATION")
    private BigDecimal idLocation;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LATITUDE")
    private String latitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LONGITUDE")
    private String longitude;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DIRECTION")
    private String direction;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ZIPCODE")
    private String zipcode;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_CITY", referencedColumnName = "ID_CITY")
    @ManyToOne(optional = false)
    private City idCity;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocation")
    private List<OrderService> orderServiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocation")
    private List<UserWeco> userWecoList;

    public Location() {
    }

    public Location(BigDecimal idLocation) {
        this.idLocation = idLocation;
    }

    public Location(BigDecimal idLocation, String name, String latitude, String longitude, String direction, String zipcode) {
        this.idLocation = idLocation;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.direction = direction;
        this.zipcode = zipcode;
    }

    public BigDecimal getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(BigDecimal idLocation) {
        this.idLocation = idLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public City getIdCity() {
        return idCity;
    }

    public void setIdCity(City idCity) {
        this.idCity = idCity;
    }

    @XmlTransient
    public List<OrderService> getOrderServiceList() {
        return orderServiceList;
    }

    public void setOrderServiceList(List<OrderService> orderServiceList) {
        this.orderServiceList = orderServiceList;
    }

    @XmlTransient
    public List<UserWeco> getUserWecoList() {
        return userWecoList;
    }

    public void setUserWecoList(List<UserWeco> userWecoList) {
        this.userWecoList = userWecoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocation != null ? idLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idLocation == null && other.idLocation != null) || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Location[ idLocation=" + idLocation + " ]";
    }
    
}
