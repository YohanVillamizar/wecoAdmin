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
@Table(name = "TECHNICAL_SOPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TechnicalSoport.findAll", query = "SELECT t FROM TechnicalSoport t")
    , @NamedQuery(name = "TechnicalSoport.findByIdReport", query = "SELECT t FROM TechnicalSoport t WHERE t.idReport = :idReport")
    , @NamedQuery(name = "TechnicalSoport.findByReceiveDate", query = "SELECT t FROM TechnicalSoport t WHERE t.receiveDate = :receiveDate")
    , @NamedQuery(name = "TechnicalSoport.findByDeliveryDate", query = "SELECT t FROM TechnicalSoport t WHERE t.deliveryDate = :deliveryDate")
    , @NamedQuery(name = "TechnicalSoport.findByReason", query = "SELECT t FROM TechnicalSoport t WHERE t.reason = :reason")
    , @NamedQuery(name = "TechnicalSoport.findBySolution", query = "SELECT t FROM TechnicalSoport t WHERE t.solution = :solution")
    , @NamedQuery(name = "TechnicalSoport.findByObservations", query = "SELECT t FROM TechnicalSoport t WHERE t.observations = :observations")
    , @NamedQuery(name = "TechnicalSoport.findByStatus", query = "SELECT t FROM TechnicalSoport t WHERE t.status = :status")})
public class TechnicalSoport implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REPORT")
    private BigDecimal idReport;
    @Basic(optional = false)
    @NotNull
    @Column(name = "RECEIVE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiveDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DELIVERY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deliveryDate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "REASON")
    private String reason;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "SOLUTION")
    private String solution;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "OBSERVATIONS")
    private String observations;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_COMPLAINT", referencedColumnName = "ID_COMPLAINT")
    @ManyToOne(optional = false)
    private Complaint idComplaint;
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    @ManyToOne(optional = false)
    private UserWeco idUser;

    public TechnicalSoport() {
    }

    public TechnicalSoport(BigDecimal idReport) {
        this.idReport = idReport;
    }

    public TechnicalSoport(BigDecimal idReport, Date receiveDate, Date deliveryDate, String reason, String solution, String observations) {
        this.idReport = idReport;
        this.receiveDate = receiveDate;
        this.deliveryDate = deliveryDate;
        this.reason = reason;
        this.solution = solution;
        this.observations = observations;
    }

    public BigDecimal getIdReport() {
        return idReport;
    }

    public void setIdReport(BigDecimal idReport) {
        this.idReport = idReport;
    }

    public Date getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(Date receiveDate) {
        this.receiveDate = receiveDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Complaint getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(Complaint idComplaint) {
        this.idComplaint = idComplaint;
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
        hash += (idReport != null ? idReport.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TechnicalSoport)) {
            return false;
        }
        TechnicalSoport other = (TechnicalSoport) object;
        if ((this.idReport == null && other.idReport != null) || (this.idReport != null && !this.idReport.equals(other.idReport))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.TechnicalSoport[ idReport=" + idReport + " ]";
    }
    
}
