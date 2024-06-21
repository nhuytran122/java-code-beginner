package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.dangnhapbean;

public class dangnhapdao {
	public dangnhapbean ktDn(String tenDangNhap, String matKhau) throws Exception {
		String sql = "select * from DangNhap where TenDangNhap = ? and MatKhau = ?";
		// B3: Tao cau lenh
		PreparedStatement cmd = KetNoi.cn.prepareStatement(sql);
		cmd.setString(1, tenDangNhap);
		cmd.setString(2, matKhau);
		// B4: Thuc hien cau lenh
		ResultSet rs = cmd.executeQuery();
		dangnhapbean dn = null;
		// B5: Duyet qua rs
		if (rs.next()) { // co 1 dong
			Boolean quyen = rs.getBoolean("Quyen");
			dn = new dangnhapbean(tenDangNhap, matKhau, quyen);
		}
		rs.close();
		return dn;
	}
}
