import java.rmi.*;
import java.rmi.server.*;

public class RemoteImpl extends UnicastRemoteObject implements IMF_Coin_SN {
    private static final long serialVersionUID = 1L;
    private static int counter = 0;
    
    public String getUniqueSN(String code, String type) throws RemoteException {
      int c = counter;
      counter++;
      return code + type + c;
    }
      
    public RemoteImpl() throws RemoteException { }
    public static void main(String[] args) {
      try {
            IMF_Coin_SN service = (IMF_Coin_SN) new RemoteImpl();
            Naming.rebind("IMFRemote", service);
          } catch (Exception e) {
            e.printStackTrace();
          }
     }
}
