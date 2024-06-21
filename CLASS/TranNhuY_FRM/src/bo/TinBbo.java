package bo;

import java.util.ArrayList;

import bean.TinBbean;
import dao.TinBdao;

public class TinBbo {
	TinBdao tbd = new TinBdao();
	ArrayList<TinBbean> dsbean;
	public ArrayList<TinBbean> getTinB() throws Exception{
		dsbean = tbd.getTinB();
		return dsbean;
	}
}
