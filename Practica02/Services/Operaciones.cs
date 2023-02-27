using System;
using WSDL.mensajes;
//va a tener su propio namespace para poder luego importarla
namespace WSDL.operaciones 
{
    //esta si es una clase
    public class Operaciones : Mensajes
    {
        public string Saludar(string nombre)
        {
            string msj = "hola " +nombre;
            return msj;
        }
        public string Mostrar(int id)
        {
            return "x";
        }
    }
}