import HelloApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class HelloClient {
    static Hello helloImpl;

    public static void main(String args[]) {
        try {
            //creamos e inicislizamos el ORB
            ORB orb = ORB.init(args, null);

            //conseguimos el nombre del root del contexto
            org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");

            //usamos NamingContextExt instanciasdo en NamingContext
            //esta es un aparte del Interoperable nombre del Servicio
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

            //resolvemos la referencia del nombre del objeto
            String name = "Hello";
            helloImpl = HelloHelper.narrow(ncRef.resolve_str(name));

            System.out.println("Obtained a handle on server object: " + helloImpl);
            System.out.println(helloImpl.sayHello());
            helloImpl.shutdown();

        } catch (Exception e) {
            System.out.println("ERROR : " + e);
            e.printStackTrace(System.out);
        }
    }
}