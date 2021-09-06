package com.htc.doctorservice.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctor_service")
public class Doctor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1868453097239086985L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long doctorId;
	private String doctorName;
	private String specialization;
	private int experiene;
	private String mobile;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(long doctorId, String doctorName, String specialization, int experiene, String mobile) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.experiene = experiene;
		this.mobile = mobile;
	}

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public int getExperiene() {
		return experiene;
	}

	public void setExperiene(int experiene) {
		this.experiene = experiene;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public int hashCode() {
		return Objects.hash(doctorId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Doctor other = (Doctor) obj;
		return doctorId == other.doctorId;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", specialization=" + specialization
				+ ", experiene=" + experiene + ", mobile=" + mobile + "]";
	}

	
}
