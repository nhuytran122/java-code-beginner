package Cau2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Cau2_1 {
	public static void main(String[] args) {
		try {
			ArrayList<Integer> tt = new ArrayList<Integer>();
			FileReader f = new FileReader("input1.txt");
			BufferedReader b = new BufferedReader(f);
			while(true) {
				String st = b.readLine();
				if(st == null || st == "") break;
				tt.add(Integer.parseInt(st));
			}
			b.close();
			System.out.println(tt);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
