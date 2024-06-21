package bo;

import java.util.ArrayList;

import bean.XeDapbean;
import dao.XeDapDao;

public class XeDapBo {
	XeDapDao xd = new XeDapDao();
	ArrayList<XeDapbean> dsbean;
	public ArrayList<XeDapbean> getXeDapVao() throws Exception{
		dsbean = xd.getXeDapVao();
		return dsbean;
	}
	
	public ArrayList<XeDapbean> getXeDapRa() throws Exception{
		dsbean = xd.getXeDapRa();
		return dsbean;
	}
}
