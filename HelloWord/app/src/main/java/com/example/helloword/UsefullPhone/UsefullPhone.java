package com.example.helloword.UsefullPhone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UsefullPhone {

    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("phone")
    @Expose
    public String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}