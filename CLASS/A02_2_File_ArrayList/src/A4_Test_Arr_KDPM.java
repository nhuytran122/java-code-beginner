import java.util.ArrayList;
import java.util.List;

public class A4_Test_Arr_KDPM {
	public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(2);
        arr.add(4);
        arr.add(7);
        arr.add(9);
        arr.add(15);
        
        insertInSortedOrder(arr, 8);
        
        for(Integer x : arr)
        	System.out.println(x);
        
        removeElement(arr, 8);
        
        System.out.println("\n");
        for(Integer x : arr)
        	System.out.println(x);
	}
	
	public static void insertInSortedOrder(List<Integer> arr, int newElement) {
        int i = 0;
        while (i < arr.size()) {
            if (arr.get(i) >= newElement) {
                break;
            }
            i++;
        }
        arr.add(i, newElement);
    }
	
	public static void removeElement(List<Integer> arr, int x) {
        int i = 0;
        while (i < arr.size()) {
            if (arr.get(i) == x) {
                arr.remove(i);
                break;
            }
            i++;
        }
    }	
}
