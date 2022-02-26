


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;
import com.mkyong.rmiinterface.RMIInterface;

public class cliente {
  private static RMIInterface look_up;

  public static void main(String[] args)
    throws MalformedURLException, RemoteException, NotBoundException {

    look_up = (RMIInterface) Naming.lookup("//localhost/MyServer");
		String txt = JOptionPane.showInputDialog("Como te llamas?");
		String response = look_up.hola(txt);
		JOptionPane.showMessageDialog(null, response);

    }
  
}
