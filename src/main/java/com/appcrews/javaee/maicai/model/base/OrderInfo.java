package com.appcrews.javaee.maicai.model.base;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "order1")
public class OrderInfo implements Serializable {



	@Id
	public String getOnum() {
		return onum;
	}

	public void setOnum(String onum) {
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
	@Cascade(value={org.hibernate.annotations.CascadeType.ALL})
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

	private  int uid, sid;
	private String onum;
	private Set<DetailInfo> detailInfo=new HashSet<DetailInfo>();
	private String oremark;
	private Timestamp otime, stime;
}
