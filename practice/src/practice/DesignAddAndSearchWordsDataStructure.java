package practice;

// 211 - Design Add and Search Words Data Structure

public class DesignAddAndSearchWordsDataStructure {
	class WordDictionaryMap {
		TrieNode root;

		public WordDictionaryMap() {
			root = new TrieNode();
		}

		public void addWord(String word) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				if (!current.children.containsKey(ch)) {
					current.children.put(ch, new TrieNode());
				}
				current = current.children.get(ch);
			}
			current.isWord = true;
		}

		public boolean search(String word) {
			return searchHelper(root, 0, word);
		}

		public boolean searchHelper(TrieNode node, int k, String word) {
			if (k == word.length()) {
				return node.isWord;
			}
			if (node.children.size() == 0) {
				return false;
			}
			if (word.charAt(k) == '.') {
				for (char ch : node.children.keySet()) {
					TrieNode child = node.children.get(ch);

					if (child != null && searchHelper(child, k + 1, word)) {
						return true;
					}
				}
			} else {
				TrieNode child = node.children.get(word.charAt(k));
				if (child != null && searchHelper(child, k + 1, word)) {
					return true;
				}
			}
			return false;
		}
	}

	class WordDictionary {

		TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		public void addWord(String word) {
			TrieNode current = root;

			for (char ch : word.toCharArray()) {

				if (current.children[ch - 'a'] == null) {
					current.children[ch - 'a'] = new TrieNode();
				}
				current = current.children[ch - 'a'];
			}
			current.isWord = true;
		}

		public boolean search(String word) {
			return match(word, 0, root);
		}

		private boolean match(String word, int k, TrieNode node) {
			if (k == word.length()) {
				return node.isWord;
			}

			if (word.charAt(k) == '.') {
				for (int i = 0; i < node.children.length; i++) {
					TrieNode child = node.children[i];

					if (child != null && match(word, k + 1, child)) {
						return true;
					}
				}
			} else {
				TrieNode child = node.children[word.charAt(k) - 'a'];

				if (child != null && match(word, k + 1, child)) {
					return true;
				}
			}
			return false;
		}

		class TrieNode {
			TrieNode[] children;
			boolean isWord;

			TrieNode() {
				children = new TrieNode[26];
				isWord = false;
			}
		}
	}
}
