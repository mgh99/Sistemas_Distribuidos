import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.util.Properties;

class HelloImpl extends HelloPOA {
    private ORB orb;

    public void setORB (ORB orb_val) {
        orb = orb_val;
    }

    //implementamos el metodo sayHello()
    public String sayHello() {
    return "\nHello world !!\n";
    }

    //implementamos el metodo shutdown()
    public void shutdown() {
        orb.shutdown(false);
    }

}

public class HelloServer {
    public static void main(String args[]) {
        try {
            //creamos e inicializamos el ORB
            ORB orb = ORB.init(args, null);

            //hacemos una referencia a rootpa y activamos POAManager
            POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootpoa.the_POAManager().activate();

            //creamos el servant y register con el ORB
            HelloImpl helloImpl = new HelloImpl();
            helloImpl.setORB(orb);

            //obtenemos el objeto de referencia
            org.omg.CORBA.Object ref = rootpoa.servant_to_reference(helloImpl);
            Hello href = HelloHelper.narrow(ref);

            //conseguimos el nombre del root del contexto
            //Name Service invoca al nombre del servicio
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            //usamos NamingContextExt como una parte del interoperable
            //Especificacion del nombre del servicio (INS)
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            //bind el Objecto que hace referencia al nombre
            String name = "Hello";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path, href);

            System.out.println("HelloServer ready and waiting  ");

            //esperamos a la invocacion del cliente
            orb.run();

        } catch (Exception e) {
            System.err.println("ERROR: " + e);
            e.printStackTrace(System.out);
        }

        System.out.println("HelloServer Exiting ...");
    }
}