//là phần xử lý logic của chương trình, là trung gian giữa Controller 
//và DAO, các lớp khác muốn giao tiếp với csdl phải thông qua trung giang BO.
//Nó chỉ biết sự tồn tại của DAO và java bean.
package bo;

import java.util.ArrayList;

import bean.khachhangbean;
import bean.monbean;
import dao.khachhangdao;

public class khachhangbo {
	khachhangdao khd = new khachhangdao();
	khachhangbean khb = new khachhangbean();
	ArrayList<khachhangbean> dskh;
	public ArrayList<khachhangbean> getKH() throws Exception{
		dskh = khd.getKH();
		return dskh;
	}
	
	public ArrayList<monbean> ThemMon(String mamon, String tenmon, Double gia, String loaimon) throws Exception{
		for(monbean mbe:ds)
			if(mbe.getMamon().toLowerCase().trim().equals((mamon).toLowerCase().trim()))
					return null;
		ds.add(new monbean(mamon, tenmon, gia, loaimon)); //them trong bo nho
		md.ThemMon(mamon, tenmon, gia, loaimon);//them vao csdl
		return ds;
	}
	
	public int ThemKH(khachhangbean kb) throws Exception{
		for(khachhangbean k1:dskh){
			if(k1.getMaKH().equals(kb.getMaKH())){
				return -1;
			}
			else if(k1.getSdt().equals(kb.getSdt())){
				return 0;
			}
		}
		return khd.ThemKH(kb);
	}
	public ArrayList<khachhangbean> Find(String key) throws Exception{
		ArrayList<khachhangbean> tam = new ArrayList<khachhangbean>();
		for(khachhangbean kb:dskh){
			if(kb.getTenKH().toLowerCase().contains(key.toLowerCase()) || kb.getMaKH().contains(key))
				tam.add(kb);
		}
		return tam;
	}
	
	public int Xoa(khachhangbean khach) throws Exception{
		return khd.xoaKH(khach);
	}
}
