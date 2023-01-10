package practice;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	TrieNode root;
	Map<Character, TrieNode> children;
	boolean isWord;

	TrieNode() {
		children = new HashMap<>();
		isWord = false;
	}
}
