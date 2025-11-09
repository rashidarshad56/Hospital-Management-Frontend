package com.cg.hospital.model;

import java.time.LocalDateTime;

public class StayModel {
	 private int stayId;
	    private PatientModel patient;
	    private int room;
	    private LocalDateTime stayStart;
	    private LocalDateTime stayEnd;
		public int getStayId() {
			return stayId;
		}
		public void setStayId(int stayId) {
			this.stayId = stayId;
		}
		public PatientModel getPatient() {
			return patient;
		}
		public void setPatient(PatientModel patient) {
			this.patient = patient;
		}
		public int getRoom() {
			return room;
		}
		public void setRoom(int room) {
			this.room = room;
		}
		public LocalDateTime getStayStart() {
			return stayStart;
		}
		public void setStayStart(LocalDateTime stayStart) {
			this.stayStart = stayStart;
		}
		public LocalDateTime getStayEnd() {
			return stayEnd;
		}
		public void setStayEnd(LocalDateTime stayEnd) {
			this.stayEnd = stayEnd;
		}
	    

}
