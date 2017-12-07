/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YohanVillamizar
 */
@Entity
@Table(name = "SERVICE_PARTNER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicePartner.findAll", query = "SELECT s FROM ServicePartner s")
    , @NamedQuery(name = "ServicePartner.findByIdServicePartner", query = "SELECT s FROM ServicePartner s WHERE s.idServicePartner = :idServicePartner")
    , @NamedQuery(name = "ServicePartner.findByDescription", query = "SELECT s FROM ServicePartner s WHERE s.description = :description")
    , @NamedQuery(name = "ServicePartner.findByCostServicePartner", query = "SELECT s FROM ServicePartner s WHERE s.costServicePartner = :costServicePartner")
    , @NamedQuery(name = "ServicePartner.findByStatus", query = "SELECT s FROM ServicePartner s WHERE s.status = :status")})
public class ServicePartner implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SERVICE_PARTNER")
    private BigDecimal idServicePartner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COST_SERVICE_PARTNER")
    private BigDecimal costServicePartner;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_SERVICE", referencedColumnName = "ID_SERVICE")
    @ManyToOne(optional = false)
    private Service idService;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private UserWeco idUser;

    public ServicePartner() {
    }

    public ServicePartner(BigDecimal idServicePartner) {
        this.idServicePartner = idServicePartner;
    }

    public ServicePartner(BigDecimal idServicePartner, String description, BigDecimal costServicePartner) {
        this.idServicePartner = idServicePartner;
        this.description = description;
        this.costServicePartner = costServicePartner;
    }

    public BigDecimal getIdServicePartner() {
        return idServicePartner;
    }

    public void setIdServicePartner(BigDecimal idServicePartner) {
        this.idServicePartner = idServicePartner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCostServicePartner() {
        return costServicePartner;
    }

    public void setCostServicePartner(BigDecimal costServicePartner) {
        this.costServicePartner = costServicePartner;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Service getIdService() {
        return idService;
    }

    public void setIdService(Service idService) {
        this.idService = idService;
    }

    public UserWeco getIdUser() {
        return idUser;
    }

    public void setIdUser(UserWeco idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idServicePartner != null ? idServicePartner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicePartner)) {
            return false;
        }
        ServicePartner other = (ServicePartner) object;
        if ((this.idServicePartner == null && other.idServicePartner != null) || (this.idServicePartner != null && !this.idServicePartner.equals(other.idServicePartner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.ServicePartner[ idServicePartner=" + idServicePartner + " ]";
    }
    
}
