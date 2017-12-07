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
@Table(name = "CONNECTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Connection.findAll", query = "SELECT c FROM Connection c")
    , @NamedQuery(name = "Connection.findByIdConnection", query = "SELECT c FROM Connection c WHERE c.idConnection = :idConnection")
    , @NamedQuery(name = "Connection.findByLogin", query = "SELECT c FROM Connection c WHERE c.login = :login")
    , @NamedQuery(name = "Connection.findByPassword", query = "SELECT c FROM Connection c WHERE c.password = :password")
    , @NamedQuery(name = "Connection.findByDateConnection", query = "SELECT c FROM Connection c WHERE c.dateConnection = :dateConnection")
    , @NamedQuery(name = "Connection.findByKey", query = "SELECT c FROM Connection c WHERE c.key = :key")
    , @NamedQuery(name = "Connection.findByStatus", query = "SELECT c FROM Connection c WHERE c.status = :status")})
public class Connection implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CONNECTION")
    private BigDecimal idConnection;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_CONNECTION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateConnection;
    @Size(max = 100)
    @Column(name = "KEY")
    private String key;
    @Column(name = "STATUS")
    private Character status;

    public Connection() {
    }

    public Connection(BigDecimal idConnection) {
        this.idConnection = idConnection;
    }

    public Connection(BigDecimal idConnection, String login, String password, Date dateConnection) {
        this.idConnection = idConnection;
        this.login = login;
        this.password = password;
        this.dateConnection = dateConnection;
    }

    public BigDecimal getIdConnection() {
        return idConnection;
    }

    public void setIdConnection(BigDecimal idConnection) {
        this.idConnection = idConnection;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateConnection() {
        return dateConnection;
    }

    public void setDateConnection(Date dateConnection) {
        this.dateConnection = dateConnection;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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
        hash += (idConnection != null ? idConnection.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Connection)) {
            return false;
        }
        Connection other = (Connection) object;
        if ((this.idConnection == null && other.idConnection != null) || (this.idConnection != null && !this.idConnection.equals(other.idConnection))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Connection[ idConnection=" + idConnection + " ]";
    }
    
}
