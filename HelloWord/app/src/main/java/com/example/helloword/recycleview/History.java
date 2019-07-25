package com.example.helloword.recycleview;

import java.util.Date;

public class History {

    int historyID;
    int customerID;
    int point;
    String addpointCode;
    String code;
    String createDate;
    String createDateStr;
    int typeAdd;
    int type;
    String title;
    int balance;
    String icon;

    public History(int historyID, int customerID, int point,
                   String addpointCode, String code, String createDate, String createDateStr,
                   int typeAdd, int type, String title, int balance, String icon) {
        this.historyID = historyID;
        this.customerID = customerID;
        this.point = point;
        this.addpointCode = addpointCode;
        this.code = code;
        this.createDate = createDate;
        this.createDateStr = createDateStr;
        this.typeAdd = typeAdd;
        this.type = type;
        this.title = title;
        this.balance = balance;
        this.icon = icon;
    }

    public int getHistoryID() {
        return historyID;
    }

    public void setHistoryID(int historyID) {
        this.historyID = historyID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public String getAddpointCode() {
        return addpointCode;
    }

    public void setAddpointCode(String addpointCode) {
        this.addpointCode = addpointCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDateStr() {
        return createDateStr;
    }

    public void setCreateDateStr(String createDateStr) {
        this.createDateStr = createDateStr;
    }

    public int getTypeAdd() {
        return typeAdd;
    }

    public void setTypeAdd(int typeAdd) {
        this.typeAdd = typeAdd;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }


}



