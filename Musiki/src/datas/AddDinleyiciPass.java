package datas;

import java.io.FileWriter;
import java.io.IOException;

public class AddDinleyiciPass {
	public static void ekleDosyaya(String username,String password) {
		
		try{
			 FileWriter writer = new FileWriter("DinleyiciLoginPass.csv",true);
			 
			 writer.write("\n"+username+","+password);
			 
			 writer.close();
			 
		}catch (IOException e) {
			 // TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}