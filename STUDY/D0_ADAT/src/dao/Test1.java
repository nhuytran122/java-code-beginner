package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Test1 {
	public static Connection cn;
	public static void KetNoi () throws Exception{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		System.out.println("Da xac dinh HQTCSDL");
		String url = "jdbc:sqlserver://PC-HFA1062\\SQLEXPRESS01:1433;databaseName=Food2;user=sa;password=trannhuy;encrypt=true;trustServerCertificate=true";
		cn=DriverManager.getConnection(url);
		System.out.println("Da ket noi");
	}
	
	public static ResultSet getBang(String tb) throws Exception {
		String sql="select * from " +tb;
		PreparedStatement cmd=cn.prepareStatement(sql);
		return cmd.executeQuery();		
	}
	public static ResultSet getMon(String Ban) throws Exception	{
		String sql="select TenMon, SoLuongMon from tbl_BAN join tbl_PHIEUDATMON on tbl_BAN.MaBan = tbl_PHIEUDATMON.MaBan join tbl_CTPhieu on tbl_PHIEUDATMON.MaPhieu = tbl_CTPhieu.MaPhieu join tbl_MON on tbl_CTPhieu.MaMon = tbl_MON.MaMon where tbl_BAN.MaBan='" + Ban +"'";
		PreparedStatement cmd=cn.prepareStatement(sql);
		return cmd.executeQuery();
	}
	
	public static void main(String[] args)	{
		try	{
			Test1 cn = new Test1();
			connectDB.KetNoi();;
		}catch(Exception e)	{
			e.printStackTrace();
		}
	}
}
