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

    public History(int point, String code, String createDate, String title, int balance, String icon) {
        this.point = point;
        this.code = code;
        this.createDate = createDate;
        this.title = title;
        this.balance = balance;
        this.icon = icon;
    }

    /*public History(int historyID, int customerID, int point,
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
    }*/

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
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



