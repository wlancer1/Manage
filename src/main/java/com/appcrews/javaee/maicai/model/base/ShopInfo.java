package com.appcrews.javaee.maicai.model.base;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by micheal on 2017/8/23.
 */
@Entity
@Table(name = "shop")
public class ShopInfo implements Serializable {
    private int uid;
    private int sid;
    private  String name;
    private Timestamp time;
    private String description;
    private  int status;
    private UserInfo userInfo;
@Transient
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getTime() {
        return time;
    }

    @OneToOne
    @JoinColumn(name="uid",unique=true)
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
