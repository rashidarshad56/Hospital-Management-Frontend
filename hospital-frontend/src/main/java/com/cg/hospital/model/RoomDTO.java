package com.cg.hospital.model;
public class RoomDTO {

    private Integer roomNumber;
    private String roomType;
    private Boolean unavailable;

    public RoomDTO() {}

    public RoomDTO(Integer roomNumber, String roomType, Boolean unavailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.unavailable = unavailable;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public Boolean getUnavailable() {
        return unavailable;
    }

    public void setUnavailable(Boolean unavailable) {
        this.unavailable = unavailable;
    }
}

