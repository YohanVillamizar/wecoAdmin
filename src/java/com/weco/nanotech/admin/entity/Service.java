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
@Table(name = "SERVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Service.findAll", query = "SELECT s FROM Service s")
    , @NamedQuery(name = "Service.findByIdService", query = "SELECT s FROM Service s WHERE s.idService = :idService")
    , @NamedQuery(name = "Service.findByName", query = "SELECT s FROM Service s WHERE s.name = :name")
    , @NamedQuery(name = "Service.findByServiceCost", query = "SELECT s FROM Service s WHERE s.serviceCost = :serviceCost")
    , @NamedQuery(name = "Service.findByDescription", query = "SELECT s FROM Service s WHERE s.description = :description")
    , @NamedQuery(name = "Service.findByStatus", query = "SELECT s FROM Service s WHERE s.status = :status")})
public class Service implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICE")
    private BigDecimal idService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;
    @Column(name = "SERVICE_COST")
    private BigDecimal serviceCost;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_KIND_SERVICE", referencedColumnName = "ID_KIND_SERVICE")
    @ManyToOne(optional = false)
    private PackageService idKindService;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idService")
    private List<ServicePartner> servicePartnerList;

    public Service() {
    }

    public Service(BigDecimal idService) {
        this.idService = idService;
    }

    public Service(BigDecimal idService, String name) {
        this.idService = idService;
        this.name = name;
    }

    public BigDecimal getIdService() {
        return idService;
    }

    public void setIdService(BigDecimal idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(BigDecimal serviceCost) {
        this.serviceCost = serviceCost;
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

    public PackageService getIdKindService() {
        return idKindService;
    }

    public void setIdKindService(PackageService idKindService) {
        this.idKindService = idKindService;
    }

    @XmlTransient
    public List<ServicePartner> getServicePartnerList() {
        return servicePartnerList;
    }

    public void setServicePartnerList(List<ServicePartner> servicePartnerList) {
        this.servicePartnerList = servicePartnerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idService != null ? idService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Service)) {
            return false;
        }
        Service other = (Service) object;
        if ((this.idService == null && other.idService != null) || (this.idService != null && !this.idService.equals(other.idService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Service[ idService=" + idService + " ]";
    }
    
}
