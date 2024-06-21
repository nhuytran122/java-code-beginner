package bo;

import java.util.ArrayList;

import bean.Xebean;
import dao.XeDao;

public class XeBo {
	
	XeDao xd = new XeDao();
	ArrayList<Xebean> dsbean;
	public ArrayList<Xebean> getXeVao() throws Exception{
		dsbean = xd.getXeVao();
		return dsbean;
	}
	
	public ArrayList<Xebean> getXeRa() throws Exception{
		dsbean = xd.getXeRa();
		return dsbean;
	}
	public ArrayList<Xebean> getFullInf(ArrayList<Xebean> dsvao, ArrayList<Xebean> dsra) throws Exception{
		dsbean = xd.ADDFull(dsvao, dsra);
		return dsbean;
	}
	
	public void Luu(ArrayList<Xebean> ds){
		xd.Luu(ds);
	}
	
}
