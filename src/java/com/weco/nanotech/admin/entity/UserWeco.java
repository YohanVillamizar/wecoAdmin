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
@Table(name = "USER_WECO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserWeco.findAll", query = "SELECT u FROM UserWeco u")
    , @NamedQuery(name = "UserWeco.findByIdUser", query = "SELECT u FROM UserWeco u WHERE u.idUser = :idUser")
    , @NamedQuery(name = "UserWeco.findByName", query = "SELECT u FROM UserWeco u WHERE u.name = :name")
    , @NamedQuery(name = "UserWeco.findByLastname", query = "SELECT u FROM UserWeco u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "UserWeco.findByBirthday", query = "SELECT u FROM UserWeco u WHERE u.birthday = :birthday")
    , @NamedQuery(name = "UserWeco.findByDni", query = "SELECT u FROM UserWeco u WHERE u.dni = :dni")
    , @NamedQuery(name = "UserWeco.findByAddress", query = "SELECT u FROM UserWeco u WHERE u.address = :address")
    , @NamedQuery(name = "UserWeco.findByEmail", query = "SELECT u FROM UserWeco u WHERE u.email = :email")
    , @NamedQuery(name = "UserWeco.findByLicenceNumber", query = "SELECT u FROM UserWeco u WHERE u.licenceNumber = :licenceNumber")
    , @NamedQuery(name = "UserWeco.findByGender", query = "SELECT u FROM UserWeco u WHERE u.gender = :gender")
    , @NamedQuery(name = "UserWeco.findByPhoneNumber", query = "SELECT u FROM UserWeco u WHERE u.phoneNumber = :phoneNumber")
    , @NamedQuery(name = "UserWeco.findByLogin", query = "SELECT u FROM UserWeco u WHERE u.login = :login")
    , @NamedQuery(name = "UserWeco.findByPassword", query = "SELECT u FROM UserWeco u WHERE u.password = :password")
    , @NamedQuery(name = "UserWeco.findByDateStart", query = "SELECT u FROM UserWeco u WHERE u.dateStart = :dateStart")
    , @NamedQuery(name = "UserWeco.findByDateRegister", query = "SELECT u FROM UserWeco u WHERE u.dateRegister = :dateRegister")
    , @NamedQuery(name = "UserWeco.findByCalification", query = "SELECT u FROM UserWeco u WHERE u.calification = :calification")
    , @NamedQuery(name = "UserWeco.findByPhoto", query = "SELECT u FROM UserWeco u WHERE u.photo = :photo")
    , @NamedQuery(name = "UserWeco.findByStatus", query = "SELECT u FROM UserWeco u WHERE u.status = :status")})
public class UserWeco implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USER")
    private BigDecimal idUser;
    
//    private BigDecimal idRolUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "LASTNAME")
    private String lastname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BIRTHDAY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "DNI")
    private String dni;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "LICENCE_NUMBER")
    private BigInteger licenceNumber;
    @Size(max = 1)
    @Column(name = "GENDER")
    private String gender;
    @Size(max = 25)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOGIN")
    private String login;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "DATE_START")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateStart;
    @Column(name = "DATE_REGISTER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateRegister;
    @Column(name = "CALIFICATION")
    private BigInteger calification;
    @Size(max = 200)
    @Column(name = "PHOTO")
    private String photo;
    @Column(name = "STATUS")
    private Character status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<VehiclePartner> vehiclePartnerList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<AccountBank> accountBankList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<OrderProduct> orderProductList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<VehicleClient> vehicleClientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<TechnicalSoport> technicalSoportList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUser")
    private List<ServicePartner> servicePartnerList;
    @JoinColumn(name = "ID_LOCATION", referencedColumnName = "ID_LOCATION")
    @ManyToOne(optional = false)
    private Location idLocation;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(optional = false)
    private Rol idRol;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userWecoIdUser")
    private List<CreditDebitCards> creditDebitCardsList;

    public UserWeco() {
    }

    public UserWeco(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public UserWeco(BigDecimal idUser, String name, String lastname, Date birthday, String dni, String login, String password) {
        this.idUser = idUser;
        this.name = name;
        this.lastname = lastname;
        this.birthday = birthday;
        this.dni = dni;
        this.login = login;
        this.password = password;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

//    public BigDecimal getIdRolUser() {
//        return idRolUser;
//    }
//
//    public void setIdRolUser(BigDecimal idRolUser) {
//        this.idRolUser = idRolUser;
//    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(BigInteger licenceNumber) {
        this.licenceNumber = licenceNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(Date dateRegister) {
        this.dateRegister = dateRegister;
    }

    public BigInteger getCalification() {
        return calification;
    }

    public void setCalification(BigInteger calification) {
        this.calification = calification;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }

    @XmlTransient
    public List<VehiclePartner> getVehiclePartnerList() {
        return vehiclePartnerList;
    }

    public void setVehiclePartnerList(List<VehiclePartner> vehiclePartnerList) {
        this.vehiclePartnerList = vehiclePartnerList;
    }

    @XmlTransient
    public List<AccountBank> getAccountBankList() {
        return accountBankList;
    }

    public void setAccountBankList(List<AccountBank> accountBankList) {
        this.accountBankList = accountBankList;
    }

    @XmlTransient
    public List<OrderProduct> getOrderProductList() {
        return orderProductList;
    }

    public void setOrderProductList(List<OrderProduct> orderProductList) {
        this.orderProductList = orderProductList;
    }

    @XmlTransient
    public List<VehicleClient> getVehicleClientList() {
        return vehicleClientList;
    }

    public void setVehicleClientList(List<VehicleClient> vehicleClientList) {
        this.vehicleClientList = vehicleClientList;
    }

    @XmlTransient
    public List<TechnicalSoport> getTechnicalSoportList() {
        return technicalSoportList;
    }

    public void setTechnicalSoportList(List<TechnicalSoport> technicalSoportList) {
        this.technicalSoportList = technicalSoportList;
    }

    @XmlTransient
    public List<ServicePartner> getServicePartnerList() {
        return servicePartnerList;
    }

    public void setServicePartnerList(List<ServicePartner> servicePartnerList) {
        this.servicePartnerList = servicePartnerList;
    }

    public Location getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Location idLocation) {
        this.idLocation = idLocation;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    @XmlTransient
    public List<CreditDebitCards> getCreditDebitCardsList() {
        return creditDebitCardsList;
    }

    public void setCreditDebitCardsList(List<CreditDebitCards> creditDebitCardsList) {
        this.creditDebitCardsList = creditDebitCardsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUser != null ? idUser.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserWeco)) {
            return false;
        }
        UserWeco other = (UserWeco) object;
        if ((this.idUser == null && other.idUser != null) || (this.idUser != null && !this.idUser.equals(other.idUser))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.weco.nanotech.admin.UserWeco[ idUser=" + idUser + " ]";
    }
    
}
