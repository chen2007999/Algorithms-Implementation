package SortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;

public class GroupAnagrams {

	void groupAnagrams1(String[] arr) {
		if (arr == null || arr.length <= 2) {
			return;
		}
		int i = 0;
		int closestNonAnagram = 1;
		while (closestNonAnagram < arr.length - 1) {
			Hashtable<Character, Integer> hash = getHashtable(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				if (isAnagram(arr[j], hash)) {
					if (j != closestNonAnagram) {
						arr[closestNonAnagram] = arr[j];
						String temp = arr[j];
						arr[closestNonAnagram] = temp;
						closestNonAnagram++;
					}
				}
			}
			i = closestNonAnagram;
			closestNonAnagram++;
		}
	}

	private Hashtable<Character, Integer> getHashtable(String string) {
		Hashtable<Character, Integer> result = new Hashtable<>();
		for (int i = 0; i < string.length(); i++) {
			int value = 1;
			if (result.containsKey(string.charAt(i))) {
				value += result.get(string.charAt(i));
			}
			result.put(string.charAt(i), value);
		}
		return result;
	}

	private boolean isAnagram(String string, Hashtable<Character, Integer> hash) {
		Hashtable<Character, Integer> clone = new Hashtable<>(hash);
		for (int i = 0; i < string.length(); i++) {
			if (!clone.containsKey(string.charAt(i))) {
				return false;
			} else {
				if (clone.get(string.charAt(i)) == 1) {
					clone.remove(string.charAt(i));
				} else {
					clone.put(string.charAt(i), clone.get(string.charAt(i)) - 1);
				}
			}
		}
		return clone.size() == 0;
	}

	void groupAnagrams2(String[] arr) {
		Hashtable<String, ArrayList<String>> hash = new Hashtable<>();
		for (int i = 0; i < arr.length; i++) {
			String sortedString = sortString(arr[i]);
			if(hash.containsKey(sortedString)) {
				hash.get(sortedString).add(arr[i]);
			} else {
				ArrayList<String> list = new ArrayList<>();
				list.add(arr[i]);
				hash.put(sortedString, list);
			}
		}
		Iterator<ArrayList<String>> it = hash.values().iterator();
		int index = 0;
		while(it.hasNext()) {
			for(String toAdd : it.next()) {
				arr[index] = toAdd;
				index++;
			}
		}
 	}

	private String sortString(String str) {
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
}
