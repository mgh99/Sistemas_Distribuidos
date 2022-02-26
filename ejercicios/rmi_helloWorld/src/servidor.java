package com.mkyong.rmiserver;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class servidor extends UnnicastRemoteObject implements RMIInterface {
  private static final log serialVersionUID = 1L;

  protected servidor() throws RemoteException{
    super();
  }

  public String hola(String nombre) throws RemoteException {
    System.err.println(nombre + " estoy tratatndo de conectarme");
    return "El servidor dice hola a " + nombre;
  }

  public static void main(String[] args) {
    try {
      Naming.rebind("//localhost/MyServer", (Remote) new servidor());
      System.err.println("El servidor esta listo");
    }catch(Exception e) {
      System.err.println("Excepcion del ser servidor: " + e.toString());
      e.printStackTrace();
    }
  }
}
