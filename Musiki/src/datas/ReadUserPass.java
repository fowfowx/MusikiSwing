package datas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ReadUserPass {
	
	public static HashMap<String,String> ReadPass(String type) {


		String sf1=String.format("%sLoginPass.csv",type);
		
		String file = sf1;
		
		
		
    	BufferedReader reader = null;
    	String line = "";
    	HashMap<String, String> usernamePassword = new HashMap<String, String>();
    	try {
    		reader = new BufferedReader(new FileReader(file));
    		while((line = reader.readLine()) != null) {
    			
    			usernamePassword.put(line.split(",")[0],line.split(",")[1]);
    			
    		}
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		
    	}
    	finally {
    		try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}	
		return usernamePassword;
	}
}
