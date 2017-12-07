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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "PAYMENT_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentLog.findAll", query = "SELECT p FROM PaymentLog p")
    , @NamedQuery(name = "PaymentLog.findByIdPayLog", query = "SELECT p FROM PaymentLog p WHERE p.idPayLog = :idPayLog")
    , @NamedQuery(name = "PaymentLog.findByDatePay", query = "SELECT p FROM PaymentLog p WHERE p.datePay = :datePay")
    , @NamedQuery(name = "PaymentLog.findByHour", query = "SELECT p FROM PaymentLog p WHERE p.hour = :hour")
    , @NamedQuery(name = "PaymentLog.findByAmount", query = "SELECT p FROM PaymentLog p WHERE p.amount = :amount")
    , @NamedQuery(name = "PaymentLog.findByIdClient", query = "SELECT p FROM PaymentLog p WHERE p.idClient = :idClient")
    , @NamedQuery(name = "PaymentLog.findByIdPartner", query = "SELECT p FROM PaymentLog p WHERE p.idPartner = :idPartner")
    , @NamedQuery(name = "PaymentLog.findByServiceDescription", query = "SELECT p FROM PaymentLog p WHERE p.serviceDescription = :serviceDescription")
    , @NamedQuery(name = "PaymentLog.findByStatus", query = "SELECT p FROM PaymentLog p WHERE p.status = :status")})
public class PaymentLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAY_LOG")
    private BigDecimal idPayLog;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_PAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datePay;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hour;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "AMOUNT")
    private String amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CLIENT")
    private BigInteger idClient;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PARTNER")
    private BigInteger idPartner;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "SERVICE_DESCRIPTION")
    private String serviceDescription;
    @Column(name = "STATUS")
    private Character status;

    public PaymentLog() {
    }

    public PaymentLog(BigDecimal idPayLog) {
        this.idPayLog = idPayLog;
    }

    public PaymentLog(BigDecimal idPayLog, Date datePay, Date hour, String amount, BigInteger idClient, BigInteger idPartner, String serviceDescription) {
        this.idPayLog = idPayLog;
        this.datePay = datePay;
        this.hour = hour;
        this.amount = amount;
        this.idClient = idClient;
        this.idPartner = idPartner;
        this.serviceDescription = serviceDescription;
    }

    public BigDecimal getIdPayLog() {
        return idPayLog;
    }

    public void setIdPayLog(BigDecimal idPayLog) {
        this.idPayLog = idPayLog;
    }

    public Date getDatePay() {
        return datePay;
    }

    public void setDatePay(Date datePay) {
        this.datePay = datePay;
    }

    public Date getHour() {
        return hour;
    }

    public void setHour(Date hour) {
        this.hour = hour;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public BigInteger getIdClient() {
        return idClient;
    }

    public void setIdClient(BigInteger idClient) {
        this.idClient = idClient;
    }

    public BigInteger getIdPartner() {
        return idPartner;
    }

    public void setIdPartner(BigInteger idPartner) {
        this.idPartner = idPartner;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPayLog != null ? idPayLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentLog)) {
            return false;
        }
        PaymentLog other = (PaymentLog) object;
        if ((this.idPayLog == null && other.idPayLog != null) || (this.idPayLog != null && !this.idPayLog.equals(other.idPayLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.PaymentLog[ idPayLog=" + idPayLog + " ]";
    }
    
}
