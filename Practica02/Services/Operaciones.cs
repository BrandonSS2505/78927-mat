using System;
using WSDL.mensajes;
//va a tener su propio namespace para poder importarla despues
namespace WSDL.operaciones{
    //esta si es una clase
    public class Operaciones : Mensajes{
        private string[] mensajes = new string[2];
 
        public string Saludar(string nombre){
            Boolean estaLleno = true;
            for(int x = 0; x < mensajes.Length; x++){
                if(string.IsNullOrEmpty(mensajes[x])){
                    mensajes[x]=nombre;
                    estaLleno = false;
                    break;
                }
            }

            if (estaLleno == true){
                return "sin cupo";
            }
            return "Hola "+nombre;
        }
        public string Mostrar(int id){
            if(id >= mensajes.Length || id < 0){
                return "No existe";
            } 
            
            if(!string.IsNullOrEmpty(mensajes[id])){
                return "Hola " + mensajes[id];
            }
            return "No se encontro";
        }
    }
}