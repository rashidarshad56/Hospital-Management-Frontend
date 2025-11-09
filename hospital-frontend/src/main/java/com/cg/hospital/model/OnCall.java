package com.cg.hospital.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OnCall {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nurseId")
    private Integer nurseId;

    // Keep as String to render exactly what backend sends; format in template if needed
    @JsonProperty("onCallStart")
    private String onCallStart;

    @JsonProperty("onCallEnd")
    private String onCallEnd;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getNurseId() { return nurseId; }
    public void setNurseId(Integer nurseId) { this.nurseId = nurseId; }

    public String getOnCallStart() { return onCallStart; }
    public void setOnCallStart(String onCallStart) { this.onCallStart = onCallStart; }

    public String getOnCallEnd() { return onCallEnd; }
    public void setOnCallEnd(String onCallEnd) { this.onCallEnd = onCallEnd; }
}
