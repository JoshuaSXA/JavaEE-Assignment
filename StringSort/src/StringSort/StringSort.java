package StringSort;
import java.util.*;

public class StringSort {
	public static void main(String[] args) {
		// You should input the words line-by-line with '#' marking the end of your input.
		Scanner strReader = new Scanner(System.in);
		List<String> strArray = new ArrayList<String>();
		String str = new String();
		while(strReader.hasNextLine()) {
			str = strReader.nextLine();
			if("#".equals(str)) {
				break;
			}
			strArray.add(str);
		}
		StringSort obj = new StringSort();
		obj.StrQuickSort(strArray, 0, strArray.size() - 1);
		for(String x : strArray) {
			System.out.println(x);
		}
	}
	
	// There is the quick sort algorithm for List object.
	public void StrQuickSort(List<String> strArray, int left, int right) {
		if(left > right) {
			return;
		}
		int i = left, j = right;
		String pivot = new String(strArray.get(left));
		while(i < j) {
			while(i < j && StrCompare(strArray.get(j), pivot)) {
				--j;
			}
			while(i < j && !StrCompare(strArray.get(i), pivot)) {  
                ++i;  
            }  
			if(i < j) {
				Collections.swap(strArray, i, j);
			}
		}
		String tmpStr = new String(strArray.get(i));
		strArray.set(i, strArray.get(left));
		strArray.set(left, tmpStr);
		StrQuickSort(strArray, left, i - 1);
		StrQuickSort(strArray, i + 1, right);
	}
	
	// Here we redefine the metric of comparing two String object.
	public boolean StrCompare(String str1, String str2) {
		if(str1.length() > str2.length()) {
			return true;
		}else if(str1.length() < str2.length()) {
			return false;
		}else {
			if(str1.compareTo(str2) > 0) {
				return true;
			}else {
				return false;
			}
		}
	}
}
