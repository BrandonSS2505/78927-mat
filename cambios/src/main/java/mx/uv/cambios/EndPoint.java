package mx.uv.cambios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.escuela.EditarRequest;
import https.t4is_uv_mx.escuela.EditarResponse;

@Endpoint
public class EndPoint{
    @Autowired
    private ICambiar iCambiar;
    
    @PayloadRoot(localPart = "EditarRequest", namespace = "https://t4is.uv.mx/escuela")
    @ResponsePayload
    public EditarResponse EditarEscuela(@RequestPayload EditarRequest peticion){
        EditarResponse a = new EditarResponse();
        Cambiar cambiar = new Cambiar();
        cambiar.setId(peticion.getIndexeditar());
        cambiar.setAlumno(peticion.getAlumnoeditar());
        cambiar.setMaestro(peticion.getMaestroeditar());
        cambiar.setAula(peticion.getAulaeditar());
        iCambiar.save(cambiar);
        a.setAviso("Actualizado");
        return a;
    }

}