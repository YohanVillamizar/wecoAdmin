/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author YohanVillamizar
 */
@Entity
@Table(name = "ORDER_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderProduct.findAll", query = "SELECT o FROM OrderProduct o")
    , @NamedQuery(name = "OrderProduct.findByIdOrderProduct", query = "SELECT o FROM OrderProduct o WHERE o.idOrderProduct = :idOrderProduct")
    , @NamedQuery(name = "OrderProduct.findByGainProduct", query = "SELECT o FROM OrderProduct o WHERE o.gainProduct = :gainProduct")
    , @NamedQuery(name = "OrderProduct.findByDeliveryCost", query = "SELECT o FROM OrderProduct o WHERE o.deliveryCost = :deliveryCost")
    , @NamedQuery(name = "OrderProduct.findByCaliforniaSalesTax", query = "SELECT o FROM OrderProduct o WHERE o.californiaSalesTax = :californiaSalesTax")
    , @NamedQuery(name = "OrderProduct.findBySubTotal", query = "SELECT o FROM OrderProduct o WHERE o.subTotal = :subTotal")
    , @NamedQuery(name = "OrderProduct.findByTotal", query = "SELECT o FROM OrderProduct o WHERE o.total = :total")
    , @NamedQuery(name = "OrderProduct.findByDateOrder", query = "SELECT o FROM OrderProduct o WHERE o.dateOrder = :dateOrder")
    , @NamedQuery(name = "OrderProduct.findByHour", query = "SELECT o FROM OrderProduct o WHERE o.hour = :hour")
    , @NamedQuery(name = "OrderProduct.findByDescription", query = "SELECT o FROM OrderProduct o WHERE o.description = :description")
    , @NamedQuery(name = "OrderProduct.findByStatus", query = "SELECT o FROM OrderProduct o WHERE o.status = :status")})
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDER_PRODUCT")
    private BigDecimal idOrderProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GAIN_PRODUCT")
    private BigDecimal gainProduct;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERY_COST")
    private BigDecimal deliveryCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CALIFORNIA_SALES_TAX")
    private BigInteger californiaSalesTax;
    @Column(name = "SUB_TOTAL")
    private BigInteger subTotal;
    @Column(name = "TOTAL")
    private BigInteger total;
    @Column(name = "DATE_ORDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrder;
    @Column(name = "HOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hour;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrderProduct")
    private List<ProductOrderProduct> productOrderProductList;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private UserWeco idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrderProduct")
    private List<Complaint> complaintList;

    public OrderProduct() {
    }

    public OrderProduct(BigDecimal idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public OrderProduct(BigDecimal idOrderProduct, BigDecimal gainProduct, BigDecimal deliveryCost, BigInteger californiaSalesTax) {
        this.idOrderProduct = idOrderProduct;
        this.gainProduct = gainProduct;
        this.deliveryCost = deliveryCost;
        this.californiaSalesTax = californiaSalesTax;
    }

    public BigDecimal getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(BigDecimal idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public BigDecimal getGainProduct() {
        return gainProduct;
    }

    public void setGainProduct(BigDecimal gainProduct) {
        this.gainProduct = gainProduct;
    }

    public BigDecimal getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(BigDecimal deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public BigInteger getCaliforniaSalesTax() {
        return californiaSalesTax;
    }

    public void setCaliforniaSalesTax(BigInteger californiaSalesTax) {
        this.californiaSalesTax = californiaSalesTax;
    }

    public BigInteger getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigInteger subTotal) {
        this.subTotal = subTotal;
    }

    public BigInteger getTotal() {
        return total;
    }

    public void setTotal(BigInteger total) {
        this.total = total;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
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
    public List<ProductOrderProduct> getProductOrderProductList() {
        return productOrderProductList;
    }

    public void setProductOrderProductList(List<ProductOrderProduct> productOrderProductList) {
        this.productOrderProductList = productOrderProductList;
    }

    public UserWeco getIdUser() {
        return idUser;
    }

    public void setIdUser(UserWeco idUser) {
        this.idUser = idUser;
    }

    @XmlTransient
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderProduct != null ? idOrderProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderProduct)) {
            return false;
        }
        OrderProduct other = (OrderProduct) object;
        if ((this.idOrderProduct == null && other.idOrderProduct != null) || (this.idOrderProduct != null && !this.idOrderProduct.equals(other.idOrderProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.OrderProduct[ idOrderProduct=" + idOrderProduct + " ]";
    }
    
}
