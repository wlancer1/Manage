package com.appcrews.javaee.maicai.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by micheal on 2017/8/23.
 */
@Entity
@Table(name = "shop")
public class ShopInfo implements Serializable {
    private int uid;
    private int sid;
    private  String name;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

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
}
