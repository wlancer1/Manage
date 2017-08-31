package com.appcrews.javaee.maicai.model.base;

import javax.persistence.*;

@Entity
@Table(name = "type")
public class TypeInfo {
	private  int typeid;
	private String type;
	private String remark;


	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
@Column(name = "tremark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setTypeid(int typeid) {
		this.typeid = typeid;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getTypeid() {
		return typeid;
	}
}
