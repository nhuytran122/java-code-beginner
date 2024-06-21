package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class KetNoi {
	public static Connection cn;
	public void ketnoi() throws Exception{
		//B1: Xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		//B2: Ket Noi
		String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433; databaseName=QlSach; user=sa; password=trannhuy; encrypt=true; trustServerCertificate=true";
		cn = DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	
	public void ketnoi(String server, String database, String username, String pass){
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			System.out.println("Da xac dinh HQTCSDL");
			//B2: Ket Noi
			String url = "jdbc:sqlserver://" + server + ":1433; databaseName=" + database +  "; user=" + username+ "; password=" + pass + "; encrypt=true; trustServerCertificate=true";
			cn = DriverManager.getConnection(url);
			System.out.println("Da ket noi");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		try {
			KetNoi kn = new KetNoi();
			kn.ketnoi();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
