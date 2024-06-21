package bo;

import java.util.ArrayList;

import bean.HocVienbean;
import dao.HocViendao;

public class HocVienbo {
	HocViendao svd = new HocViendao();
	ArrayList<HocVienbean> dsbean;
	public ArrayList<HocVienbean> getSV() throws Exception{
		dsbean = svd.getSV();
		return dsbean;
	}
	
	ArrayList<HocVienbean> ds;
	public ArrayList<HocVienbean> Find(String key) throws Exception{
		ArrayList<HocVienbean> tam = new ArrayList<HocVienbean>();
		for(HocVienbean sv:ds){
			if(sv.getHoten().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tam.add(sv);
		}
		return tam;
	}
	
	public void Luu(ArrayList<HocVienbean> ds){
		svd.Luu(ds);
	}
}
