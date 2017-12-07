/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.weco.nanotech.admin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p")
    , @NamedQuery(name = "Product.findByIdProduct", query = "SELECT p FROM Product p WHERE p.idProduct = :idProduct")
    , @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name")
    , @NamedQuery(name = "Product.findByProductCost", query = "SELECT p FROM Product p WHERE p.productCost = :productCost")
    , @NamedQuery(name = "Product.findByPeso", query = "SELECT p FROM Product p WHERE p.peso = :peso")
    , @NamedQuery(name = "Product.findByDimension", query = "SELECT p FROM Product p WHERE p.dimension = :dimension")
    , @NamedQuery(name = "Product.findByInventory", query = "SELECT p FROM Product p WHERE p.inventory = :inventory")
    , @NamedQuery(name = "Product.findByDescription", query = "SELECT p FROM Product p WHERE p.description = :description")
    , @NamedQuery(name = "Product.findByStatus", query = "SELECT p FROM Product p WHERE p.status = :status")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCT")
    private BigDecimal idProduct;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NAME")
    private String name;
    @Column(name = "PRODUCT_COST")
    private BigDecimal productCost;
    @Column(name = "PESO")
    private BigInteger peso;
    @Size(max = 50)
    @Column(name = "DIMENSION")
    private String dimension;
    @Column(name = "INVENTORY")
    private BigInteger inventory;
    @Size(max = 100)
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProduct")
    private List<ProductOrderProduct> productOrderProductList;

    public Product() {
    }

    public Product(BigDecimal idProduct) {
        this.idProduct = idProduct;
    }

    public Product(BigDecimal idProduct, String name) {
        this.idProduct = idProduct;
        this.name = name;
    }

    public BigDecimal getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(BigDecimal idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getProductCost() {
        return productCost;
    }

    public void setProductCost(BigDecimal productCost) {
        this.productCost = productCost;
    }

    public BigInteger getPeso() {
        return peso;
    }

    public void setPeso(BigInteger peso) {
        this.peso = peso;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public BigInteger getInventory() {
        return inventory;
    }

    public void setInventory(BigInteger inventory) {
        this.inventory = inventory;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduct != null ? idProduct.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.idProduct == null && other.idProduct != null) || (this.idProduct != null && !this.idProduct.equals(other.idProduct))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Product[ idProduct=" + idProduct + " ]";
    }
    
}
