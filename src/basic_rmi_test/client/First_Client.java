package basic_rmi_test.client;

import basic_rmi_test.Compute;
import basic_rmi_test.Task;
import basic_rmi_test.server.RMI_Server;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/*******************************************************************************************
 * 
 * Just needs to be able to pass a remote object to the RMI Server.
 * 
 *******************************************************************************************/
public class First_Client {
    
    public static void main(String[] args) {
        if(System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
        
        try{
            String name = "RMI_Server";
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            Compute comp = (Compute) registry.lookup(name);
            
            taskObject task = new taskObject();
            comp.executeTask(task);
            
        } catch(Exception e){
            System.out.println("Error in binding process:");
            e.printStackTrace();
        }
    }
}
