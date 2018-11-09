import java.rmi.* ;
import java.rmi.server.* ;

public interface interface_Dist extends Remote{
	
	
	public String getCPUtemp() throws RemoteException ;
	public String getCPUvolt() throws RemoteException ;
	public void setGreenLED(Boolean active) throws RemoteException ;
	public String _getCLIoutput(Process proc ) throws RemoteException ;

}

