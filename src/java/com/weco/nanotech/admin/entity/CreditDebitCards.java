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
@Table(name = "CREDIT_DEBIT_CARDS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CreditDebitCards.findAll", query = "SELECT c FROM CreditDebitCards c")
    , @NamedQuery(name = "CreditDebitCards.findByIdCreditDebitCards", query = "SELECT c FROM CreditDebitCards c WHERE c.idCreditDebitCards = :idCreditDebitCards")
    , @NamedQuery(name = "CreditDebitCards.findByNumberCard", query = "SELECT c FROM CreditDebitCards c WHERE c.numberCard = :numberCard")
    , @NamedQuery(name = "CreditDebitCards.findByDueDate", query = "SELECT c FROM CreditDebitCards c WHERE c.dueDate = :dueDate")
    , @NamedQuery(name = "CreditDebitCards.findByCvc", query = "SELECT c FROM CreditDebitCards c WHERE c.cvc = :cvc")
    , @NamedQuery(name = "CreditDebitCards.findByQrCode", query = "SELECT c FROM CreditDebitCards c WHERE c.qrCode = :qrCode")
    , @NamedQuery(name = "CreditDebitCards.findByStatus", query = "SELECT c FROM CreditDebitCards c WHERE c.status = :status")})
public class CreditDebitCards implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CREDIT_DEBIT_CARDS")
    private BigDecimal idCreditDebitCards;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBER_CARD")
    private BigDecimal numberCard;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DUE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dueDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CVC")
    private BigDecimal cvc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "QR_CODE")
    private String qrCode;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "USER_WECO_ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private UserWeco userWecoIdUser;

    public CreditDebitCards() {
    }

    public CreditDebitCards(BigDecimal idCreditDebitCards) {
        this.idCreditDebitCards = idCreditDebitCards;
    }

    public CreditDebitCards(BigDecimal idCreditDebitCards, BigDecimal numberCard, Date dueDate, BigDecimal cvc, String qrCode) {
        this.idCreditDebitCards = idCreditDebitCards;
        this.numberCard = numberCard;
        this.dueDate = dueDate;
        this.cvc = cvc;
        this.qrCode = qrCode;
    }

    public BigDecimal getIdCreditDebitCards() {
        return idCreditDebitCards;
    }

    public void setIdCreditDebitCards(BigDecimal idCreditDebitCards) {
        this.idCreditDebitCards = idCreditDebitCards;
    }

    public BigDecimal getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(BigDecimal numberCard) {
        this.numberCard = numberCard;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public BigDecimal getCvc() {
        return cvc;
    }

    public void setCvc(BigDecimal cvc) {
        this.cvc = cvc;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public UserWeco getUserWecoIdUser() {
        return userWecoIdUser;
    }

    public void setUserWecoIdUser(UserWeco userWecoIdUser) {
        this.userWecoIdUser = userWecoIdUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCreditDebitCards != null ? idCreditDebitCards.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CreditDebitCards)) {
            return false;
        }
        CreditDebitCards other = (CreditDebitCards) object;
        if ((this.idCreditDebitCards == null && other.idCreditDebitCards != null) || (this.idCreditDebitCards != null && !this.idCreditDebitCards.equals(other.idCreditDebitCards))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.CreditDebitCards[ idCreditDebitCards=" + idCreditDebitCards + " ]";
    }
    
}
