package saimond.etienne.business;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_Download {
	
	private static boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
	
	
	public static void download(int idUser, String url){
		// https://www.youtube.com/watch?v=3EQPsCbmgkk
		String command = null;
		
		if (isWindows) {
			// Too bad ...
		}
		else {
			command = "youtube-dl " + "-o " + idUser + "/  " + url;
		}
		
		System.out.println(B_Download.executeCommand(command));
	}
	
	private static String executeCommand(String command) {

		StringBuffer output = new StringBuffer();

		Process p;
		
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = 
                            new BufferedReader(new InputStreamReader(p.getInputStream()));

                        String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return output.toString();

	}
	
	
}
