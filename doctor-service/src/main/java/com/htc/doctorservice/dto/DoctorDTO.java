package com.htc.doctorservice.dto;

//To call doctor entity without doctorId
public class DoctorDTO {

	private String doctorName;
	private String specialization;
	private int experiene;
	private String mobile;
	
	public DoctorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoctorDTO(String doctorName, String specialization, int experiene, String mobile) {
		super();
		this.doctorName = doctorName;
		this.specialization = specialization;
		this.experiene = experiene;
		this.mobile = mobile;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "DoctorDTO [doctorName=" + doctorName + ", specialization=" + specialization + ", experiene=" + experiene
				+ ", mobile=" + mobile + "]";
	}
}
