/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "BUY_SERVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BuyService.findAll", query = "SELECT b FROM BuyService b")
    , @NamedQuery(name = "BuyService.findByIdBuyService", query = "SELECT b FROM BuyService b WHERE b.idBuyService = :idBuyService")
    , @NamedQuery(name = "BuyService.findByIdPackage", query = "SELECT b FROM BuyService b WHERE b.idPackage = :idPackage")
    , @NamedQuery(name = "BuyService.findByIdSevice", query = "SELECT b FROM BuyService b WHERE b.idSevice = :idSevice")
    , @NamedQuery(name = "BuyService.findByAditionalCost", query = "SELECT b FROM BuyService b WHERE b.aditionalCost = :aditionalCost")
    , @NamedQuery(name = "BuyService.findByAditionalCostDescription", query = "SELECT b FROM BuyService b WHERE b.aditionalCostDescription = :aditionalCostDescription")
    , @NamedQuery(name = "BuyService.findByPhoto", query = "SELECT b FROM BuyService b WHERE b.photo = :photo")
    , @NamedQuery(name = "BuyService.findByServiceCost", query = "SELECT b FROM BuyService b WHERE b.serviceCost = :serviceCost")
    , @NamedQuery(name = "BuyService.findByStatus", query = "SELECT b FROM BuyService b WHERE b.status = :status")})
public class BuyService implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_BUY_SERVICE")
    private BigDecimal idBuyService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PACKAGE")
    private BigInteger idPackage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SEVICE")
    private BigInteger idSevice;
    @Column(name = "ADITIONAL_COST")
    private BigDecimal aditionalCost;
    @Size(max = 150)
    @Column(name = "ADITIONAL_COST_DESCRIPTION")
    private String aditionalCostDescription;
    @Size(max = 250)
    @Column(name = "PHOTO")
    private String photo;
    @Column(name = "SERVICE_COST")
    private BigInteger serviceCost;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_ORDER_SERVICE", referencedColumnName = "ID_ORDER_SERVICE")
    @ManyToOne(optional = false)
    private OrderService idOrderService;

    public BuyService() {
    }

    public BuyService(BigDecimal idBuyService) {
        this.idBuyService = idBuyService;
    }

    public BuyService(BigDecimal idBuyService, BigInteger idPackage, BigInteger idSevice) {
        this.idBuyService = idBuyService;
        this.idPackage = idPackage;
        this.idSevice = idSevice;
    }

    public BigDecimal getIdBuyService() {
        return idBuyService;
    }

    public void setIdBuyService(BigDecimal idBuyService) {
        this.idBuyService = idBuyService;
    }

    public BigInteger getIdPackage() {
        return idPackage;
    }

    public void setIdPackage(BigInteger idPackage) {
        this.idPackage = idPackage;
    }

    public BigInteger getIdSevice() {
        return idSevice;
    }

    public void setIdSevice(BigInteger idSevice) {
        this.idSevice = idSevice;
    }

    public BigDecimal getAditionalCost() {
        return aditionalCost;
    }

    public void setAditionalCost(BigDecimal aditionalCost) {
        this.aditionalCost = aditionalCost;
    }

    public String getAditionalCostDescription() {
        return aditionalCostDescription;
    }

    public void setAditionalCostDescription(String aditionalCostDescription) {
        this.aditionalCostDescription = aditionalCostDescription;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public BigInteger getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(BigInteger serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public OrderService getIdOrderService() {
        return idOrderService;
    }

    public void setIdOrderService(OrderService idOrderService) {
        this.idOrderService = idOrderService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBuyService != null ? idBuyService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BuyService)) {
            return false;
        }
        BuyService other = (BuyService) object;
        if ((this.idBuyService == null && other.idBuyService != null) || (this.idBuyService != null && !this.idBuyService.equals(other.idBuyService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.BuyService[ idBuyService=" + idBuyService + " ]";
    }
    
}
