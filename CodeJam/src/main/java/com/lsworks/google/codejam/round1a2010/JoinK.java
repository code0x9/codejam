package com.lsworks.google.codejam.round1a2010;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

public class JoinK {

	public static void main(String[] args) throws IOException {
		JoinK joinK = new JoinK();
		joinK.calc();
	}

	private void calc() throws IOException {
		// File inputFile = new File(
		// "src/main/resources/round1a2010/joink-sample.txt");
		// File inputFile = new File(
		// "src/main/resources/round1a2010/A-small-practice.in");
		File inputFile = new File(
				"src/main/resources/round1a2010/A-large-practice.in");
		List<String> inputs = Files.readLines(inputFile, Charsets.UTF_8);
		int totalTest = Integer.parseInt(inputs.remove(0));

		for (int test = 1; test <= totalTest; test++) {
			String[] nk = inputs.remove(0).split(" ");
			int boardSize = Integer.parseInt(nk[0]);
			int condition = Integer.parseInt(nk[1]);

			char[][] board = new char[boardSize][boardSize];
			for (int row = 0; row < boardSize; row++) {
				String rowStr = inputs.remove(0);
				for (int col = 0; col < boardSize; col++) {
					board[row][col] = rowStr.charAt(col);
				}
			}

			char[][] rotatedBoard = rotate(board);
			String result = judge(rotatedBoard, condition);
			System.out.format("Case #%d: %s\n", test, result);
		}
	}

	private char[][] rotate(char[][] board) {
		char[][] rotatedBoard = new char[board.length][board.length];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length; col++) {
				rotatedBoard[row][col] = board[Math.abs(board.length - col - 1)][row];
			}
		}

		for (int col = 0; col < board.length; col++) {
			for (int row = board.length - 1; row >= 0; row--) {
				if (rotatedBoard[row][col] == '.') {
					// find first non .
					for (int i = row - 1; i >= 0; i--) {
						if (rotatedBoard[i][col] != '.') {
							rotatedBoard[row][col] = rotatedBoard[i][col];
							rotatedBoard[i][col] = '.';
							break;
						}
					}
				}
			}
		}

		return rotatedBoard;
	}

	private String judge(char[][] board, int condition) {
		// case is "Red", "Blue", "Neither", or "Both"
		boolean red = judge(board, condition, 'R');
		boolean blue = judge(board, condition, 'B');

		if (red && blue) {
			return "Both";
		} else if (blue) {
			return "Blue";
		} else if (red) {
			return "Red";
		} else {
			return "Neither";
		}
	}

	private boolean judge(char[][] board, int condition, char color) {
		// horiz
		int hitCount = 0;
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board.length - condition + 1; col++) {
				hitCount = 0;
				for (int check = 0; check < condition; check++) {
					if (board[row][col + check] == color) {
						hitCount++;
					}
				}
				if (hitCount == condition)
					return true;
			}
		}

		// vert
		for (int row = 0; row < board.length - condition + 1; row++) {
			for (int col = 0; col < board.length; col++) {
				hitCount = 0;
				for (int check = 0; check < condition; check++) {
					if (board[row + check][col] == color) {
						hitCount++;
					}
				}
				if (hitCount == condition)
					return true;
			}
		}

		// diag \
		for (int row = 0; row < board.length - condition + 1; row++) {
			for (int col = 0; col < board.length - condition + 1; col++) {
				hitCount = 0;
				for (int check = 0; check < condition; check++) {
					if (board[row + check][col + check] == color) {
						hitCount++;
					}
				}
				if (hitCount == condition)
					return true;
			}
		}

		// diag /
		for (int row = 0; row < board.length - condition + 1; row++) {
			for (int col = board.length - 1; col >= condition - 1; col--) {
				hitCount = 0;
				for (int check = 0; check < condition; check++) {
					if (board[row + check][col - check] == color) {
						hitCount++;
					}
				}
				if (hitCount == condition)
					return true;
			}
		}

		return false;
	}
}
