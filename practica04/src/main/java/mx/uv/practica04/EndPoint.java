package mx.uv.practica04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BuscarRequest;
import https.t4is_uv_mx.saludos.BuscarResponse;
import https.t4is_uv_mx.saludos.EditarRequest;
import https.t4is_uv_mx.saludos.EditarResponse;
import https.t4is_uv_mx.saludos.EliminarRequest;
import https.t4is_uv_mx.saludos.EliminarResponse;
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
    @PayloadRoot(localPart = "BuscarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public BuscarResponse BuscarSaludo(@RequestPayload BuscarRequest peticion){
        BuscarResponse s = new BuscarResponse();
        Saludador saludador = iSaludador.findById(peticion.getSaludobuscar()).get();
        s.setSaludobuscado(saludador.getNombre());
        return s;
    }

    @PayloadRoot(localPart = "EditarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EditarResponse EditarSaludo(@RequestPayload EditarRequest peticion){
        EditarResponse a = new EditarResponse();
        Saludador saludador = new Saludador();
        saludador.setId(peticion.getIndexeditar());
        saludador.setNombre(peticion.getSaludoeditar());
        iSaludador.save(saludador);
        a.setAviso("Saludo actualizado");
        return a;
    }

    @PayloadRoot(localPart = "EliminarRequest", namespace = "https://t4is.uv.mx/saludos")
    @ResponsePayload
    public EliminarResponse EliminarSaludo(@RequestPayload EliminarRequest peticion){
        EliminarResponse c = new EliminarResponse();
        iSaludador.deleteById(peticion.getIndex());
        c.setAviso("Se ha eliminado el elemento");
        return c;
    }

}