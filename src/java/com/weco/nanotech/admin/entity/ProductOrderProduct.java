/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author YohanVillamizar
 */
@Entity
@Table(name = "PRODUCT_ORDER_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductOrderProduct.findAll", query = "SELECT p FROM ProductOrderProduct p")
    , @NamedQuery(name = "ProductOrderProduct.findByIdProdOrderProd", query = "SELECT p FROM ProductOrderProduct p WHERE p.idProdOrderProd = :idProdOrderProd")
    , @NamedQuery(name = "ProductOrderProduct.findByAditionalCost", query = "SELECT p FROM ProductOrderProduct p WHERE p.aditionalCost = :aditionalCost")
    , @NamedQuery(name = "ProductOrderProduct.findByAditionalCostDescription", query = "SELECT p FROM ProductOrderProduct p WHERE p.aditionalCostDescription = :aditionalCostDescription")
    , @NamedQuery(name = "ProductOrderProduct.findByPhoto", query = "SELECT p FROM ProductOrderProduct p WHERE p.photo = :photo")
    , @NamedQuery(name = "ProductOrderProduct.findByDatePOP", query = "SELECT p FROM ProductOrderProduct p WHERE p.datePOP = :datePOP")
    , @NamedQuery(name = "ProductOrderProduct.findByHour", query = "SELECT p FROM ProductOrderProduct p WHERE p.hour = :hour")
    , @NamedQuery(name = "ProductOrderProduct.findByStatus", query = "SELECT p FROM ProductOrderProduct p WHERE p.status = :status")
    , @NamedQuery(name = "ProductOrderProduct.findByProductCost", query = "SELECT p FROM ProductOrderProduct p WHERE p.productCost = :productCost")})
public class ProductOrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PROD_ORDER_PROD")
    private BigDecimal idProdOrderProd;
    @Column(name = "ADITIONAL_COST")
    private BigDecimal aditionalCost;
    @Size(max = 150)
    @Column(name = "ADITIONAL_COST_DESCRIPTION")
    private String aditionalCostDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "PHOTO")
    private String photo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_P_O_P")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePOP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hour;
    @Column(name = "STATUS")
    private Character status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRODUCT_COST")
    private BigDecimal productCost;
    @JoinColumn(name = "ID_ORDER_PRODUCT", referencedColumnName = "ID_ORDER_PRODUCT")
    @ManyToOne(optional = false)
    private OrderProduct idOrderProduct;
    @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "ID_PRODUCT")
    @ManyToOne(optional = false)
    private Product idProduct;

    public ProductOrderProduct() {
    }

    public ProductOrderProduct(BigDecimal idProdOrderProd) {
        this.idProdOrderProd = idProdOrderProd;
    }

    public ProductOrderProduct(BigDecimal idProdOrderProd, String photo, Date datePOP, Date hour, BigDecimal productCost) {
        this.idProdOrderProd = idProdOrderProd;
        this.photo = photo;
        this.datePOP = datePOP;
        this.hour = hour;
        this.productCost = productCost;
    }

    public BigDecimal getIdProdOrderProd() {
        return idProdOrderProd;
    }

    public void setIdProdOrderProd(BigDecimal idProdOrderProd) {
        this.idProdOrderProd = idProdOrderProd;
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

    public Date getDatePOP() {
        return datePOP;
    }

    public void setDatePOP(Date datePOP) {
        this.datePOP = datePOP;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public OrderProduct getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(OrderProduct idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProdOrderProd != null ? idProdOrderProd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductOrderProduct)) {
            return false;
        }
        ProductOrderProduct other = (ProductOrderProduct) object;
        if ((this.idProdOrderProd == null && other.idProdOrderProd != null) || (this.idProdOrderProd != null && !this.idProdOrderProd.equals(other.idProdOrderProd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.ProductOrderProduct[ idProdOrderProd=" + idProdOrderProd + " ]";
    }
    
}
