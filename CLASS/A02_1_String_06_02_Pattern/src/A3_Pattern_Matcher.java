import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A3_Pattern_Matcher {

	public static void main(String[] args) {
		// Sử dụng lớp Pattern và Matcher trong Java
		// BT: Nhập vào 1 địa chỉ email, sđt và ngày sinh của 1 SV. Sau đó kiểm tra xem 3 thông tin nhập hay không
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap email: ");
		String email = sc.nextLine();
		System.out.println("Nhap sdt: ");
		String sdt = sc.nextLine();
		System.out.println("Nhap ngay sinh: ");
		String ns = sc.nextLine();
		//C1: 
//		Pattern patternEmail = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
		/*Pattern patternEmail = Pattern.compile("^[A-Za-z0-9\\_]+@[a-z]+(\\.[a-z]+)+$");
		Matcher matcherEmail = patternEmail.matcher(email);

		Pattern patternPhone = Pattern.compile("^[0-9]{10}$");
		Matcher matcherPhone = patternPhone.matcher(sdt);

		Pattern patternBirth = Pattern.compile("^(0[1-9]|1[0-2])/(0[1-9]|[1-2][0-9]|3[0-1])/[0-9]{4}$");
		Matcher matcherBirth = patternBirth.matcher(ns);

		if (matcherEmail.matches() && matcherPhone.matches() && matcherBirth.matches()) {
			System.out.println("Thông tin vừa nhập đúng");
		} else {
			System.out.println("Thông tin vừa nhập không đúng");
		}*/
		
		// C2:
		Pattern patternEmail = Pattern.compile("^[A-Za-z0-9\\_]+@[a-z]+(\\.[a-z]+)+$");

		Pattern patternPhone = Pattern.compile("^[0-9]{10}$");

		Pattern patternBirth = Pattern.compile("^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}$");
		if (patternEmail.matcher(email).find() && patternPhone.matcher(sdt).find() && patternBirth.matcher(ns).find()) {
			System.out.println("Thông tin vừa nhập đúng");
		} else {
			System.err.println("Thông tin vừa nhập không đúng");
		}
		sc.close();

	}

}
