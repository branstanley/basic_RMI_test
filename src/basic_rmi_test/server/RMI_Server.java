package basic_rmi_test.server;

import basic_rmi_test.Compute;
import basic_rmi_test.Task;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class RMI_Server implements Compute{
    
    public RMI_Server(){
        super();
    }
    
    @Override
    public <T> T executeTask(Task<T> t) throws RemoteException {
        return t.execute();
    }
    
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try{
            String name = "RMI_Server";
            Compute s = new RMI_Server();
            Compute stub = (Compute) UnicastRemoteObject.exportObject(s, 0);
            
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind(name, stub);
            System.out.println("RMI is now bound.");
            
        } catch(Exception e){
            System.out.println("Error in binding process:");
            e.printStackTrace();
        }
    }
    
}
