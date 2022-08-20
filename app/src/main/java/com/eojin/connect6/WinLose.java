package com.eojin.connect6;

public class WinLose
{
		
	public int checkFinishGo(int x, int y) {

		if(checkHorizontal(x, y, MainPanel.exist[x][y]) >= 6) {
			return MainPanel.exist[x][y];
		}
		else if(checkVertical(x, y, MainPanel.exist[x][y]) >= 6) {
			return MainPanel.exist[x][y];
		}
		else if(checkLRDiagonal(x, y, MainPanel.exist[x][y]) >= 6) {
			return MainPanel.exist[x][y];
		}
		else if(checkRLDiagonal(x, y, MainPanel.exist[x][y]) >= 6) {
			return MainPanel.exist[x][y];
		}

		return 0;
	}

	// ���� Ȯ��
	private int checkHorizontal(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return checkLeft(row - 1, col, rock) + 1 + checkRight(row + 1, col, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	// ���� Ȯ��
	private int checkLeft(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkLeft(row - 1, col, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	// ������ Ȯ��
	private int checkRight(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkRight(row + 1, col, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	// ���� Ȯ��
	private int checkVertical(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return checkUp(row, col - 1, rock) + 1 + checkDown(row, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	// ���� Ȯ��
	private int checkUp(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkUp(row, col - 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	// �Ʒ��� Ȯ��
	private int checkDown(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkDown(row, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	// ������ ���� �������� �밢�� Ȯ��
	private int checkLRDiagonal(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return checkLRDiagonalUp(row - 1, col - 1, rock) + 1 + checkLRDiagonalDown(row + 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkLRDiagonalUp(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkLRDiagonalUp(row - 1, col - 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkLRDiagonalDown(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkLRDiagonalDown(row + 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}

	private int checkRLDiagonal(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return checkRLDiagonalUp(row + 1, col - 1, rock) + 1 + checkRLDiagonalDown(row - 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkRLDiagonalUp(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkRLDiagonalUp(row + 1, col - 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
	
	private int checkRLDiagonalDown(int row, int col, int rock) {
		try {
			if (MainPanel.exist[row][col] != rock)
				return 0;
			else {
				return 1 + checkRLDiagonalDown(row - 1, col + 1, rock);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return 0;
		}
	}
		
}
