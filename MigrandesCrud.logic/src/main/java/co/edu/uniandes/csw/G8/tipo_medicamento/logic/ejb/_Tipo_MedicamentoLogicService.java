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

package co.edu.uniandes.csw.G8.tipo_medicamento.logic.ejb;
import java.util.List;
import javax.inject.Inject;

import co.edu.uniandes.csw.G8.tipo_medicamento.logic.dto.Tipo_MedicamentoDTO;
import co.edu.uniandes.csw.G8.tipo_medicamento.logic.dto.Tipo_MedicamentoPageDTO;
import co.edu.uniandes.csw.G8.tipo_medicamento.logic.api._ITipo_MedicamentoLogicService;
import co.edu.uniandes.csw.G8.tipo_medicamento.persistence.api.ITipo_MedicamentoPersistence;

public abstract class _Tipo_MedicamentoLogicService implements _ITipo_MedicamentoLogicService {

	@Inject
	protected ITipo_MedicamentoPersistence persistance;

	public Tipo_MedicamentoDTO createTipo_Medicamento(Tipo_MedicamentoDTO tipo_Medicamento){
		return persistance.createTipo_Medicamento( tipo_Medicamento); 
    }

	public List<Tipo_MedicamentoDTO> getTipo_Medicamentos(){
		return persistance.getTipo_Medicamentos(); 
	}

	public Tipo_MedicamentoPageDTO getTipo_Medicamentos(Integer page, Integer maxRecords){
		return persistance.getTipo_Medicamentos(page, maxRecords); 
	}

	public Tipo_MedicamentoDTO getTipo_Medicamento(Long id){
		return persistance.getTipo_Medicamento(id); 
	}

	public void deleteTipo_Medicamento(Long id){
	    persistance.deleteTipo_Medicamento(id); 
	}

	public void updateTipo_Medicamento(Tipo_MedicamentoDTO tipo_Medicamento){
	    persistance.updateTipo_Medicamento(tipo_Medicamento); 
	}	
}