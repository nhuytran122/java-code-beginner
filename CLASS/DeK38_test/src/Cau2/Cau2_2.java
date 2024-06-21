package Cau2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Cau2_2 {
	public static void main(String[] args) {
		try {
			//ArrayList<Integer> tt = new ArrayList<Integer>();
			ArrayList<String> tt = new ArrayList<String>();
			FileReader f = new FileReader("input2.txt");
			BufferedReader b = new BufferedReader(f);
			while(true) {
				String st = b.readLine();
				if(st == null || st == "") break;
				tt.add(st);
				//tt.add(Integer.parseInt(st));
			}
			b.close();
			for(String tmp:tt)
				System.out.println(tmp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
