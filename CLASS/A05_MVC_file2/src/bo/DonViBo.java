package bo;

import java.util.ArrayList;

import bean.DonViBean;
import dao.DonViDao;

public class DonViBo {
	DonViDao dvd = new DonViDao();
	ArrayList<DonViBean> dsbean;
	public ArrayList<DonViBean> getDV() throws Exception{
		dsbean = dvd.getDV();
		return dsbean;
	}
	public ArrayList<DonViBean> ThemDV(String MaDV, String tenDV) throws Exception{
		for(DonViBean dvbe:dsbean) 
			if(dvbe.getMadv().toLowerCase().trim().equals((MaDV).toLowerCase().trim()))
				return null;
		dsbean.add(new DonViBean(MaDV, tenDV));
		return dsbean;
	} 
	
	public ArrayList<DonViBean> XoaDV(String MaDV) throws Exception{
		for(DonViBean dvbe:dsbean) 
			if(dvbe.getMadv().equals(MaDV)) {
				dsbean.remove(dvbe);
				break;
			}
		
		return dsbean;
	}
	
	public ArrayList<DonViBean> CapNhatDV(String MaDV, String tenDV) throws Exception{
		for(DonViBean dvbe:dsbean) {
			if(dvbe.getMadv().equals(MaDV)) {
				dvbe.setTendv(tenDV);
			}
		}
		return dsbean;
	}
	
	public void Luu(ArrayList<DonViBean> ds) throws Exception{
		dvd.Luu(ds);
	}
	
	
	
}
