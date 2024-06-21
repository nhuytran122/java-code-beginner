package bo;

import java.util.ArrayList;
import bean.dangnhapbean;
import bean.sachbean;
import dao.dangnhapdao;
public class dangnhapbo {
	dangnhapdao dndao = new dangnhapdao();
	public dangnhapbean ktDn(String tenDangNhap, String matKhau) throws Exception{
		return dndao.ktDn(tenDangNhap, matKhau);
	}
}
