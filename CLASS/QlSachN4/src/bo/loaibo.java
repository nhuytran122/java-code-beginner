package bo;

import java.util.ArrayList;
import bean.loaibean;
import dao.loaidao;

public class loaibo {
	loaidao ldao = new loaidao();
	ArrayList<loaibean> dsbean;
	public ArrayList<loaibean> getLoai() throws Exception{
		dsbean = ldao.getLoai();
		return dsbean;
	}
}
