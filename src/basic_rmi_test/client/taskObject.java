package basic_rmi_test.client;

import basic_rmi_test.Task;
import java.io.Serializable;

public class taskObject implements Task, Serializable {
    /*
     * This is used as a remote object, sent from our client to the server to be executed.
     */
    @Override
    public Object execute() {
        System.out.println("Hello world!");
        return null;
    }
    
}
