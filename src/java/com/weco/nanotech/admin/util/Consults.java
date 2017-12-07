package com.weco.nanotech.admin.util;

import com.weco.nanotech.admin.entity.UserWeco;
import java.math.BigDecimal;
import java.math.BigInteger;

public class Consults {

    String Query;

    public String getUserByLogin(String correo) {
        Query = "SELECT *\n"
                + "FROM USER_WECO\n"
                + "WHERE login = '" + correo + "'";
        return Query;
    }

    public String getPartnerManagment(int idCliente) {
        Query = "SELECT DISTINCT UW.ID_USER, UW.NAME, UW.EMAIL, UW.DATE_START, ( SELECT SUM(BS.GAIN_PARTNER)\n"
                + "                                                                FROM BUY_SERVICE BS, ORDER_SERVICE OS, VEHICLE_PARTNER VP, USER_WECO UW\n"
                + "                                                                WHERE BS.ID_ORDER_SERVICE = OS.ID_ORDER_SERVICE\n"
                + "                                                                AND OS.ID_VEHICLE_PARTNER = VP.ID_VEHICLE_PARTNER\n"
                + "                                                                AND VP.ID_USER = UW.ID_USER\n"
                + "                                                                AND UW.ID_USER = " + idCliente + ") AS PROFITS\n"
                + "FROM BUY_SERVICE BS, ORDER_SERVICE OS, VEHICLE_PARTNER VP, USER_WECO UW\n"
                + "WHERE BS.ID_ORDER_SERVICE = OS.ID_ORDER_SERVICE\n"
                + "AND OS.ID_VEHICLE_PARTNER = VP.ID_VEHICLE_PARTNER\n"
                + "AND VP.ID_USER = UW.ID_USER\n"
                + "AND UW.ID_USER = " + idCliente + "\n"
                + "ORDER BY UW.ID_USER";
        return Query;
    }

    public String getPartnersManagment() {
        Query = "SELECT DISTINCT UW.ID_USER\n"
                + "FROM BUY_SERVICE BS, ORDER_SERVICE OS, VEHICLE_PARTNER VP, USER_WECO UW\n"
                + "WHERE BS.ID_ORDER_SERVICE = OS.ID_ORDER_SERVICE\n"
                + "AND OS.ID_VEHICLE_PARTNER = VP.ID_VEHICLE_PARTNER\n"
                + "AND VP.ID_USER = UW.ID_USER\n"
                + "ORDER BY UW.ID_USER;";
        return Query;
    }

    public String getCustomersManagment() {
        Query = "SELECT UW.ID_USER, UW.NAME, UW.LASTNAME, UW.LICENCE_NUMBER, UW.EMAIL\n"
                + "FROM USER_WECO UW\n"
                + "WHERE UW.ID_ROL = '2';";
        return Query;
    }

    public String getDetailCustomerManagmentById(BigDecimal idUser) {
        Query = "SELECT UW.ID_USER, L.DIRECTION AS LOCATION, C.NAME AS CITY, CT.NAME AS COUNTRY, UW.ADDRESS, UW.NAME, UW.LASTNAME, UW.EMAIL, UW.BIRTHDAY, \n"
                + "UW.CALIFICATION, UW.DATE_REGISTER, UW.GENDER, UW.LICENCE_NUMBER, UW.PHONE_NUMBER\n"
                + "FROM USER_WECO UW, LOCATION L, CITY C, COUNTRY CT\n"
                + "WHERE UW.ID_LOCATION = L.ID_LOCATION\n"
                + "AND L.ID_CITY = C.ID_CITY\n"
                + "AND C.ID_COUNTRY = CT.ID_COUNTRY\n"
                + "AND UW.ID_USER = '" + idUser + "';";
        return Query;
    }

    public String getVehiclesOfCustomerManagmentById(BigDecimal idUser) {
        Query = "SELECT V.ID_VEHICLE, M.NAME AS MARCA, MD.NAME AS MODELO, V.COLOR, V.VEHICLE_LICENCE_PLATE AS PLACA, V.YEAR AS AÑO, VC.DESCRIPTION\n"
                + "FROM MARK M, MODEL MD, VEHICLE V, VEHICLE_CLIENT VC, USER_WECO UW\n"
                + "WHERE M.ID_MARK = MD.ID_MARK\n"
                + "AND MD.ID_MODEL = V.ID_MODEL\n"
                + "AND V.ID_VEHICLE = VC.ID_VEHICLE\n"
                + "AND VC.ID_USER = UW.ID_USER\n"
                + "AND UW.ID_USER = '" + idUser + "';";
        return Query;
    }

    public String getDetailPartnerManagmentById(BigDecimal idUser) {
        Query = "SELECT UW.ID_USER, L.DIRECTION AS LOCATION, C.NAME AS CITY, CT.NAME AS COUNTRY, UW.ADDRESS, UW.NAME, UW.LASTNAME, UW.EMAIL, UW.BIRTHDAY, \n"
                + "UW.DNI, UW.CALIFICATION, UW.DATE_REGISTER, UW.DATE_START, UW.GENDER, UW.LICENCE_NUMBER, UW.PHONE_NUMBER\n"
                + "FROM USER_WECO UW, LOCATION L, CITY C, COUNTRY CT\n"
                + "WHERE UW.ID_LOCATION = L.ID_LOCATION\n"
                + "AND L.ID_CITY = C.ID_CITY\n"
                + "AND C.ID_COUNTRY = CT.ID_COUNTRY\n"
                + "AND UW.ID_USER = '" + idUser + "';";
        return Query;
    }

    public String getVehiclesOfPartnerManagmentById(BigDecimal idUser) {
        Query = "SELECT V.ID_VEHICLE, M.NAME AS MARCA, MD.NAME AS MODELO, V.COLOR, V.VEHICLE_LICENCE_PLATE AS PLACA, V.YEAR AS AÑO, VP.INSURANCE, VP.OWNERSHIP_TITTLE, VP.REGISTRATION\n"
                + "FROM MARK M, MODEL MD, VEHICLE V, VEHICLE_PARTNER VP, USER_WECO UW\n"
                + "WHERE M.ID_MARK = MD.ID_MARK\n"
                + "AND MD.ID_MODEL = V.ID_MODEL\n"
                + "AND V.ID_VEHICLE = VP.ID_VEHICLE\n"
                + "AND VP.ID_USER = UW.ID_USER\n"
                + "AND UW.ID_USER = '" + idUser + "';";
        return Query;
    }

    public String getProductsManagment() {
        Query = "SELECT *\n"
                + "FROM PRODUCT;";
        return Query;
    }

    public String getOrderServiceManagment() {
        Query = "SELECT OS.ID_ORDER_SERVICE, OS.DATE_ORDER, OS.START_HOUR, OS.TOTAL, UC.NAME AS CLIENT_NAME, UC.LASTNAME AS CLIENT_LASTNAME, UP.NAME AS PARTNER_NAME, UP.LASTNAME AS PARTNER_LASTNAME\n"
                + "FROM ORDER_SERVICE OS, VEHICLE_CLIENT VC, USER_WECO UC, VEHICLE_PARTNER VP, USER_WECO UP\n"
                + "WHERE OS.ID_VEHICLE_CLIENT = VC.ID_VEHICLE_CLIENT\n"
                + "AND VC.ID_USER = UC.ID_USER\n"
                + "AND OS.ID_VEHICLE_PARTNER = VP.ID_VEHICLE_PARTNER\n"
                + "AND VP.ID_USER = UP.ID_USER;";
        return Query;
    }

    public String getSummaryOrderServiceManagment(BigDecimal idOrderService) {
        Query = "SELECT OS.ID_ORDER_SERVICE, OS.DATE_ORDER, OS.START_HOUR, OS.COMISSION_FEE, OS.WECO_FEE, OS.GAIN_PARTNER, OS.TIP_SERVICE, OS.TOTAL, OS.STATUS, \n"
                + "UC.ID_USER, UC.NAME AS CLIENT_NAME, UC.LASTNAME AS CLIENT_LASTNAME, UC.PHONE_NUMBER, UC.EMAIL, LO.NAME, CO.NAME, CTO.NAME, LO.ZIPCODE\n"
                + "FROM ORDER_SERVICE OS, VEHICLE_CLIENT VC, USER_WECO UC, VEHICLE_PARTNER VP, LOCATION LO, CITY CO, COUNTRY CTO, USER_WECO UP\n"
                + "WHERE OS.ID_VEHICLE_CLIENT = VC.ID_VEHICLE_CLIENT\n"
                + "AND VC.ID_USER = UC.ID_USER\n"
                + "AND OS.ID_LOCATION = LO.ID_LOCATION\n"
                + "AND LO.ID_CITY = CO.ID_CITY\n"
                + "AND CO.ID_COUNTRY = CTO.ID_COUNTRY\n"
                + "AND OS.ID_VEHICLE_PARTNER = VP.ID_VEHICLE_PARTNER\n"
                + "AND VP.ID_USER = UP.ID_USER\n"
                + "AND OS.ID_ORDER_SERVICE = '" + idOrderService + "';";
        return Query;
    }

    public String getServicesOfServiceOrderManagmentById(BigDecimal idOrderService) {
        Query = "SELECT BS.ID_PACKAGE, BS.ID_BUY_SERVICE, S.ID_SERVICE, S.NAME, BS.ADITIONAL_COST, BS.ADITIONAL_COST_DESCRIPTION, BS.SERVICE_COST, BS.STATUS\n"
                + "FROM BUY_SERVICE BS, ORDER_SERVICE OS, SERVICE S\n"
                + "WHERE S.ID_SERVICE = BS.ID_SEVICE\n"
                + "AND BS.ID_ORDER_SERVICE = OS.ID_ORDER_SERVICE\n"
                + "AND OS.ID_ORDER_SERVICE = '" + idOrderService + "'\n"
                + "ORDER BY BS.ID_PACKAGE;";
        return Query;
    }

    public String getdetailUserWecoById(UserWeco idUser) {
        Query = "SELECT UW.ID_ROL, UW.NAME, UW.LASTNAME, UW.CALIFICATION, UW.PHONE_NUMBER, UW.ADDRESS, L.NAME, C.NAME, CT.NAME, L.ZIPCODE, KV.NAME, M.NAME, MO.NAME, V.COLOR, V.YEAR\n"
                + "FROM USER_WECO UW, VEHICLE_CLIENT VC, VEHICLE V, KIND_VEHICLE KV, LOCATION L, CITY C, COUNTRY CT, MARK M, MODEL MO\n"
                + "WHERE CT.ID_COUNTRY = C.ID_COUNTRY\n"
                + "AND C.ID_CITY = L.ID_CITY\n"
                + "AND L.ID_LOCATION = UW.ID_LOCATION\n"
                + "AND KV.ID_KIND_VEHICLE = V.ID_KIND_VEHICLE\n"
                + "AND V.ID_VEHICLE = VC.ID_VEHICLE\n"
                + "AND VC.ID_USER = UW.ID_USER\n"
                + "AND UW.ID_USER = '" + idUser + "'\n"
                + "AND M.ID_MARK = MO.ID_MARK\n"
                + "AND MO.ID_MODEL = V.ID_MODEL;";
        return Query;
    }

    public String getOrderProductManagment() {
        Query = "SELECT OP.ID_ORDER_PRODUCT, OP.DATE_ORDER, UW.ID_USER, UW.NAME, UW.LASTNAME, OP.TOTAL, OP.STATUS\n"
                + "FROM ORDER_PRODUCT OP, USER_WECO UW\n"
                + "WHERE UW.ID_USER = OP.ID_USER\n"
                + "ORDER BY OP.ID_ORDER_PRODUCT;";
        return Query;
    }

    public String getSummaryOrderProductManagment(BigDecimal idOrderProduct) {
        Query = "SELECT OP.ID_ORDER_PRODUCT, OP.DATE_ORDER, OP.TOTAL, OP.SUB_TOTAL, OP.DELIVERY_COST, OP.CALIFORNIA_SALES_TAX, OP.STATUS, UW.NAME, UW.LASTNAME,\n"
                + "L.DIRECTION, L.NAME, C.NAME, CT.NAME\n"
                + "FROM ORDER_PRODUCT OP, USER_WECO UW, LOCATION L, CITY C, COUNTRY CT\n"
                + "WHERE UW.ID_USER = OP.ID_USER\n"
                + "AND UW.ID_USER = '" + idOrderProduct + "'\n"
                + "AND CT.ID_COUNTRY = C.ID_COUNTRY\n"
                + "AND C.ID_CITY = L.ID_CITY\n"
                + "AND L.ID_LOCATION = UW.ID_LOCATION;";
        return Query;
    }

    public String getProductsOfServiceOrderManagmentById(BigDecimal idOrderProduct) {
        Query = "SELECT POP.ID_PROD_ORDER_PROD, P.INVENTORY, P.ID_PRODUCT, P.NAME, POP.PRODUCT_COST\n"
                + "FROM PRODUCT_ORDER_PRODUCT POP, ORDER_PRODUCT OP, PRODUCT P\n"
                + "WHERE P.ID_PRODUCT = POP.ID_PRODUCT\n"
                + "AND POP.ID_ORDER_PRODUCT = OP.ID_ORDER_PRODUCT\n"
                + "AND OP.ID_ORDER_PRODUCT = '" + idOrderProduct + "';";
        return Query;
    }

    public String getServicesManagment() {
        Query = "SELECT S.ID_KIND_SERVICE, S.ID_SERVICE, PS.NAME, S.NAME, S.SERVICE_COST\n"
                + "FROM SERVICE S, PACKAGE_SERVICE PS\n"
                + "WHERE S.ID_KIND_SERVICE = PS.ID_KIND_SERVICE\n"
                + "ORDER BY PS.ID_KIND_SERVICE;";
        return Query;
    }

    public String getRangeUserWecoByRol(BigDecimal idRol, BigDecimal from, BigDecimal to) {
        Query = "SELECT *\n"
                + "FROM USER_WECO\n"
                + "WHERE ID_USER BETWEEN '"+from+"' AND '"+to+"'\n"
                + "AND ID_ROL = '"+idRol+"'";
        return Query;
    }
}
