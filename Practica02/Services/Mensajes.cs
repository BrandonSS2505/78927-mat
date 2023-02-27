using System;
using System.ServiceModel;

namespace WSDL.mensajes{
    [ServiceContract]
    //no es una clase, es un contrato o una interfaz
    public interface Mensajes{
        [OperationContract]
        string Saludar(string nombre);
        [OperationContract]
        string Mostrar(int id);
    }
}
