
/*
  Sample client usage:
    To get remote object proxy:
       IMF_Coin_SN service = 
              (IMF_Coin_SN) Naming.lookup("//127.0.0.1/IMF_Coin_SN");

    To use proxy to get unique serial number:
       String s = service.getUniqueSN("USD", "Quarter");
  

  A note about IP numbers in the lookup...
  127.0.0.1 is the special IP number that refers to the "localhost"; that is,
            it refers to the machine you are currently running on.
  152.10.10.65 is the IP number for student2.cs.appstate.edu, but there are
               some permission problems sometimes when using that number.

  Safest bet is to run the code on student2 using the 127.0.0.1 server IP.
 */
import java.rmi.*;

public interface IMF_Coin_SN extends Remote {
    public String getUniqueSN(String countryCode, String coinType) throws RemoteException;
}
