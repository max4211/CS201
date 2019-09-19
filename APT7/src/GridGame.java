
public class GridGame {
	
	private String[] myGrid;
	
    public int winningMoves(String[] grid){
    	myGrid = grid;
    	char[][] board = createBoard(grid);
    	return winCount(board);
   }
    
    private char[][] createBoard(String[] grid) {
    	char[][] board = new char[grid.length][grid[0].length()];
    	String cur;
    	for (int i = 0; i < grid.length; i ++) {
    		cur = grid[i];
    		for (int k = 0; k < grid.length; k ++) {
    			board[i][k] = cur.charAt(k);
    		}
    	}
		return board;
    	
    }
    
    private int winCount(char[][] board) {
    	int wins = 0;
    	// Generalize r and c max values to board length function
    	for (int r=0; r < 4; r ++) {
    		for (int c = 0; c < 4; c ++) {
    			if (canMove(board, r, c) ) {
    				board[r][c] = 'X';
    				int opponentWins = winCount(board);
    				if (opponentWins == 0) wins += 1;
    			}
    			board[r][c] = '.';
    		}
    	}
    	
    	return wins;
    }

	private boolean canMove(char[][] board, int r, int c) {
		if (inBounds(r, c)) {
			// Now check up down left right
			int[] rowDelta = {1, -1, 0, 0};
			int[] colDelta = {0, 0, 1, -1};
			for (int i = 0; i < rowDelta.length; i ++) {
				int nr = r + rowDelta[i];
				int nc = c + colDelta[i];
				if (inBounds(nr, nc)) {
					if (board[nr][nc] == 'X') return false;
				}
			}
			
		}
		return true;
	}

	// Verify this is correct
	private boolean inBounds(int r, int c) {
		if (c < myGrid[0].length() && r < myGrid.length) return true;
		return false;
	}
	
	public static void main (String[] args) {
		String[] grid = {"....", "....", "...." };
		System.out.println(grid.length);
		System.out.println(grid[0].length());
	}
}
