/* ========================================================================
 * Copyright 2014 G8
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 G8

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201411201032

*/

package co.edu.uniandes.csw.G8.medicamento.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.G8.medicamento.logic.dto.MedicamentoDTO;
import co.edu.uniandes.csw.G8.medicamento.logic.dto.MedicamentoPageDTO;
import co.edu.uniandes.csw.G8.medicamento.persistence.api._IMedicamentoPersistence;
import co.edu.uniandes.csw.G8.medicamento.persistence.converter.MedicamentoConverter;
import co.edu.uniandes.csw.G8.medicamento.persistence.entity.MedicamentoEntity;

public abstract class _MedicamentoPersistence implements _IMedicamentoPersistence {

  	@PersistenceContext(unitName="MigrandesCrudPU")
 
	protected EntityManager entityManager;
	
	public MedicamentoDTO createMedicamento(MedicamentoDTO medicamento) {
		MedicamentoEntity entity=MedicamentoConverter.persistenceDTO2Entity(medicamento);
		entityManager.persist(entity);
		return MedicamentoConverter.entity2PersistenceDTO(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<MedicamentoDTO> getMedicamentos() {
		Query q = entityManager.createQuery("select u from MedicamentoEntity u");
		return MedicamentoConverter.entity2PersistenceDTOList(q.getResultList());
	}

	@SuppressWarnings("unchecked")
	public MedicamentoPageDTO getMedicamentos(Integer page, Integer maxRecords) {
		Query count = entityManager.createQuery("select count(u) from MedicamentoEntity u");
		Long regCount = 0L;
		regCount = Long.parseLong(count.getSingleResult().toString());
		Query q = entityManager.createQuery("select u from MedicamentoEntity u");
		if (page != null && maxRecords != null) {
		    q.setFirstResult((page-1)*maxRecords);
		    q.setMaxResults(maxRecords);
		}
		MedicamentoPageDTO response = new MedicamentoPageDTO();
		response.setTotalRecords(regCount);
		response.setRecords(MedicamentoConverter.entity2PersistenceDTOList(q.getResultList()));
		return response;
	}

	public MedicamentoDTO getMedicamento(Long id) {
		return MedicamentoConverter.entity2PersistenceDTO(entityManager.find(MedicamentoEntity.class, id));
	}

	public void deleteMedicamento(Long id) {
		MedicamentoEntity entity=entityManager.find(MedicamentoEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateMedicamento(MedicamentoDTO detail) {
		MedicamentoEntity entity=entityManager.merge(MedicamentoConverter.persistenceDTO2Entity(detail));
		MedicamentoConverter.entity2PersistenceDTO(entity);
	}

}