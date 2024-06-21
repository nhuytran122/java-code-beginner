package bo;

import java.util.ArrayList;

import bean.Xe4Banhbean;
import dao.Xe4BanhDao;

public class Xe4BanhBo{
	Xe4BanhDao x4b = new Xe4BanhDao();
	ArrayList<Xe4Banhbean> dsbean;
	public ArrayList<Xe4Banhbean> getXe4BanhVao() throws Exception{
		dsbean = x4b.getXe4BanhVao();
		return dsbean;
	}
	
	public ArrayList<Xe4Banhbean> getXe4BanhRa() throws Exception{
		dsbean = x4b.get4BanhRa();
		return dsbean;
	}
}
