package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 49 - Group Anagrams

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		if (strs.length == 0 || strs == null) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] ca = new char[26];
			for (char c : str.toCharArray()) {
				ca[c - 'a']++;
			}
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr)) {
				map.put(keyStr, new ArrayList<>());
			}
			map.get(keyStr).add(str);
		}
		return new ArrayList<>(map.values());
	}

	public List<List<String>> groupAnagrams1(String[] strs) {
		if (strs.length == 0 || strs == null) {
			return new ArrayList<>();
		}
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			char[] ca = str.toCharArray();
			Arrays.sort(ca);
			String keyStr = String.valueOf(ca);
			if (!map.containsKey(keyStr)) {
				map.put(keyStr, new ArrayList<>());
			}
			map.get(keyStr).add(str);
		}
		return new ArrayList<>(map.values());
	}
}
