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
@Table(name = "COMPLAINT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Complaint.findAll", query = "SELECT c FROM Complaint c")
    , @NamedQuery(name = "Complaint.findByIdComplaint", query = "SELECT c FROM Complaint c WHERE c.idComplaint = :idComplaint")
    , @NamedQuery(name = "Complaint.findBySubject", query = "SELECT c FROM Complaint c WHERE c.subject = :subject")
    , @NamedQuery(name = "Complaint.findByDescription", query = "SELECT c FROM Complaint c WHERE c.description = :description")
    , @NamedQuery(name = "Complaint.findByPhoto", query = "SELECT c FROM Complaint c WHERE c.photo = :photo")
    , @NamedQuery(name = "Complaint.findByComplaintDate", query = "SELECT c FROM Complaint c WHERE c.complaintDate = :complaintDate")
    , @NamedQuery(name = "Complaint.findByStatus", query = "SELECT c FROM Complaint c WHERE c.status = :status")
    , @NamedQuery(name = "Complaint.findByIdProductService", query = "SELECT c FROM Complaint c WHERE c.idProductService = :idProductService")
    , @NamedQuery(name = "Complaint.findByTipoProductService", query = "SELECT c FROM Complaint c WHERE c.tipoProductService = :tipoProductService")})
public class Complaint implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COMPLAINT")
    private BigDecimal idComplaint;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SUBJECT")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "PHOTO")
    private String photo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COMPLAINT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date complaintDate;
    @Column(name = "STATUS")
    private Character status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRODUCT_SERVICE")
    private BigInteger idProductService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO_PRODUCT_SERVICE")
    private BigInteger tipoProductService;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idComplaint")
    private List<TechnicalSoport> technicalSoportList;
    @JoinColumn(name = "ID_ORDER_PRODUCT", referencedColumnName = "ID_ORDER_PRODUCT")
    @ManyToOne(optional = false)
    private OrderProduct idOrderProduct;
    @JoinColumn(name = "ID_ORDER_SERVICE", referencedColumnName = "ID_ORDER_SERVICE")
    @ManyToOne(optional = false)
    private OrderService idOrderService;

    public Complaint() {
    }

    public Complaint(BigDecimal idComplaint) {
        this.idComplaint = idComplaint;
    }

    public Complaint(BigDecimal idComplaint, String subject, String description, String photo, Date complaintDate, BigInteger idProductService, BigInteger tipoProductService) {
        this.idComplaint = idComplaint;
        this.subject = subject;
        this.description = description;
        this.photo = photo;
        this.complaintDate = complaintDate;
        this.idProductService = idProductService;
        this.tipoProductService = tipoProductService;
    }

    public BigDecimal getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(BigDecimal idComplaint) {
        this.idComplaint = idComplaint;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getComplaintDate() {
        return complaintDate;
    }

    public void setComplaintDate(Date complaintDate) {
        this.complaintDate = complaintDate;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public BigInteger getIdProductService() {
        return idProductService;
    }

    public void setIdProductService(BigInteger idProductService) {
        this.idProductService = idProductService;
    }

    public BigInteger getTipoProductService() {
        return tipoProductService;
    }

    public void setTipoProductService(BigInteger tipoProductService) {
        this.tipoProductService = tipoProductService;
    }

    @XmlTransient
    public List<TechnicalSoport> getTechnicalSoportList() {
        return technicalSoportList;
    }

    public void setTechnicalSoportList(List<TechnicalSoport> technicalSoportList) {
        this.technicalSoportList = technicalSoportList;
    }

    public OrderProduct getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(OrderProduct idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
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
        hash += (idComplaint != null ? idComplaint.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Complaint)) {
            return false;
        }
        Complaint other = (Complaint) object;
        if ((this.idComplaint == null && other.idComplaint != null) || (this.idComplaint != null && !this.idComplaint.equals(other.idComplaint))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.Complaint[ idComplaint=" + idComplaint + " ]";
    }
    
}
