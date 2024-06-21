package bo;

import java.util.ArrayList;

import bean.XeMaybean;
import dao.XeMayDao;

public class XeMayBo {
	XeMayDao xm = new XeMayDao();
	ArrayList<XeMaybean> dsbean;
	public ArrayList<XeMaybean> getXeMayVao() throws Exception{
		dsbean = xm.getXeMayVao();
		return dsbean;
	}
	
	public ArrayList<XeMaybean> getXeMayRa() throws Exception{
		dsbean = xm.getXeMayRa();
		return dsbean;
	}
}
