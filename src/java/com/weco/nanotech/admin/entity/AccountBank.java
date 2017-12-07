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
@Table(name = "ACCOUNT_BANK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AccountBank.findAll", query = "SELECT a FROM AccountBank a")
    , @NamedQuery(name = "AccountBank.findByIdAccountBank", query = "SELECT a FROM AccountBank a WHERE a.idAccountBank = :idAccountBank")
    , @NamedQuery(name = "AccountBank.findByNumberAccountBank", query = "SELECT a FROM AccountBank a WHERE a.numberAccountBank = :numberAccountBank")
    , @NamedQuery(name = "AccountBank.findByNameBank", query = "SELECT a FROM AccountBank a WHERE a.nameBank = :nameBank")
    , @NamedQuery(name = "AccountBank.findByIdAba", query = "SELECT a FROM AccountBank a WHERE a.idAba = :idAba")
    , @NamedQuery(name = "AccountBank.findByKindAccount", query = "SELECT a FROM AccountBank a WHERE a.kindAccount = :kindAccount")
    , @NamedQuery(name = "AccountBank.findByStatus", query = "SELECT a FROM AccountBank a WHERE a.status = :status")})
public class AccountBank implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACCOUNT_BANK")
    private BigDecimal idAccountBank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMBER_ACCOUNT_BANK")
    private BigDecimal numberAccountBank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NAME_BANK")
    @Temporal(TemporalType.TIMESTAMP)
    private Date nameBank;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ABA")
    private BigDecimal idAba;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "KIND_ACCOUNT")
    private String kindAccount;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private UserWeco idUser;

    public AccountBank() {
    }

    public AccountBank(BigDecimal idAccountBank) {
        this.idAccountBank = idAccountBank;
    }

    public AccountBank(BigDecimal idAccountBank, BigDecimal numberAccountBank, Date nameBank, BigDecimal idAba, String kindAccount) {
        this.idAccountBank = idAccountBank;
        this.numberAccountBank = numberAccountBank;
        this.nameBank = nameBank;
        this.idAba = idAba;
        this.kindAccount = kindAccount;
    }

    public BigDecimal getIdAccountBank() {
        return idAccountBank;
    }

    public void setIdAccountBank(BigDecimal idAccountBank) {
        this.idAccountBank = idAccountBank;
    }

    public BigDecimal getNumberAccountBank() {
        return numberAccountBank;
    }

    public void setNumberAccountBank(BigDecimal numberAccountBank) {
        this.numberAccountBank = numberAccountBank;
    }

    public Date getNameBank() {
        return nameBank;
    }

    public void setNameBank(Date nameBank) {
        this.nameBank = nameBank;
    }

    public BigDecimal getIdAba() {
        return idAba;
    }

    public void setIdAba(BigDecimal idAba) {
        this.idAba = idAba;
    }

    public String getKindAccount() {
        return kindAccount;
    }

    public void setKindAccount(String kindAccount) {
        this.kindAccount = kindAccount;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
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
        hash += (idAccountBank != null ? idAccountBank.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccountBank)) {
            return false;
        }
        AccountBank other = (AccountBank) object;
        if ((this.idAccountBank == null && other.idAccountBank != null) || (this.idAccountBank != null && !this.idAccountBank.equals(other.idAccountBank))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.AccountBank[ idAccountBank=" + idAccountBank + " ]";
    }
    
}
