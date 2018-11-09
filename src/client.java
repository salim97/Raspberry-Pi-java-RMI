import java.awt.EventQueue;
import java.rmi.* ;
import java.rmi.server.* ;
import java.util.* ;
import java.net.MalformedURLException;
import java.util.Scanner;


public class client {

	public static void main(String[] args) {
		int a , b ;
		a = 5 ;
		b = 7 ;
		 interface_Dist iod;
		try {
			iod = (interface_Dist)Naming.lookup("rmi://localhost/serverState");
			System.out.println("remote cpu temp: "+iod.getCPUtemp());
			System.out.println("remote cpu voltage: "+iod.getCPUvolt());
			while(true)
			{
				Scanner in = new Scanner(System.in);
				int num = in.nextInt();
				if(num == 1)
					iod.setGreenLED(true);
				else
					iod.setGreenLED(false);
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}

