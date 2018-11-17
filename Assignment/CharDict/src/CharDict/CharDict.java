package CharDict;
import java.util.*;
import java.util.Map.Entry;

public class CharDict {
	public static void main(String[] args) {
		TreeMap<Character, Integer> charMap = new TreeMap<Character, Integer>();
		String str = new String();
		Scanner strRead = new Scanner(System.in);
		// get the input.
		if(strRead.hasNextLine()) {
			str = strRead.nextLine();
		}
		// traverse the string.
		for(int i = 0; i < str.length(); ++i) {
			char ch = str.charAt(i);
			if(charMap.containsKey(ch)) {
				charMap.put(ch, (int)charMap.get(ch) + 1);
			}else {
				charMap.put(ch, 1);
			}
		}
		// transfer the TreeMap into List.
		List<Map.Entry<Character, Integer>> list = new ArrayList<Map.Entry<Character, Integer>>(charMap.entrySet());
		// override the comparator.
		Collections.sort(list,new Comparator<Map.Entry<Character, Integer>>() { 
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue() - o2.getValue();
			}  
        });  
		// output the result.
		for (Entry<Character, Integer> e: list) {
			System.out.println(e.getKey());
		} 
	}
}
