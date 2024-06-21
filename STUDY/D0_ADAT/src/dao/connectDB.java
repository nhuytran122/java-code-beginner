package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class connectDB {
	
	public static Connection cn;
	public static void KetNoi() throws Exception{
		//b1: xac dinh HQTCSDL
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		//b2: Ket noi vao CSDL
		String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433;databaseName=Food2;user=sa;password=trannhuy;encrypt=true;trustServerCertificate=true";
		cn=DriverManager.getConnection(url);
		System.out.print("Da ket noi");
	}
	
	public static ResultSet getBang(String tb) throws Exception{
		String sql="select * from "+ tb;
		PreparedStatement cmd = connectDB.cn.prepareStatement(sql);
		return cmd.executeQuery();
	}
	
	public static void main(String[] args){
		try{
			//connectDB CN = new connectDB();
			connectDB.KetNoi();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
