package com.cg.hospital.model;



import java.time.LocalDateTime;

public class AppointmentPatientDTO {
		private String physicianName;
	    private int appointmentId;
	    private String patientName;
	    private String address;
	    private String phone;
	    private LocalDateTime starto;
	    private LocalDateTime endo;
	    private String examinationRoom;
	    
		public AppointmentPatientDTO(String physicianName, int appointmentId, String patientName, String address, String phone, LocalDateTime starto,LocalDateTime endo,String examinationRoom) {
			super();
			this.physicianName = physicianName;
			this.appointmentId = appointmentId;
			this.patientName = patientName;
			this.address = address;
			this.phone = phone;
			this.starto = starto;
			this.endo = endo;
			this.examinationRoom = examinationRoom;
	}
	    
	    public String getPhysicianName() {
			return physicianName;
		}
		public void setPhysicianName(String physicianName) {
			this.physicianName = physicianName;
		}
		public String getExaminationRoom() {
			return examinationRoom;
		}
		public void setExaminationRoom(String examinationRoom) {
			this.examinationRoom = examinationRoom;
		}
		public LocalDateTime getStarto() {
			return starto;
		}
		public void setStarto(LocalDateTime starto) {
			this.starto = starto;
		}
		public LocalDateTime getEndo() {
			return endo;
		}
		public void setEndo(LocalDateTime endo) {
			this.endo = endo;
		}
		public int getAppointmentId() {
			return appointmentId;
		}
		public void setAppointmentId(int appointmentId) {
			this.appointmentId = appointmentId;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
	
}
