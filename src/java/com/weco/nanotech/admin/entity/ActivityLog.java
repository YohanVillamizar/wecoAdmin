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
@Table(name = "ACTIVITY_LOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ActivityLog.findAll", query = "SELECT a FROM ActivityLog a")
    , @NamedQuery(name = "ActivityLog.findByIdActivityLog", query = "SELECT a FROM ActivityLog a WHERE a.idActivityLog = :idActivityLog")
    , @NamedQuery(name = "ActivityLog.findByAutor", query = "SELECT a FROM ActivityLog a WHERE a.autor = :autor")
    , @NamedQuery(name = "ActivityLog.findByActivity", query = "SELECT a FROM ActivityLog a WHERE a.activity = :activity")
    , @NamedQuery(name = "ActivityLog.findByDateActivity", query = "SELECT a FROM ActivityLog a WHERE a.dateActivity = :dateActivity")
    , @NamedQuery(name = "ActivityLog.findByHour", query = "SELECT a FROM ActivityLog a WHERE a.hour = :hour")
    , @NamedQuery(name = "ActivityLog.findByStatus", query = "SELECT a FROM ActivityLog a WHERE a.status = :status")})
public class ActivityLog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ACTIVITY_LOG")
    private BigDecimal idActivityLog;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AUTOR")
    private String autor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ACTIVITY")
    private String activity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_ACTIVITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateActivity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hour;
    @Column(name = "STATUS")
    private Character status;

    public ActivityLog() {
    }

    public ActivityLog(BigDecimal idActivityLog) {
        this.idActivityLog = idActivityLog;
    }

    public ActivityLog(BigDecimal idActivityLog, String autor, String activity, Date dateActivity, Date hour) {
        this.idActivityLog = idActivityLog;
        this.autor = autor;
        this.activity = activity;
        this.dateActivity = dateActivity;
        this.hour = hour;
    }

    public BigDecimal getIdActivityLog() {
        return idActivityLog;
    }

    public void setIdActivityLog(BigDecimal idActivityLog) {
        this.idActivityLog = idActivityLog;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public Date getDateActivity() {
        return dateActivity;
    }

    public void setDateActivity(Date dateActivity) {
        this.dateActivity = dateActivity;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idActivityLog != null ? idActivityLog.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ActivityLog)) {
            return false;
        }
        ActivityLog other = (ActivityLog) object;
        if ((this.idActivityLog == null && other.idActivityLog != null) || (this.idActivityLog != null && !this.idActivityLog.equals(other.idActivityLog))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.ActivityLog[ idActivityLog=" + idActivityLog + " ]";
    }
    
}
