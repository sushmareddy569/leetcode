package practice;

import java.util.HashSet;
import java.util.Set;

// 36 - Valid Sudoku

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		Set<String> seen = new HashSet<>();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char currentValue = board[i][j];

				if (currentValue != '.') {
					if (!seen.add(currentValue + "in row" + i)) {
						return false;
					}
					if (!seen.add(currentValue + "in column" + j)) {
						return false;
					}
					if (!seen.add(currentValue + "in block" + i / 3 + "-" + j / 3)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public boolean isValidSudoku1(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> rowSet = new HashSet<>();
			Set<Character> colSet = new HashSet<>();
			Set<Character> cubeSet = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				char c1 = board[i][j];
				char c2 = board[j][i];

				if (c1 != '.' && !rowSet.add(c1)) {
					return false;
				}
				if (c2 != '.' && !colSet.add(c2)) {
					return false;
				}

				int rowIndex = 3 * (i / 3) + (j / 3);
				int colIndex = 3 * (i % 3) + (j % 3);

				char c3 = board[rowIndex][colIndex];

				if (c3 != '.' && !cubeSet.add(c3)) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		ValidSudoku v = new ValidSudoku();
		char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

		System.out.println(v.isValidSudoku(board));
	}
}
