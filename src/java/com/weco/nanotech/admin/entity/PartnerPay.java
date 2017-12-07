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
@Table(name = "PARTNER_PAY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PartnerPay.findAll", query = "SELECT p FROM PartnerPay p")
    , @NamedQuery(name = "PartnerPay.findByIdPartnerPay", query = "SELECT p FROM PartnerPay p WHERE p.idPartnerPay = :idPartnerPay")
    , @NamedQuery(name = "PartnerPay.findByDescription", query = "SELECT p FROM PartnerPay p WHERE p.description = :description")
    , @NamedQuery(name = "PartnerPay.findByPayDate", query = "SELECT p FROM PartnerPay p WHERE p.payDate = :payDate")
    , @NamedQuery(name = "PartnerPay.findByHour", query = "SELECT p FROM PartnerPay p WHERE p.hour = :hour")
    , @NamedQuery(name = "PartnerPay.findByStatus", query = "SELECT p FROM PartnerPay p WHERE p.status = :status")})
public class PartnerPay implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARTNER_PAY")
    private BigDecimal idPartnerPay;
    @Size(max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PAY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date payDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hour;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_ORDER_SERVICE", referencedColumnName = "ID_ORDER_SERVICE")
    @ManyToOne(optional = false)
    private OrderService idOrderService;

    public PartnerPay() {
    }

    public PartnerPay(BigDecimal idPartnerPay) {
        this.idPartnerPay = idPartnerPay;
    }

    public PartnerPay(BigDecimal idPartnerPay, Date payDate, Date hour) {
        this.idPartnerPay = idPartnerPay;
        this.payDate = payDate;
        this.hour = hour;
    }

    public BigDecimal getIdPartnerPay() {
        return idPartnerPay;
    }

    public void setIdPartnerPay(BigDecimal idPartnerPay) {
        this.idPartnerPay = idPartnerPay;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
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

    public OrderService getIdOrderService() {
        return idOrderService;
    }

    public void setIdOrderService(OrderService idOrderService) {
        this.idOrderService = idOrderService;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPartnerPay != null ? idPartnerPay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PartnerPay)) {
            return false;
        }
        PartnerPay other = (PartnerPay) object;
        if ((this.idPartnerPay == null && other.idPartnerPay != null) || (this.idPartnerPay != null && !this.idPartnerPay.equals(other.idPartnerPay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.PartnerPay[ idPartnerPay=" + idPartnerPay + " ]";
    }
    
}
