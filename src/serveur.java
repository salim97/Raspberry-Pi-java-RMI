import java.awt.EventQueue;
import java.net.MalformedURLException;
import java.rmi.* ;




public class serveur {

	public static void main(String[] args) {
		
		
		try {
			class_Dist cod = new class_Dist() ;
//			System.out.println("cpu temp :  "+ cod.getCPUtemp());

			Naming.rebind("serverState", cod);

			System.out.println("Serveur preet ... ");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}

