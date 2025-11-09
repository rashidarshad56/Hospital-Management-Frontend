package com.cg.hospital.model;

import java.time.LocalDateTime;

public class AppointmentSummaryDTO {
    private Integer appointmentId;
    private Integer patientId;
    private LocalDateTime starto;
    private LocalDateTime endo;
    private String examinationRoom;

    public Integer getAppointmentId() { return appointmentId; }
    public void setAppointmentId(Integer appointmentId) { this.appointmentId = appointmentId; }

    public Integer getPatientId() { return patientId; }
    public void setPatientId(Integer patientId) { this.patientId = patientId; }

    public LocalDateTime getStarto() { return starto; }
    public void setStarto(LocalDateTime starto) { this.starto = starto; }

    public LocalDateTime getEndo() { return endo; }
    public void setEndo(LocalDateTime endo) { this.endo = endo; }

    public String getExaminationRoom() { return examinationRoom; }
    public void setExaminationRoom(String examinationRoom) { this.examinationRoom = examinationRoom; }
}