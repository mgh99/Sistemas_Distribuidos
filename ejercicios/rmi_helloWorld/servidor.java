package com.mkyong.rmiserver;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnnicastRemoteObject;
import com.mkyong.rmiinterface.RMIInterface;

public class Servidor extends UnnicastRemoteObject implements RMIInterface {
  private static final log serialVersionUID = 1L;

  protected Servidor() throws RemoteException{
    super();
  }

  @Override
  public String hola(String nombre) throws RemoteException {
    System.err.println(nombre + " estoy tratatndo de conectarme");
    return "El servidor dice hola a " + nombre;
  }

  public static void main(String[] args) {
    try {
      Naming.rebind("//localhost/MyServer", new Servidor());
      System.err.println("El servidor esta listo");
    }catch(Exception e) {
      System.err.println("Excepcion del ser servidor: " + e.toStrig());
      e.printStackTrace();
    }
  }
}
