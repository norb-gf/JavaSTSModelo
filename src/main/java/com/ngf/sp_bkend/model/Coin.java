package com.ngf.sp_bkend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tb_coins")
public class Coin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "family")
	private String family;

	@Column(name = "imgFile")
	private String imgFile;

	@Column(name = "stampYear")
	private String stampYear;

	@Column(name = "faceValue")
	private float faceValue;

	@Column(name = "sigla")
	private String sigla;

	
	public Coin() {
		super();
	}

	public Coin(String family, String stampYear, String imgFile, float faceValue, String sigla) {
		super();
		this.family = family;
		this.stampYear = stampYear;
		this.imgFile = imgFile;
		this.faceValue = faceValue;
		this.sigla = sigla;
	}

	public Coin(long id, String family, String stampYear, String imgFile, float faceValue, String sigla) {
		super();
		this.id = id;
		this.family = family;
		this.stampYear = stampYear;
		this.imgFile = imgFile;
		this.faceValue = faceValue;
		this.sigla = sigla;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public float getFaceValue() {
		return faceValue;
	}

	public void setFaceValue(float faceValue) {
		this.faceValue = faceValue;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	public String getStampYear() {
		return stampYear;
	}

	public void setStampYear(String stampYear) {
		this.stampYear = stampYear;
	}

	public String getImgFile() {
		return imgFile;
	}

	public void setImgFile(String imgFile) {
		this.imgFile = imgFile;
	}
}
