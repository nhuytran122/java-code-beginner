package bo;

import java.io.BufferedReader;
import java.io.FileReader;
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
		//Them vao csdl
		dvd.ThemDV(MaDV, tenDV);
		return dsbean;
	} 
	
	public ArrayList<DonViBean> XoaDV(String MaDV) throws Exception{
		for(DonViBean dvbe:dsbean) 
			if(dvbe.getMadv().equals(MaDV)) {
				dsbean.remove(dvbe); //xoa trong bo nho
				dvd.Xoa(MaDV); // xoa trong csdl
				break;
			}
		
		return dsbean;
	}
	
	public ArrayList<DonViBean> CapNhatDV(String madv, String tendvmoi) throws Exception{
		int n = dsbean.size();
		for(int i=0;i<n;i++)
			if(dsbean.get(i).getMadv().equals(madv)) {
				DonViBean dv=dsbean.get(i);
				dv.setTendv(tendvmoi);
				dsbean.set(i, dv);//Sua trong bo nho
				dvd.Sua(madv,tendvmoi);//Sua trong csdl
				break;
		  }
		  return dsbean;
	}
	
	public void NapFile() throws Exception{
		FileReader f = new FileReader("donvi.txt");
		BufferedReader b = new BufferedReader(f);
		while(true) {
			String st=b.readLine();
			if(st==null||st=="") break;
			String[] t=st.split("[;]");
			ThemDV(t[0], t[1]);//Them vao csdl
		}
		b.close();
		dsbean = dvd.getDV();
	}
	
//	public void Luu(ArrayList<DonViBean> ds) throws Exception{
//		dvd.Luu(ds);
//	}
	
	
}
