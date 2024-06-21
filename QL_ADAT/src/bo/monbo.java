package bo;

import java.util.ArrayList;

import bean.monbean;
import dao.mondao;

public class monbo {
	mondao md = new mondao();
	monbean mbe = new monbean();
	ArrayList<monbean> ds;
	public ArrayList<monbean> getMon() throws Exception{
		ds = md.getMon();
		return ds;
	}
	
	public ArrayList<monbean> ThemMon(String mamon, String tenmon, Double gia, String loaimon) throws Exception{
		for(monbean mbe:ds)
			if(mbe.getMamon().toLowerCase().trim().equals((mamon).toLowerCase().trim()))
					return null;
		ds.add(new monbean(mamon, tenmon, gia, loaimon)); //them trong bo nho
		md.ThemMon(mamon, tenmon, gia, loaimon);//them vao csdl
		return ds;
	}
	
	public ArrayList<monbean> SuaMon(String mamon, String tenmon, Double gia, String loaimon) throws Exception{
		int n = ds.size();
		for(int i = 0; i < n; i++)
			if(ds.get(i).getMamon().equals(mamon)) {
				monbean mbe=ds.get(i);
				mbe.setTenmon(tenmon);;
				mbe.setGia(gia);;
				mbe.setLoaimon(loaimon);;
				ds.set(i, mbe);//Sua trong bo nho
				md.SuaMon(mamon, tenmon, gia, loaimon);//Sua trong csdl
				break;
		  }
		  return ds;
	}
	
	public ArrayList<monbean> XoaMon(String mamon) throws Exception{
		for(monbean mbe:ds)
			if(mbe.getMamon().equals(mamon)) {
				ds.remove(mbe); //xoa trong bo nho
				md.XoaMon(mamon); // xoa trong csdl
				break;
			}
		return ds;
		}
	
	public ArrayList<monbean> TimMon(String key) throws Exception{
		ArrayList<monbean> tmp = new ArrayList<monbean>();
		for(monbean mbe:ds){
			if(mbe.getTenmon().toLowerCase().trim().contains(key.toLowerCase().trim()) || mbe.getMamon().toLowerCase().trim().contains(key.toLowerCase().trim()))
				tmp.add(mbe);
		}
		return tmp;
	}
}
