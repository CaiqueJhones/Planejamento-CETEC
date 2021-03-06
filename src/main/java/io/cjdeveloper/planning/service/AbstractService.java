/*
 * AbstractService.java
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
 * software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package io.cjdeveloper.planning.service;

import java.sql.SQLException;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.DerbyEmbeddedDatabaseType;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

/**
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
public abstract class AbstractService {
	
	protected static final String DB_URL = "jdbc:derby:planningDb;create=true;user=me;password=admin";
	
	protected DatabaseType databaseType;
	protected ConnectionSource connectionSource;
	
	public AbstractService() throws SQLException {
		databaseType = new DerbyEmbeddedDatabaseType();
		connectionSource = new JdbcPooledConnectionSource(DB_URL, databaseType);
	}

}
