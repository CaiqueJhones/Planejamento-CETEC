/*
 * Discipline.java
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

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Representa as disciplinas.
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
@DatabaseTable
public class Discipline {

	@DatabaseField(id = true)
	private String code;

	@DatabaseField(canBeNull = false)
	private String name;

	@DatabaseField(canBeNull = false)
	private String course;

	@DatabaseField(canBeNull = false)
	private int period;

	@DatabaseField(canBeNull = false)
	private String knowledgeArea;

	@DatabaseField(canBeNull = false)
	private int workload;

	@DatabaseField(canBeNull = false, dataType = DataType.ENUM_STRING)
	private Center center;

	@DatabaseField(canBeNull = false, dataType = DataType.ENUM_STRING)
	private Nature nature;

	Discipline() {
	}

	public Discipline(String code, String name, String course, int period, String knowledgeArea, int workload,
			Center center, Nature nature) {
		this.code = code;
		this.name = name;
		this.course = course;
		this.period = period;
		this.knowledgeArea = knowledgeArea;
		this.workload = workload;
		this.center = center;
		this.nature = nature;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getKnowledgeArea() {
		return knowledgeArea;
	}

	public void setKnowledgeArea(String knowledgeArea) {
		this.knowledgeArea = knowledgeArea;
	}

	public int getWorkload() {
		return workload;
	}

	public void setWorkload(int workload) {
		this.workload = workload;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public Nature getNature() {
		return nature;
	}

	public void setNature(Nature nature) {
		this.nature = nature;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((knowledgeArea == null) ? 0 : knowledgeArea.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nature == null) ? 0 : nature.hashCode());
		result = prime * result + period;
		result = prime * result + workload;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Discipline)) return false;
		Discipline other = (Discipline) obj;
		if (center != other.center) return false;
		if (code == null) {
			if (other.code != null) return false;
		} else if (!code.equals(other.code)) return false;
		if (course == null) {
			if (other.course != null) return false;
		} else if (!course.equals(other.course)) return false;
		if (knowledgeArea == null) {
			if (other.knowledgeArea != null) return false;
		} else if (!knowledgeArea.equals(other.knowledgeArea)) return false;
		if (name == null) {
			if (other.name != null) return false;
		} else if (!name.equals(other.name)) return false;
		if (nature != other.nature) return false;
		if (period != other.period) return false;
		if (workload != other.workload) return false;
		return true;
	}

	@Override
	public String toString() {
		return "Discipline [code=" + code + ", name=" + name + ", course=" + course + ", period=" + period
				+ ", knowledgeArea=" + knowledgeArea + ", workload=" + workload + ", center=" + center + ", nature="
				+ nature + "]";
	}

}
