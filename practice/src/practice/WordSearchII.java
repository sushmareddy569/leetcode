package practice;

import java.util.ArrayList;
import java.util.List;

// 212 - Word Search II

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		TrieNode root = buildTrie(words);

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, result, i, j, root);
			}
		}
		return result;
	}

	public void dfs(char[][] board, List<String> result, int i, int j, TrieNode node) {
		char ch = board[i][j];

		if (ch == '#' || node.children[ch - 'a'] == null) {
			return;
		}
		node = node.children[ch - 'a'];
		if (node.word != null) {
			result.add(node.word);
			node.word = null;
		}
		board[i][j] = '#';
		if (i > 0) {
			dfs(board, result, i - 1, j, node);
		}
		if (i < board.length - 1) {
			dfs(board, result, i + 1, j, node);
		}
		if (j > 0) {
			dfs(board, result, i, j - 1, node);
		}
		if (j < board[0].length - 1) {
			dfs(board, result, i, j + 1, node);
		}
		board[i][j] = ch;
	}

	public TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();

		for (String word : words) {
			TrieNode current = root;
			for (char ch : word.toCharArray()) {
				if (current.children[ch - 'a'] == null) {
					current.children[ch - 'a'] = new TrieNode();
				}
				current = current.children[ch - 'a'];
			}
			current.word = word;
		}
		return root;
	}

	public class TrieNode {
		TrieNode[] children = new TrieNode[26];
		String word;
	}
}
