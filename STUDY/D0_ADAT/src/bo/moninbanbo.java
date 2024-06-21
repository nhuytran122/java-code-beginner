package bo;

import java.util.ArrayList;

import bean.moninbanbean;
import dao.DaoGetMon;

public class moninbanbo {
	DaoGetMon dc = new DaoGetMon();
	ArrayList<moninbanbean> ds;
	public ArrayList<moninbanbean> getmon(String Ban) throws Exception{
		ds = dc.getmon(Ban);
		return ds;
	}
//	public int Xoa(MonBean Mon) throws Exception
//	{
//		return dc.Xoa(Mon);
//	}
}
