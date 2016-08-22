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
 * Serviço de banco de dados para a entidade {@link Discipline}.
 * @author Caique Jhones
 * @version 1
 * @sinse 0.1.0
 */
public interface DisciplineService {

	/**
	 * Este método salva uma disciplina na tabela do banco. Caso a disciplina passada
	 * por parâmetro já exista, a tabela é atualizada com os novos valores, senão,
	 * será inserido uma nova disciplina.
	 * @param discipline
	 *        a disciplina a ser salva.
	 * @return O número de colunas afetadas. (Padrão 1)
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	int save(Discipline discipline) throws SQLException;

	/**
	 * Seliciona na tabela pelo códio da disciplina.
	 * @param code
	 *        o código que será pesquisado.
	 * @return Uma {@link Discipline} caso seja encontrado, ou <code>null</code>
	 *         caso não seja nada encontrado.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	Discipline selectByCode(String code) throws SQLException;

	/**
	 * Atualiza a disciplina. Uma alternativa ao método
	 * {@linkplain DisciplineService#save(Discipline)}.
	 * @param discipline
	 *        A disciplina a ser atualizada.
	 * @return O número de colunas afetadas. (Padrão 1)
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	int update(Discipline discipline) throws SQLException;

	/**
	 * Remove da tabela de acordo com o código passado por parâmetro.
	 * @param code
	 *        O código da disciplina a ser deletada.
	 * @return O número de linhas afetadas.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	int deleteByCode(String code) throws SQLException;

	/**
	 * Retorna o número de linhas da tabela.
	 * @return O número de linhas da tabela.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	long count() throws SQLException;

	/**
	 * Devolve uma lista de disciplinas selecionadas pelo período.
	 * @param period
	 *        o período a ser pesquisado.
	 * @return uma lista de disciplinas selecionadas pelo período.
	 * @throws SQLException
	 *         Caso haja algum error de SQL.
	 */
	List<Discipline> selectByPeriod(int period) throws SQLException;

}