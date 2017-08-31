package com.appcrews.javaee.maicai.model.base;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "detailorder")
public class DetailInfo implements Serializable {
	private int onum, wareid, warenum,id;
	private WareInfo wareInfo;

//	private OrderInfo orderInfo;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
//	@ManyToOne
//	@JoinColumn(name = "onum" , insertable = false, updatable = false)
//	public OrderInfo getOrderInfo() {
//		return orderInfo;
//	}
//
//	public void setOrderInfo(OrderInfo orderInfo) {
//		this.orderInfo = orderInfo;
//	}tserese


	@OneToOne
	@JoinColumn(name="wareid",unique=true , insertable = false, updatable = false)
	public WareInfo getWareInfo() {
		return wareInfo;
	}

	public void setWareInfo(WareInfo wareInfo) {
		this.wareInfo = wareInfo;
	}

	public int getOnum() {
		return onum;
	}

	public void setOnum(int ounm) {
		this.onum=ounm;
	}

	public int getWareid() {
		return wareid;
	}

	public void setWareid(int wareid) {
		this.wareid = wareid;
	}
	public int getWarenum() {
		return warenum;
	}

	public void setWarenum(int warenum) {
		this.warenum = warenum;
	}
}
