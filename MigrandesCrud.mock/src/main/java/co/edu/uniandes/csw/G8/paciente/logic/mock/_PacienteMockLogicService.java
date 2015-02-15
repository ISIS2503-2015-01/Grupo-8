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

package co.edu.uniandes.csw.G8.paciente.logic.mock;
import java.util.ArrayList;
import java.util.List;

import co.edu.uniandes.csw.G8.paciente.logic.dto.PacienteDTO;
import co.edu.uniandes.csw.G8.paciente.logic.dto.PacientePageDTO;
import co.edu.uniandes.csw.G8.paciente.logic.api._IPacienteLogicService;

public abstract class _PacienteMockLogicService implements _IPacienteLogicService {

	private Long id= new Long(1);
	protected List<PacienteDTO> data=new ArrayList<PacienteDTO>();

	public PacienteDTO createPaciente(PacienteDTO paciente){
		id++;
		paciente.setId(id);
		data.add(paciente);
		return paciente;
    }
    
    public List<PacienteDTO> getPacientes(){
		return data; 
	}

	public PacientePageDTO getPacientes(Integer page, Integer maxRecords){
		PacientePageDTO response = new PacientePageDTO();
		response.setTotalRecords(Long.parseLong(data.size()+""));
		response.setRecords(data);
		return response;
	}

	public PacienteDTO getPaciente(Long id){
		for(PacienteDTO data1:data){
			if(data1.getId().equals(id)){
				return data1;
			}
		}
		return null;
	}

	public void deletePaciente(Long id){
	    PacienteDTO delete=null;
		for(PacienteDTO data1:data){
			if(data1.getId().equals(id)){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
		} 
	}

	public void updatePaciente(PacienteDTO paciente){
	    PacienteDTO delete=null;
		for(PacienteDTO data1:data){
			if(data1.getId().equals(paciente.getId())){
				delete=data1;
			}
		}
		if(delete!=null){
			data.remove(delete);
			data.add(paciente);
		} 
	}	
}