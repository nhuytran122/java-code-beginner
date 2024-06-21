public class A2_Toan_tu_cac_phep_toan {
	public static void main(String[] args) {
		int a = 5;
		int b = 2;
		float thuong = (float) a / b;
		System.out.println(a + " / " + b + " = " + thuong);
		System.out.println("a = " + a);
		// ++a: cộng rồi dùng
		// a++: dùng rồi cộng
		System.out.println("++a = " + ++a);
		System.out.println("a++ = " + a++);
		System.out.println("a = " + a);
		
		// Toán tử so sánh:
		System.out.println(a + " == " + b + ": " + (a==b));
		System.out.println("Ca 2 la so chan: " + (a%2 == 0 && b%2 == 0));
		
		// Toán tử 3 ngôi
		String kq = (a%2 == 0) ? "So chan" : "So le";
		System.out.println(a + " la " + kq);
		
		// Hàm Math
		System.out.println("|a| = " + Math.abs(a));
		System.out.println("min(a, b) = " + Math.min(a, b));
		//ceil: làm tròn lên
		//floor: làm tròn xuống
		System.out.println("ceil(a) = " + Math.ceil(a));
		System.out.println("floor(a) = " + Math.floor(a));
		System.out.println("sqrt(a) = " + Math.sqrt(a));
		System.out.println("a^b = " + Math.pow(a, b));
	}
	
	
}
