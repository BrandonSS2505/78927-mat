package mx.uv.practica04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;

@Endpoint
public class EndPoint{
    @Autowired
    private ISaludador iSaludador;
    
    @PayloadRoot(localPart = "SaludarRequest", namespace = "https://t4is.uv.mx/saludos")

    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        
        SaludarResponse response = new SaludarResponse();
        response.setRespuesta("Hola "+ peticion.getNombre());

        //persintencia a la bd
        Saludador saludador = new Saludador();
        saludador.setNombre(peticion.getNombre());
        iSaludador.save(saludador);
        

        return response; 
    }
}