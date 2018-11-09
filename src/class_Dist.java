import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

public class class_Dist extends UnicastRemoteObject implements interface_Dist {
	public class_Dist() throws RemoteException {
	}

	public String getCPUtemp() throws RemoteException {
		Runtime rt = Runtime.getRuntime();
		// to get temperateur of cpu you need to execute this command "vcgencmd measure_temp " on raspberry pi
		String[] commands = { "vcgencmd", "measure_temp" };
		Process proc = null;
		;

		try {
			proc = rt.exec(commands);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			proc = rt.exec(commands);
			return _getCLIoutput(proc);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;

	}

	public String getCPUvolt() throws RemoteException {
		Runtime rt = Runtime.getRuntime();
		// to get volt of cpu you need to execute this command "vcgencmd measure_volts core" on raspberry pi
		String[] commands = { "vcgencmd", "measure_volts", "core" };
		Process proc = null;
		

		try {
			proc = rt.exec(commands);
			return _getCLIoutput(proc);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	public void setGreenLED(Boolean active) throws RemoteException {
		// to turn on off green led on board we need to write "default-on" or "none" to /sys/class/leds/led0/trigger file in raspberry pi
		try {
			BufferedWriter writer;
			writer = new BufferedWriter(new FileWriter("/sys/class/leds/led0/trigger"));
			if (active)
				writer.write("default-on");
			else
				writer.write("none");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String _getCLIoutput(Process proc) throws RemoteException {
		//this method will read first line and return it ;
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));

		BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

		// read the output from the command
		String s = null;
		try {
			while ((s = stdInput.readLine()) != null) {
				// System.out.println(s);
				return s;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return s;

	}
}
