package com.appcrews.javaee.maicai.model;

import javax.persistence.*;
import javax.persistence.Transient;
import java.beans.*;
import java.io.File;
import java.io.Serializable;

@Entity
@Table(name = "ware")
public class WareInfo implements Serializable {
	// 上传文件的类型：text/plain
	private String uploadImageContentType;

	// 上传文件的真是名称
	private String uploadImageFileName;
	private int id;
	private File uploadImage;
	private String name = "", type;
	private float price;
	private String img = "", remark;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fid",updatable = false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	@Column(name = "fType")
	public String getType() {
		return type;
	}

	public void setType(String type) {
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
