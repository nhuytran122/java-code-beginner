package view;

import java.util.ArrayList;

import bean.DonViBean;
import bo.DonViBo;

public class donviview0 {
	public static void main(String[] args) {
		try {
			DonViBo dvbo = new DonViBo();
			ArrayList<DonViBean> ds;
			ds = dvbo.getDV();
			for(DonViBean dv:ds)
				System.out.println(dv.toString());
			
			dvbo.ThemDV("DV4", "Khoa MT");
			System.out.println("Sau khi them: ");
			for(DonViBean dv:ds)
				System.out.println(dv.toString());
			
			dvbo.XoaDV("DV1");
			System.out.println("Sau khi xoa: ");
			for(DonViBean dv:ds)
				System.out.println(dv.toString());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
