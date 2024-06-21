package view;

import java.util.ArrayList;

import bean.Xebean;
import bo.XeBo;

public class test_input2 {
	
	public static void main(String[] args) {
		XeBo xb = new XeBo();
		ArrayList<Xebean> ds = new ArrayList<Xebean>();
		try {
			ds = xb.getXeRa();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("DANH SACH RA");
		for(Xebean x:ds)
			System.out.println(x);
	}
}
