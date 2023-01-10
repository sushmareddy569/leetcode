package practice;

// 208 - Implement Trie (Prefix Tree)

public class ImplementTriePrefixTree {

	class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void insert(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				TrieNode node = current.children.get(ch);
				if (node == null) {
					node = new TrieNode();
					current.children.put(ch, node);
				}
				current = node;
			}
			current.isWord = true;
		}

		public boolean search(String word) {
			TrieNode node = searchPrefix(word);
			return node != null && node.isWord;
		}

		public boolean startsWith(String prefix) {
			TrieNode node = searchPrefix(prefix);
			return node != null;
		}

		public TrieNode searchPrefix(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (node == null) {
					return null;
				}
				node = node.children.get(ch);
			}
			return node;
		}
	}
}
