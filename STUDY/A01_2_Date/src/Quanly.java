public class Quanly {
	public static void main(String[] args) {
		Date md = new Date(31, 1, 2021);
		System.out.println("Day = "+ md.getDay());
		md.setDay(35);
		System.out.println("Day = "+ md.getDay());
		md.setDay(30);
		System.out.println("Day = "+ md.getDay());
		
		System.out.println("Month = "+ md.getMonth());
		md.setMonth(13);
		System.out.println("Month = "+ md.getMonth());
		md.setMonth(5);
		System.out.println("Month = "+ md.getMonth());
		
		System.out.println("toString: ");
		System.out.println(md);
		
		Date md1 = new Date(15, 5, 2025);
		Date md2 = new Date(11, 1, 2021);
		Date md3 = new Date(15, 5, 2025);
		System.out.println("md1 so sanh bang md2: "
                + md1.equals(md2));
		
		System.out.println("md1 so sanh bang md3: "
		                + md1.equals(md3));
		
		System.out.println("Hashcode md1 " + md1.hashCode());
		System.out.println("Hashcode md2 " + md2.hashCode());
		System.out.println("Hashcode md3 " + md3.hashCode());
	}
}