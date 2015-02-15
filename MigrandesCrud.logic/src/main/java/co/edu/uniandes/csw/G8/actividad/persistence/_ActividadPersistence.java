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

package co.edu.uniandes.csw.G8.actividad.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.G8.actividad.logic.dto.ActividadDTO;
import co.edu.uniandes.csw.G8.actividad.logic.dto.ActividadPageDTO;
import co.edu.uniandes.csw.G8.actividad.persistence.api._IActividadPersistence;
import co.edu.uniandes.csw.G8.actividad.persistence.converter.ActividadConverter;
import co.edu.uniandes.csw.G8.actividad.persistence.entity.ActividadEntity;

public abstract class _ActividadPersistence implements _IActividadPersistence {

  	@PersistenceContext(unitName="MigrandesCrudPU")
 
	protected EntityManager entityManager;
	
	public ActividadDTO createActividad(ActividadDTO actividad) {
		ActividadEntity entity=ActividadConverter.persistenceDTO2Entity(actividad);
		entityManager.persist(entity);
		return ActividadConverter.entity2PersistenceDTO(entity);
	}
	
	@SuppressWarnings("unchecked")
	public List<ActividadDTO> getActividads() {
		Query q = entityManager.createQuery("select u from ActividadEntity u");
		return ActividadConverter.entity2PersistenceDTOList(q.getResultList());
	}

	@SuppressWarnings("unchecked")
	public ActividadPageDTO getActividads(Integer page, Integer maxRecords) {
		Query count = entityManager.createQuery("select count(u) from ActividadEntity u");
		Long regCount = 0L;
		regCount = Long.parseLong(count.getSingleResult().toString());
		Query q = entityManager.createQuery("select u from ActividadEntity u");
		if (page != null && maxRecords != null) {
		    q.setFirstResult((page-1)*maxRecords);
		    q.setMaxResults(maxRecords);
		}
		ActividadPageDTO response = new ActividadPageDTO();
		response.setTotalRecords(regCount);
		response.setRecords(ActividadConverter.entity2PersistenceDTOList(q.getResultList()));
		return response;
	}

	public ActividadDTO getActividad(Long id) {
		return ActividadConverter.entity2PersistenceDTO(entityManager.find(ActividadEntity.class, id));
	}

	public void deleteActividad(Long id) {
		ActividadEntity entity=entityManager.find(ActividadEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateActividad(ActividadDTO detail) {
		ActividadEntity entity=entityManager.merge(ActividadConverter.persistenceDTO2Entity(detail));
		ActividadConverter.entity2PersistenceDTO(entity);
	}

}