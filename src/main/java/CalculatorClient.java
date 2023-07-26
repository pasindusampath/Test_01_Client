import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CalculatorClient {
    public static void main(String[] args) {
        if(System.getSecurityManager()==null){
            System.setSecurityManager(new RMISecurityManager());
        }

        MathService mathService = null;

        try {
            Registry reg = LocateRegistry.getRegistry("192.168.43.60", 1099);
            mathService = (MathService) reg.lookup("CalculatorService");
            /*System.out.println(Naming.lookup("//localhost:1099/CalculatorService"));
            mathService=(MathService) Naming.lookup("//localhost:1099/CalculatorService");*/
            System.out.println(mathService);
            System.out.println(mathService.add(1,2));
            System.out.println(mathService.divide(5,3));
            //System.out.println(mathService.add(1,2));
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }
}
