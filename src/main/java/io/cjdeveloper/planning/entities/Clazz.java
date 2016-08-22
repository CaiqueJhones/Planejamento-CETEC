/*
 * Clazz.java
 *
 * Copyright 2016 Caique Jhones
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.cjdeveloper.planning.entities;

import java.time.DayOfWeek;
import java.time.LocalTime;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import io.cjdeveloper.planning.convert.LocalTimeDataType;

/**
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
@DatabaseTable
public class Clazz {

	@DatabaseField(generatedId = true)
	private Long id;

	@DatabaseField(dataType = DataType.ENUM_STRING)
	private DayOfWeek dayOfWeek;

	@DatabaseField(canBeNull = false, persisterClass = LocalTimeDataType.class)
	private LocalTime startTime;

	@DatabaseField(canBeNull = false, persisterClass = LocalTimeDataType.class)
	private LocalTime endTime;

	@DatabaseField(dataType = DataType.ENUM_STRING)
	private ClazzType clazzType;

	@DatabaseField
	private String room;

	@DatabaseField
	private String pavilion;

	@DatabaseField
	private int demand;

	@DatabaseField(canBeNull = false, foreign = true)
	private Discipline discipline;

	Clazz() {
	}

	public Clazz(Long id, DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime, ClazzType clazzType, String room,
			String pavilion, int demand, Discipline discipline) {
		this.id = id;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.clazzType = clazzType;
		this.room = room;
		this.pavilion = pavilion;
		this.demand = demand;
		this.discipline = discipline;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getPavilion() {
		return pavilion;
	}

	public void setPavilion(String pavilion) {
		this.pavilion = pavilion;
	}

	public int getDemand() {
		return demand;
	}

	public void setDemand(int demand) {
		this.demand = demand;
	}

	public Discipline getDiscipline() {
		return discipline;
	}

	public void setDiscipline(Discipline discipline) {
		this.discipline = discipline;
	}

	public ClazzType getClazzType() {
		return clazzType;
	}

	public void setClazzType(ClazzType clazzType) {
		this.clazzType = clazzType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazzType == null) ? 0 : clazzType.hashCode());
		result = prime * result + ((dayOfWeek == null) ? 0 : dayOfWeek.hashCode());
		result = prime * result + demand;
		result = prime * result + ((discipline == null) ? 0 : discipline.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pavilion == null) ? 0 : pavilion.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Clazz)) return false;
		Clazz other = (Clazz) obj;
		if (clazzType != other.clazzType) return false;
		if (dayOfWeek != other.dayOfWeek) return false;
		if (demand != other.demand) return false;
		if (discipline == null) {
			if (other.discipline != null) return false;
		} else if (!discipline.equals(other.discipline)) return false;
		if (endTime == null) {
			if (other.endTime != null) return false;
		} else if (!endTime.equals(other.endTime)) return false;
		if (id == null) {
			if (other.id != null) return false;
		} else if (!id.equals(other.id)) return false;
		if (pavilion == null) {
			if (other.pavilion != null) return false;
		} else if (!pavilion.equals(other.pavilion)) return false;
		if (room == null) {
			if (other.room != null) return false;
		} else if (!room.equals(other.room)) return false;
		if (startTime == null) {
			if (other.startTime != null) return false;
		} else if (!startTime.equals(other.startTime)) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clazz [id=" + id + ", dayOfWeek=" + dayOfWeek + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", clazzType=" + clazzType + ", room=" + room + ", pavilion=" + pavilion + ", demand=" + demand
				+ ", discipline=" + discipline + "]";
	}

}
