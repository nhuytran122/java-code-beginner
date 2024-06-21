import java.util.Scanner;
import java.util.regex.Pattern;

public class A4_Pattern_Matcher_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		//vd1: Chỉ nhận 1 số
		//Pattern p = Pattern.compile("^[0-9]$");
		
		//vd2: Nhập nhiều số
		//Pattern p = Pattern.compile("^[0-9]+$");
		//vd3: Nhập số >= 6 kí tự
		//Pattern p = Pattern.compile("^[0-9]{6,}$");
		
		//vd4: Nhập số = 6 kí tự
		//Pattern p = Pattern.compile("^[0-9]{6}$");
		
		//vd5: Nhập số trong khoảng từ 6-10 kí tự
		//Pattern p = Pattern.compile("^[0-9]{6,10}$");
		
		//vd6: Nhập chữ cái
		//Pattern p = Pattern.compile("^[a-zA-Z]+$");
		
		//vd7: Nhập cả số và chữ
		//Pattern p = Pattern.compile("^[a-zA-Z0-9]+$");
		
		//vd8: Nhập cả số và chữ, có khoảng cách
		Pattern p = Pattern.compile("^[a-zA-Z0-9 ]+$");
		while(true) {
			System.out.println("Nhap 1 so: ");
			String so = sc.nextLine();
			if(p.matcher(so).find()) {
				System.out.println("TRUE");
				break;
			}
			else System.err.println("FALSE");
		}
	}

}
