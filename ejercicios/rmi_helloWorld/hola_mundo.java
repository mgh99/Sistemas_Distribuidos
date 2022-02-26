package com.mkyong.rmiinterface;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {
  public String hola(String nombre) throws RemoteException;
}
