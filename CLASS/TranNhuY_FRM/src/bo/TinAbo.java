package bo;

import java.util.ArrayList;

import bean.TinAbean;
import dao.TinAdao;

public class TinAbo {
	TinAdao tad = new TinAdao();
	ArrayList<TinAbean> dsbean;
	public ArrayList<TinAbean> getTinA() throws Exception{
		dsbean = tad.getTinA();
		return dsbean;
	}
}
