/*
 * LocalTimeDataType.java
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
package io.cjdeveloper.planning.convert;

import java.sql.SQLException;
import java.time.LocalTime;

import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.field.types.DateTimeType;

/**
 * A custom persister that is able to store the java.time {@link LocalDate} class in the database as epoch-millis long
 * integer. This overrides the {@link DateTimeType} which uses reflection instead. This should run faster.
 * 
 * This can be specified using {@link DatabaseField#persisterClass()} or registered with
 * {@link DataPersisterManager#registerDataPersisters(io.cjdeveloper.planning.convert.LocalTimeDataType...)}.
 * 
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
public class LocalTimeDataType extends DateTimeType {

	private static final LocalTimeDataType singleton = new LocalTimeDataType();

	private LocalTimeDataType() {
		super(SqlType.LONG, new Class<?>[] { LocalTime.class });
	}

	public static LocalTimeDataType getSingleton() {
		return singleton;
	}

	@Override
	public Object javaToSqlArg(FieldType fieldType, Object javaObject) throws SQLException {
		LocalTime localTime = (LocalTime) javaObject;
		if(localTime == null) return null;
		return localTime.toNanoOfDay();
	}

	@Override
	public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) throws SQLException {
		Long nano = (Long) sqlArg;
		return LocalTime.ofNanoOfDay(nano);
	}

}
