/*
 * DisciplineServiceLite.java
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
import java.util.List;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.Dao.CreateOrUpdateStatus;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import io.cjdeveloper.planning.entities.Discipline;

/**
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
public class DisciplineServiceLite implements DisciplineService {
	
	private Dao<Discipline, String> disciplineDao;
	
	public DisciplineServiceLite(ConnectionSource connectionSource) throws SQLException {
		TableUtils.createTableIfNotExists(connectionSource, Discipline.class);
		disciplineDao = DaoManager.createDao(connectionSource, Discipline.class);
	}

	@Override
	public int save(Discipline discipline) throws SQLException {
		CreateOrUpdateStatus createOrUpdate = disciplineDao.createOrUpdate(discipline);
		return createOrUpdate.getNumLinesChanged();
	}

	@Override
	public Discipline selectByCode(String code) throws SQLException {
		Discipline discipline = disciplineDao.queryForId(code);
		return discipline;
	}

	@Override
	public int update(Discipline discipline) throws SQLException {
		int updated = disciplineDao.update(discipline);
		return updated;
	}

	@Override
	public int deleteByCode(String code) throws SQLException {
		int updated = disciplineDao.deleteById(code);
		return updated;
	}

	@Override
	public long count() throws SQLException {
		long countOf = disciplineDao.countOf();
		return countOf;
	}

	@Override
	public List<Discipline> selectByPeriod(int period) throws SQLException {
		Where<Discipline, String> where = disciplineDao.queryBuilder()
			.where()
			.eq("period", period);
		List<Discipline> list = disciplineDao.query(where.prepare());
		return list;
	}

}
