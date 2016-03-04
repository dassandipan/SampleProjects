package com.travelport.test.response;

import java.util.Date;

public class Schedule {
	Long scheduleId;
	Date scheduleStartDate;
	Long duration;

	public Long getScheduleId() {
		return scheduleId;
	}

	public void setScheduleId(Long scheduleId) {
		this.scheduleId = scheduleId;
	}

	public Date getScheduleStartDate() {
		return scheduleStartDate;
	}

	public void setScheduleStartDate(Date scheduleStartDate) {
		this.scheduleStartDate = scheduleStartDate;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "{\"scheduleId\":" + "\"" + scheduleId + "\"" + ",\"scheduleStartDate\":" + "\"" + scheduleStartDate
				+ "\"" + "\"duration\":" + "\"" + duration + "\"}";
	}
}