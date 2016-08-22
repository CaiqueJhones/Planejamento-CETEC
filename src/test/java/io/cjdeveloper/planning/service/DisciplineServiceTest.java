/*
 * DisciplineServiceTest.java
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
package io.cjdeveloper.planning.service;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;

import io.cjdeveloper.planning.entities.Center;
import io.cjdeveloper.planning.entities.Discipline;
import io.cjdeveloper.planning.entities.Nature;

/**
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
public class DisciplineServiceTest {

	// usaremos o in-memory H2 database
	private final static String DATABASE_URL = "jdbc:h2:mem:discipline";

	private DisciplineService service;

	private ConnectionSource connectionSource;

	@Before
	public void setUp() throws Exception {
		connectionSource = null;

		connectionSource = new JdbcConnectionSource(DATABASE_URL);
		service = new DisciplineServiceLite(connectionSource);
	}
	
	@After
	public void finish() throws Exception {
		if (connectionSource != null) {
			connectionSource.close();
		}
	}
	
	@Test
	public void testa() throws Exception {
		inserindoNaTabela();
		atualizandoTabela();
		criandoDepoisDeletando();
		selecionePorPeriodo();
	}

	private void inserindoNaTabela() throws Exception {
		Discipline discipline = getDiscipline("CET100");
		service.save(discipline);
		verificaNobanco(discipline.getCode(), discipline);
	}
	
	private void atualizandoTabela() throws Exception {
		Discipline discipline = getDiscipline("CET100");
		discipline.setName("Calculo I");
		int rowsUpdated = service.update(discipline);
		assertEquals(1, rowsUpdated);
		verificaNobanco(discipline.getCode(), discipline);
	}
	
	private void criandoDepoisDeletando() throws Exception {
		Discipline discipline = getDiscipline("CET111");
		service.save(discipline);
		int rowsUpdated = service.deleteByCode("CET100");
		assertEquals(1, rowsUpdated);
		long count = service.count();
		assertEquals(1, count);
	}
	
	private void selecionePorPeriodo() throws Exception {
		int period = 1;
		List<Discipline> disciplines = service.selectByPeriod(period);
		assertThat(disciplines.size(), is(1));
	}
	
	private Discipline getDiscipline(String code) {
		String name = "Uma Disciplina";
		String course = "BCET";
		int period = 1;
		String knowledgeArea = "Matematica";
		int workload = 68;
		Center center = Center.CETEC;
		Nature nature = Nature.REQUIRED;
		Discipline discipline = new Discipline(code, name, course, period, knowledgeArea, workload, center, nature);
		return discipline;
	}

	private void verificaNobanco(String code, Discipline discipline) throws Exception {
		Discipline other = service.selectByCode(code);
		assertEquals(discipline, other);
	}

}
