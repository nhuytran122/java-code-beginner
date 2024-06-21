//là phần xử lý logic của chương trình, là trung gian giữa Controller 
//và DAO, các lớp khác muốn giao tiếp với csdl phải thông qua trung giang BO.
//Nó chỉ biết sự tồn tại của DAO và java bean.
package bo;

import java.util.ArrayList;

import bean.monbean;
import dao.mondao;

public class monbo {
	mondao mdao=new mondao();
	monbean mbe=new monbean();
	ArrayList<monbean> ds;
	public ArrayList<monbean> getmon() throws Exception{
		ds = mdao.getmon();
		return ds;
	}
	
	public int themmon(monbean mb) throws Exception{
		for(monbean mon1:ds){
			if(mon1.getMamon().equals(mb.getMamon())){
				return 0;
			}
		}
		return mdao.Themmon(mb);
	}
	
	public ArrayList<monbean> Sua(String maMon, String tenMon, String gia, String loaiMon) throws Exception{
		int n = ds.size();
		for(int i=0;i<n;i++)
			if(ds.get(i).getMamon().equals(maMon)) {
				monbean mbe=ds.get(i);
				mbe.setTenmon(tenMon);;
				mbe.setGia(gia);;
				mbe.setLoaimon(loaiMon);;
				ds.set(i, mbe);//Sua trong bo nho
				mdao.Sua(maMon, tenMon, gia, loaiMon);//Sua trong csdl
				break;
		  }
		  return ds;
	}
	
	public ArrayList<monbean> Find(String key) throws Exception{
		ArrayList<monbean> tam=new ArrayList<monbean>();
		for(monbean mon:ds){
			if(mon.getTenmon().toLowerCase().trim().contains(key.toLowerCase().trim()) || mon.getMamon().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tam.add(mon);
		}
		return tam;
	}
	
	public int Xoa(monbean Mon) throws Exception{
		return mdao.xoaMon(Mon);
	}
}
