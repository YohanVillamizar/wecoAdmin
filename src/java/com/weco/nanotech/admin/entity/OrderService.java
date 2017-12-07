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
@Table(name = "ORDER_SERVICE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderService.findAll", query = "SELECT o FROM OrderService o")
    , @NamedQuery(name = "OrderService.findByIdOrderService", query = "SELECT o FROM OrderService o WHERE o.idOrderService = :idOrderService")
    , @NamedQuery(name = "OrderService.findByComissionService", query = "SELECT o FROM OrderService o WHERE o.comissionService = :comissionService")
    , @NamedQuery(name = "OrderService.findByTipService", query = "SELECT o FROM OrderService o WHERE o.tipService = :tipService")
    , @NamedQuery(name = "OrderService.findByDateOrder", query = "SELECT o FROM OrderService o WHERE o.dateOrder = :dateOrder")
    , @NamedQuery(name = "OrderService.findByTotal", query = "SELECT o FROM OrderService o WHERE o.total = :total")
    , @NamedQuery(name = "OrderService.findByStartDate", query = "SELECT o FROM OrderService o WHERE o.startDate = :startDate")
    , @NamedQuery(name = "OrderService.findByEndDate", query = "SELECT o FROM OrderService o WHERE o.endDate = :endDate")
    , @NamedQuery(name = "OrderService.findByStartHour", query = "SELECT o FROM OrderService o WHERE o.startHour = :startHour")
    , @NamedQuery(name = "OrderService.findByEndHour", query = "SELECT o FROM OrderService o WHERE o.endHour = :endHour")
    , @NamedQuery(name = "OrderService.findByWecoFee", query = "SELECT o FROM OrderService o WHERE o.wecoFee = :wecoFee")
    , @NamedQuery(name = "OrderService.findByComissionFee", query = "SELECT o FROM OrderService o WHERE o.comissionFee = :comissionFee")
    , @NamedQuery(name = "OrderService.findByGainPartner", query = "SELECT o FROM OrderService o WHERE o.gainPartner = :gainPartner")
    , @NamedQuery(name = "OrderService.findByStatus", query = "SELECT o FROM OrderService o WHERE o.status = :status")})
public class OrderService implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ORDER_SERVICE")
    private BigDecimal idOrderService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "COMISSION_SERVICE")
    private String comissionService;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "TIP_SERVICE")
    private String tipService;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_ORDER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "START_HOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startHour;
    @Basic(optional = false)
    @NotNull
    @Column(name = "END_HOUR")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endHour;
    @Column(name = "WECO_FEE")
    private BigInteger wecoFee;
    @Column(name = "COMISSION_FEE")
    private BigInteger comissionFee;
    @Column(name = "GAIN_PARTNER")
    private BigInteger gainPartner;
    @Column(name = "STATUS")
    private Character status;
    @JoinColumn(name = "ID_LOCATION", referencedColumnName = "ID_LOCATION")
    @ManyToOne(optional = false)
    private Location idLocation;
    @JoinColumn(name = "ID_VEHICLE_CLIENT", referencedColumnName = "ID_VEHICLE_CLIENT")
    @ManyToOne(optional = false)
    private VehicleClient idVehicleClient;
    @JoinColumn(name = "ID_VEHICLE_PARTNER", referencedColumnName = "ID_VEHICLE_PARTNER")
    @ManyToOne(optional = false)
    private VehiclePartner idVehiclePartner;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrderService")
    private List<PartnerPay> partnerPayList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrderService")
    private List<Complaint> complaintList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idOrderService")
    private List<BuyService> buyServiceList;

    public OrderService() {
    }

    public OrderService(BigDecimal idOrderService) {
        this.idOrderService = idOrderService;
    }

    public OrderService(BigDecimal idOrderService, String comissionService, String tipService, Date dateOrder, BigDecimal total, Date startDate, Date endDate, Date startHour, Date endHour) {
        this.idOrderService = idOrderService;
        this.comissionService = comissionService;
        this.tipService = tipService;
        this.dateOrder = dateOrder;
        this.total = total;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public BigDecimal getIdOrderService() {
        return idOrderService;
    }

    public void setIdOrderService(BigDecimal idOrderService) {
        this.idOrderService = idOrderService;
    }

    public String getComissionService() {
        return comissionService;
    }

    public void setComissionService(String comissionService) {
        this.comissionService = comissionService;
    }

    public String getTipService() {
        return tipService;
    }

    public void setTipService(String tipService) {
        this.tipService = tipService;
    }

    public Date getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(Date dateOrder) {
        this.dateOrder = dateOrder;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
    }

    public BigInteger getWecoFee() {
        return wecoFee;
    }

    public void setWecoFee(BigInteger wecoFee) {
        this.wecoFee = wecoFee;
    }

    public BigInteger getComissionFee() {
        return comissionFee;
    }

    public void setComissionFee(BigInteger comissionFee) {
        this.comissionFee = comissionFee;
    }

    public BigInteger getGainPartner() {
        return gainPartner;
    }

    public void setGainPartner(BigInteger gainPartner) {
        this.gainPartner = gainPartner;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    public Location getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Location idLocation) {
        this.idLocation = idLocation;
    }

    public VehicleClient getIdVehicleClient() {
        return idVehicleClient;
    }

    public void setIdVehicleClient(VehicleClient idVehicleClient) {
        this.idVehicleClient = idVehicleClient;
    }

    public VehiclePartner getIdVehiclePartner() {
        return idVehiclePartner;
    }

    public void setIdVehiclePartner(VehiclePartner idVehiclePartner) {
        this.idVehiclePartner = idVehiclePartner;
    }

    @XmlTransient
    public List<PartnerPay> getPartnerPayList() {
        return partnerPayList;
    }

    public void setPartnerPayList(List<PartnerPay> partnerPayList) {
        this.partnerPayList = partnerPayList;
    }

    @XmlTransient
    public List<Complaint> getComplaintList() {
        return complaintList;
    }

    public void setComplaintList(List<Complaint> complaintList) {
        this.complaintList = complaintList;
    }

    @XmlTransient
    public List<BuyService> getBuyServiceList() {
        return buyServiceList;
    }

    public void setBuyServiceList(List<BuyService> buyServiceList) {
        this.buyServiceList = buyServiceList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrderService != null ? idOrderService.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderService)) {
            return false;
        }
        OrderService other = (OrderService) object;
        if ((this.idOrderService == null && other.idOrderService != null) || (this.idOrderService != null && !this.idOrderService.equals(other.idOrderService))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.OrderService[ idOrderService=" + idOrderService + " ]";
    }
    
}
