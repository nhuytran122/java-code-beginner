package NOTE;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DATE {
	SimpleDateFormat d = new SimpleDateFormat("HH:mm dd/MM/yyyy");
	
	//Chuyển date -> String
	//String t = d.format(<kieu Date>); 
	
	//String ns = "2000-09-19";
	//Doi String --> Date
	//Date ngay = d.parse(ns);
	
	//VỚI SQL
//	String ns = "2000-09-19";
//	//Doi chuoi sang util
//	SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
//	Date ngay = d.parse(ns);
//	
//	//Doi ngay util sang ngay sql
//	cmd.setDate(4, new java.sql.Date(ngay.getTime()));

}
