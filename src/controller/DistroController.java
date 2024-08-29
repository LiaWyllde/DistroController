package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	private String operationalSystem() {
		String idSystem = System.getProperty("os.name");	
		return idSystem; }
	
	private void callProcess (String callProcess) {
		
		String[] callProcessArray = callProcess.split(" ");

		try {
			
			Process process = Runtime.getRuntime().exec(callProcessArray); 
			InputStream returnn = process.getInputStream();
			InputStreamReader reader = new InputStreamReader(returnn);
			BufferedReader buffer = new BufferedReader(reader);
			
			String line = " ";
			
			while (!line.contains("PRETTY_NAME")) {
				line = buffer.readLine();
				if (line.contains("PRETTY_NAME")) {
					String[] distroArray = line.split("\"");
					String[] prettyDistro = distroArray[1].split(" ");
					System.out.println("Distro version: " + prettyDistro[0] + " " + prettyDistro[2]);				
				}
			}
				
				buffer.close();
				reader.close();
				returnn.close();
				
			}catch(Exception e) {
				System.out.println(e.getMessage());}
	}
	
	public void showDistro() {
			
			String typeOS = operationalSystem();			
				
			if (typeOS.contains("Linux")){
				String callType = "cat /etc/os-release";
				callProcess(callType);
				} else {
				System.out.println("The application is unavailable for this operational system");
				System.out.println("The application will be closed...");
				System.exit(0);
			}
	}
}
