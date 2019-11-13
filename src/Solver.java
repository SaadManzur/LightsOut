public abstract class Solver {

    private int[][] board;
    private int boardWidth;
    private int boardHeight;

    Solver(int[][] board) {

        setBoard(board);
    }

    private void setBoard(int[][] board) {

        this.board = board;

        boardHeight = board.length;
        boardWidth = board[0].length;
    }

    public abstract int run();

    public boolean areLightsOut(State state) {

        for(int i = 0; i < boardHeight; i++) {

            for(int j = 0; j < boardWidth; j++) {

                if(state.get(i, j) == 1)
                    return false;
            }
        }

        return true;
    }
}
