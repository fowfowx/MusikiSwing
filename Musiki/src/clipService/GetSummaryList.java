package clipService;

import java.util.HashMap;
import java.util.Map;

import javax.swing.table.DefaultTableModel;

import models.Dinleyici;

public class GetSummaryList {
	public static DefaultTableModel getList(Dinleyici dinleyici) {
		
		
		HashMap<String,Long> map = dinleyici.listenTimes;
       

   
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Music Genre"); 
        model.addColumn("Time"); 

       
        for (Map.Entry<String, Long> entry : map.entrySet()) {
            Object[] row = {"" + entry.getKey() +" Turu" , "" + entry.getValue().longValue()/1000000 +   " saniye"};
            model.addRow(row);
        }
        
        
        

       
        return model;
		
	}

}
