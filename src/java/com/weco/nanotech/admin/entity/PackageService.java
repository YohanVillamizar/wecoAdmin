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
@Table(name = "PACKAGE_SERVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PackageService.findAll", query = "SELECT p FROM PackageService p")
    , @NamedQuery(name = "PackageService.findByIdKindService", query = "SELECT p FROM PackageService p WHERE p.idKindService = :idKindService")
    , @NamedQuery(name = "PackageService.findByName", query = "SELECT p FROM PackageService p WHERE p.name = :name")
    , @NamedQuery(name = "PackageService.findByDescription", query = "SELECT p FROM PackageService p WHERE p.description = :description")
    , @NamedQuery(name = "PackageService.findByStatus", query = "SELECT p FROM PackageService p WHERE p.status = :status")})
public class PackageService implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_KIND_SERVICE")
    private BigDecimal idKindService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKindService")
    private List<Service> serviceList;

    public PackageService() {
    }

    public PackageService(BigDecimal idKindService) {
        this.idKindService = idKindService;
    }

    public PackageService(BigDecimal idKindService, String name, String description) {
        this.idKindService = idKindService;
        this.name = name;
        this.description = description;
    }

    public BigDecimal getIdKindService() {
        return idKindService;
    }

    public void setIdKindService(BigDecimal idKindService) {
        this.idKindService = idKindService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient
    public List<Service> getServiceList() {
        return serviceList;
    }

    public void setServiceList(List<Service> serviceList) {
        this.serviceList = serviceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKindService != null ? idKindService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PackageService)) {
            return false;
        }
        PackageService other = (PackageService) object;
        if ((this.idKindService == null && other.idKindService != null) || (this.idKindService != null && !this.idKindService.equals(other.idKindService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.PackageService[ idKindService=" + idKindService + " ]";
    }
    
}
