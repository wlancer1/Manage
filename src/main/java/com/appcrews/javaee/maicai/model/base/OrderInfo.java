package com.appcrews.javaee.maicai.model.base;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "order1")
public class OrderInfo implements Serializable {



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getOnum() {
		return onum;
	}

	public void setOnum(int onum) {
		this.onum = onum;
	}

	public String getOremark() {
		return oremark;
	}

	public void setOremark(String oremark) {
		this.oremark = oremark;
	}

	public Timestamp getOtime() {
		return otime;
	}

	public void setOtime(Timestamp otime) {
		this.otime = otime;
	}

	public Timestamp getStime() {
		return stime;
	}

	public void setStime(Timestamp stime) {
		this.stime = stime;
	}

	@OneToMany
	@JoinColumn(name = "onum" )
	public Set<DetailInfo> getDetailInfo() {
		return detailInfo;
	}

	public void setDetailInfo(Set<DetailInfo> detailInfo) {
		this.detailInfo = detailInfo;
	}

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

	private  int uid, sid,onum;
	private Set<DetailInfo> detailInfo;
	private String oremark;
	private Timestamp otime, stime;
}
