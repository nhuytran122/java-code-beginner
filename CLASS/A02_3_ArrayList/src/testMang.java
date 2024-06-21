import java.util.ArrayList;

public class testMang {

	public static void main(String[] args) {
		ArrayList<String> ds = new ArrayList<String>();
		ds.add("Ha"); ds.add("Hung"); ds.add("Minh");
		int n = ds.size();
		for(int i=0; i<n; i++) {
			System.out.println(ds.get(i));
		}
		
		System.out.println("\nCach 2: ");
		for(String ht : ds) {
			System.out.println(ht);
		}

	}

}
