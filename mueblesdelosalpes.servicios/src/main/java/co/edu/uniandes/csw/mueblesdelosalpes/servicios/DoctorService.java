/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.uniandes.csw.mueblesdelosalpes.servicios;

import co.edu.uniandes.csw.mueblesdelosalpes.dto.Episodio;
import co.edu.uniandes.csw.mueblesdelosalpes.logica.interfaces.IServicioCarritoMockRemote;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
@Path("/doctor")
@Stateless
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DoctorService {
 
    /**
     * Referencia al Ejb de carritos encargada de realizar las operaciones del mismo.
     */
    @EJB
    private IServicioCarritoMockRemote doctorEJB;
    /**
     * Servicio que recibe un objeto JSON con un mueble que se desea agregar al carrito de compras. Este servicio es el que se va a probar en 
     * JMeter. Ejecución sin problemas hasta los 5000 usuarios en 10 segundos.)
     *
     * @param mb Mueble en formato JSON, que automáticamente se parsea a un objeto Mueble por el API REST.
     */
//    @POST
//    @Path("agregar/")
// 
//    public List<Mueble> agregarMuebles(List<Mueble> mb) {
//        for (Mueble mueble : mb) {
//            carroEjb.agregarItem(mueble);
//        }
//        
//        return mb;
//    }
    
//    @DELETE
//    @Path("borrar/")
//    public void eliminarMuebles(List<Mueble> mb) {
//        for (Mueble mueble : mb) {
//            carroEjb.removerItem(mueble, true);
//        }
//    }
// 
//    /**
//     * Servicio que ofrece una lista JSON con los elementos que estan actualmente en el carrito.
//     * @return la lista JSON con los muebles actuales del carrito.
//  
//     */
//    @GET
//    @Path("muebles/")
//    public List<Mueble> getTodosLosMuebles() {
//        return carroEjb.getInventario();
// 
//    }
    
    @GET
    @Path("doloresPaciente/{id}")
    public List<Episodio> getEpisodios(@PathParam("id") Long id)
    {
        doctorEJB.revisarDolores(id);
    }
    
    @GET
    @Path("doloresPacienteTiempo/{id}/{fecha1}/{fecha2}")
    public List<Episodio> getEpisodiosTiempo(@PathParam("id") Long id,@PathParam("fecha1")Date fecha1,@PathParam("fecha2")Date fecha2)
    {
        doctorEJB.revisarDoloresTiempo(id,fecha1,fecha2);
    }
    
    @GET
    @Path("revisarEpisodio/{idEpisodio}")
    public Episodio getEpisodio(@PathParam("idEpisodio") Long id)
    {
        doctorEJB.revisarDoloresTiempo(id);
    }    
 
}
