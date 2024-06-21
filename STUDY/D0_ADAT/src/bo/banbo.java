package bo;

import java.util.ArrayList;

import bean.banbean;
import dao.bandao;
import dao.Test1;

public class banbo {
	bandao dc= new bandao();
	ArrayList<banbean> ds;
	public ArrayList<banbean> getban() throws Exception
	{
		ds = dc.getban();
		return ds;
	}
//	public int Xoa(BanBean ban1) throws Exception
//	{
//		return dc.Xoa(ban1);
//	}
}
