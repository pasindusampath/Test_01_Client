import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MathServer extends UnicastRemoteObject implements MathService {

    protected MathServer() throws RemoteException {
        System.out.println("called");
    }

    @Override
    public int add(int num1, int num2) throws RemoteException {
        return 0;
    }

    @Override
    public int subtract(int num1, int num2) throws RemoteException {
        return 0;
    }

    @Override
    public int multiply(int num1, int num2) throws RemoteException {
        return 0;
    }

    @Override
    public int divide(int num1, int num2) throws RemoteException {
        return 0;
    }
}
