/*
 * DisciplineService.java
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

import io.cjdeveloper.planning.entities.Discipline;

/**
 * Servi�o de banco de dados para a entidade {@link Discipline}.
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
public interface DisciplineService {

	/**
	 * Este m�todo salva uma disciplina na tabela do banco. Caso a disciplina passada
	 * por par�metro j� exista, a tabela � atualizada com os novos valores, sen�o,
	 * ser� inserido uma nova disciplina.
	 * @param discipline
	 *        a disciplina a ser salva.
	 * @return O n�mero de colunas afetadas. (Padr�o 1)
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	int save(Discipline discipline) throws SQLException;

	/**
	 * Seliciona na tabela pelo c�dio da disciplina.
	 * @param code
	 *        o c�digo que ser� pesquisado.
	 * @return Uma {@link Discipline} caso seja encontrado, ou <code>null</code>
	 *         caso n�o seja nada encontrado.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	Discipline selectByCode(String code) throws SQLException;

	/**
	 * Atualiza a disciplina. Uma alternativa ao m�todo
	 * {@linkplain DisciplineService#save(Discipline)}.
	 * @param discipline
	 *        A disciplina a ser atualizada.
	 * @return O n�mero de colunas afetadas. (Padr�o 1)
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	int update(Discipline discipline) throws SQLException;

	/**
	 * Remove da tabela de acordo com o c�digo passado por par�metro.
	 * @param code
	 *        O c�digo da disciplina a ser deletada.
	 * @return O n�mero de linhas afetadas.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	int deleteByCode(String code) throws SQLException;

	/**
	 * Retorna o n�mero de linhas da tabela.
	 * @return O n�mero de linhas da tabela.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	long count() throws SQLException;

	/**
	 * Devolve uma lista de disciplinas selecionadas pelo per�odo.
	 * @param period
	 *        o per�odo a ser pesquisado.
	 * @return uma lista de disciplinas selecionadas pelo per�odo.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	List<Discipline> selectByPeriod(int period) throws SQLException;

}