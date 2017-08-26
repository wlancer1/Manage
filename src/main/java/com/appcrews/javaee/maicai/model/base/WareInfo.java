package com.appcrews.javaee.maicai.model.base;

import javax.persistence.*;
import javax.persistence.Transient;
import java.io.File;
import java.io.Serializable;

@Entity
@Table(name = "ware")
public class WareInfo implements Serializable {
	// 上传文件的类型：text/plain
	private String uploadImageContentType;

	// 上传文件的真是名称
	private String uploadImageFileName;
	private int fid;
	private File uploadImage;
	private String name = "";
	private int type;
	private float price;
	private String img = "", remark;
	private  TypeInfo typeInfo;

	public void setTypeInfo(TypeInfo typeInfo) {
		this.typeInfo = typeInfo;
	}
	@OneToOne
	@JoinColumn(name="ftype",unique=true)
	public TypeInfo getTypeInfo() {
		return typeInfo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
	}


@Transient
	public File getUploadImage() {
		return uploadImage;
	}

	public void setUploadImage(File uploadImage) {
		this.uploadImage = uploadImage;
	}
@Transient
	public String getUploadImageContentType() {
		return uploadImageContentType;
	}

	public void setUploadImageContentType(String uploadImageContentType) {
		this.uploadImageContentType = uploadImageContentType;
	}
	@Transient
	public String getUploadImageFileName() {
		return uploadImageFileName;
	}

	public void setUploadImageFileName(String uploadImageFileName) {
		this.uploadImageFileName = uploadImageFileName;
	}

	@Column(name = "fName")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Transient
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	@Column(name = "fPrice")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	@Column(name = "fImg")
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	@Column(name = "fRemark")
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
